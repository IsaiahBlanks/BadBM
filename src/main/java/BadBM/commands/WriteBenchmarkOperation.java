package BadBM.commands;

import BadBM.ProgramInterface;

/**
 * This is a command class which allows you to run a basic Write Benchmark
 */
public class WriteBenchmarkOperation implements BenchmarkOperation{
    private int units;
    ProgramInterface programInterface;

    /**
     * Constructor for basic write disk benchmark
     * @param p Program Interface, which should be a ConsoleProgram
     * @param u units done so far, for processing progress bar
     */
    public WriteBenchmarkOperation(ProgramInterface p, int u) {
        programInterface = p;
        units = u;
    }

    /**
     * Execute the write benchmark
     * @return the number of units done
     */
    @Override
    public int execute() {
        WriteBenchmark writeBenchmark = new WriteBenchmark();
        return writeBenchmark.doWriteBenchmark(programInterface, units);
    }
}
