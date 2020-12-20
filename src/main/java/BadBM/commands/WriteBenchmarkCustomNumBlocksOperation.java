package BadBM.commands;

import BadBM.App;
import BadBM.ProgramInterface;

/**
 * This is a command class which allows you to run a Write Benchmark using a custom
 * number of blocks
 */
public class WriteBenchmarkCustomNumBlocksOperation implements BenchmarkOperation {
    private int units;
    ProgramInterface programInterface;

    /**
     * Constructor for write benchmark with a custom number of disk blocks
     * @param p Program Interface, which should be a ConsoleProgram
     * @param u units done so far, for processing progress bar
     * @param num number of blocks to use
     */
    public WriteBenchmarkCustomNumBlocksOperation(ProgramInterface p, int u, int num) {
        App.numOfBlocks = num;
        programInterface = p;
        units = u;
    }

    /**
     * Execute the write benchmark with custom number of blocks
     * @return the number of units done
     */
    @Override
    public int execute() {
        WriteBenchmark writeBenchmark = new WriteBenchmark();
        return writeBenchmark.doWriteBenchmark(programInterface, units);
    }
}
