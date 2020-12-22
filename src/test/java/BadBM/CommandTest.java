package BadBM;

import BadBM.commands.ReadBenchmarkCustomNumBlocksOperation;
import BadBM.commands.WriteBenchmarkCustomNumMarksOperation;
import BadBM.ui.Gui;
import BadBM.ui.MainFrame;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Class to manage the testing of Command classes for custom benchmarking
 */
public class CommandTest {

    private void setupDefaultAsPerProperties()
    {
        /// Do the minimum of what  App.init() would do to allow to run.
        Gui.mainFrame = new MainFrame();
        App.p = new Properties();
        App.loadConfig();
        System.out.println(App.getConfigString());
        Gui.progressBar = Gui.mainFrame.getProgressBar(); //must be set or get Nullptr

        // configure the embedded DB in .jDiskMark
        System.setProperty("derby.system.home", App.APP_CACHE_DIR);

        // code from startBenchmark
        //4. create data dir reference
        App.dataDir = new File(App.locationDir.getAbsolutePath()+File.separator+App.DATADIRNAME);

        //5. remove existing test data if exist
        if (App.dataDir.exists()) {
            if (App.dataDir.delete()) {
                App.msg("removed existing data dir");
            } else {
                App.msg("unable to remove existing data dir");
            }
        }
        else
        {
            App.dataDir.mkdirs(); // create data dir if not already present
        }
    }

    /**
     * Test to verify that our WriteBenchmarkCustomNumMarksOperation command class does indeed run a write benchmark
     * with a specified number of marks, and that it finishes successfully
     */
    @Test
    public void writeCommandTest() {
        setupDefaultAsPerProperties();
        App.writeTest = true;
        App.readTest = false;

        ProgramInterface consoleProgram = new ConsoleProgram();

        consoleProgram.setRunning(true);
        int unitsComplete = 0;

        BenchmarkExecutor executor = new BenchmarkExecutor();

        //run a write benchmark with 55 marks instead of the default
        unitsComplete = executor.executeBenchmarkOperation(new WriteBenchmarkCustomNumMarksOperation(consoleProgram, unitsComplete, 55));

        /*The benchmark should return the total number of units used. This should be equal to our custom number of
        * marks multiplied by the default number of blocks
         */
        assertEquals(unitsComplete, 55 * App.numOfBlocks);
        assertTrue(consoleProgram.getProgress() >= 100);
    }

    /**
     * Test to verify that our ReadBenchmarkCustomNumBlocksOperation command class does indeed run a read benchmark
     * with a specified number of blocks, and that it finishes successfully
     */
    @Test
    public void readCommandTest() throws IOException, InterruptedException {
        setupDefaultAsPerProperties();
        App.writeTest = false;
        App.readTest = true;

        ProgramInterface consoleProgram = new ConsoleProgram();

        consoleProgram.setRunning(true);
        int unitsComplete = 0;

        BenchmarkExecutor executor = new BenchmarkExecutor();

        //run a read benchmark with 128 blocks instead of the default
        unitsComplete = executor.executeBenchmarkOperation(new ReadBenchmarkCustomNumBlocksOperation(consoleProgram, unitsComplete, 128));

        /*The benchmark should return the total number of units used. This should be equal to our custom number of
         * blocks multiplied by the default number of marks
         */
        assertEquals(unitsComplete, 128 * App.numOfMarks);
        assertTrue(consoleProgram.getProgress() >= 100);
    }
}
