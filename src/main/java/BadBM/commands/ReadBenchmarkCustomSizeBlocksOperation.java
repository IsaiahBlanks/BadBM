package BadBM.commands;

import BadBM.App;
import BadBM.ProgramInterface;

/**
 * This is a command class which allows you to run a Read Benchmark with a custom
 * size of disk blocks to be used
 */
public class ReadBenchmarkCustomSizeBlocksOperation implements BenchmarkOperation {
    private int units;

    ProgramInterface programInterface;

    /**
     * Constructor for read benchmark with custom size of disk blocks
     * @param p Program Interface, which should be a ConsoleProgram
     * @param u units done so far, for processing progress bar
     * @param size size of disk blocks to use
     */
    public ReadBenchmarkCustomSizeBlocksOperation(ProgramInterface p, int u, int size) {
        App.blockSizeKb = size;
        programInterface = p;
        units = u;
    }

    /**
     * Execute the read benchmark with custom size of blocks
     * @return the number of units done
     */
    @Override
    public int execute() {
        ReadBenchmark readBenchmark = new ReadBenchmark();
        return readBenchmark.doReadBenchmark(programInterface, units);
    }
}
