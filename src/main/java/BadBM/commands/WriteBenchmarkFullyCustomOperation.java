package BadBM.commands;

import BadBM.App;
import BadBM.ProgramInterface;
import BadBM.persist.DiskRun;

/**
 * This is a class to run a fully custom Write Benchmark. It allows you to change all the relevant properties via
 * its constructor
 */
public class WriteBenchmarkFullyCustomOperation implements BenchmarkOperation {
    private int units;

    ProgramInterface programInterface;

    /**
     * Constructor for fully custom write disk benchmark
     * @param p Program Interface, which should be a ConsoleProgram
     * @param u units done so far, for processing progress bar
     * @param numBlocks number of Disk Blocks to be used
     * @param numMarks number of Disk Marks to be done
     * @param sequence sequence of Disk Blocks to be used
     * @param size size of Disk Blocks to be used
     */
    public WriteBenchmarkFullyCustomOperation(ProgramInterface p, int u, int numBlocks,
                                              int numMarks, DiskRun.BlockSequence sequence, int size) {
        programInterface = p;
        units = u;
        App.numOfBlocks = numBlocks;
        App.numOfMarks = numMarks;
        App.blockSequence = sequence;
        App.blockSizeKb = size;
    }

    /**
     * Execute the custom write benchmark
     * @return the number of units done
     */
    @Override
    public int execute() {
        WriteBenchmark writeBenchmark = new WriteBenchmark();
        return writeBenchmark.doWriteBenchmark(programInterface, units);
    }
}
