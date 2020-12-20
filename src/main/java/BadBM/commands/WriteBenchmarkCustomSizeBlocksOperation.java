package BadBM.commands;

import BadBM.App;
import BadBM.ProgramInterface;

/**
 * This is a command class which allows you to run a Write Benchmark with a custom
 * size of disk blocks to be used
 */
public class WriteBenchmarkCustomSizeBlocksOperation implements BenchmarkOperation {
    private int units;
    ProgramInterface programInterface;

    /**
     * Constructor for write benchmark with custom size of disk blocks
     * @param p Program Interface, which should be a ConsoleProgram
     * @param u units done so far, for processing progress bar
     * @param size size of disk blocks to use
     */
    public WriteBenchmarkCustomSizeBlocksOperation(ProgramInterface p, int u, int size) {
        App.blockSizeKb = size;
        programInterface = p;
        units = u;
    }

    /**
     * Execute the write benchmark with custom size of blocks
     * @return the number of units done
     */
    @Override
    public int execute() {
        WriteBenchmark writeBenchmark = new WriteBenchmark();
        return writeBenchmark.doWriteBenchmark(programInterface, units);
    }
}
