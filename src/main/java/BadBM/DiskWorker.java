package BadBM;

import BadBM.commands.ReadBenchmarkOperation;
import BadBM.commands.WriteBenchmarkOperation;

import java.io.IOException;

import static BadBM.App.msg;

/**
 * Run the disk benchmark. Updates the ProgramInterface Object to allow either GUI or console to show run data
 * <p>
 * Depends on static values that describe the benchmark to be done having been set in App and Gui classes.
 * The DiskRun class is used to keep track of and persist info about each benchmark at a higher level (a run),
 * while the DiskMark class describes each iteration's result, which is displayed by the UI as the benchmark run
 * progresses.
 * <p>
 * This class only knows how to do 'read' or 'write' disk benchmarks. It is instantiated by the
 * startBenchmark() method.
 * <p>
 */

public class DiskWorker extends Thread {

    private final ProgramInterface programInterface;

    public DiskWorker(ProgramInterface userInterface) {
        programInterface = userInterface;
        programInterface.runBenchmark();
    }

    @Override
    public void run() {
        try {
            doBenchmark();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is the method that runs the essential disk benchmark. It runs in its own thread. It is run by calling
     * worker.start() from the startBenchmark() method in App(). It feeds progress and results data to a
     * ProgramInterface object.
     */
    public Boolean doBenchmark() throws IOException {

        programInterface.setRunning(true);
        int unitsComplete = 0;
        System.out.println("*** starting new worker thread");
        msg("Running readTest " + App.readTest + "   writeTest " + App.writeTest);
        msg("num files: " + App.numOfMarks + ", num blks: " + App.numOfBlocks
                + ", blk size (kb): " + App.blockSizeKb + ", blockSequence: " + App.blockSequence);

        BenchmarkExecutor executor = new BenchmarkExecutor();

        if (App.writeTest) {
            unitsComplete = executor.executeBenchmarkOperation(new WriteBenchmarkOperation(programInterface, unitsComplete));
        }

        /*
          Most benchmarking systems will try to do some cleanup in between 2 benchmark operations to
          make it more 'fair'. For example a networking benchmark might close and re-open sockets,
          a memory benchmark might clear or invalidate the Op Systems TLB or other caches, etc.
         */
        // try renaming all files to clear catch
        if (App.readTest && App.writeTest && !programInterface.isCancel()) {
            programInterface.displayMessage("For valid READ measurements please clear the disk cache by\n" +
                            "using the included RAMMap.exe or flushmem.exe utilities.\n" +
                            "Removable drives can be disconnected and reconnected.\n" +
                            "For system drives use the WRITE and READ operations \n" +
                            "independantly by doing a cold reboot after the WRITE",
                    "Clear Disk Cache Now");
        }

        // Same as above, just for Read operations instead of Writes.
        if (App.readTest) {
            unitsComplete = executor.executeBenchmarkOperation(new ReadBenchmarkOperation(programInterface, unitsComplete));
        }

        App.nextMarkNumber += App.numOfMarks;
        programInterface.setRunning(false);
        programInterface.setFinished(true); //needed for console test
        return true;
    }
}
