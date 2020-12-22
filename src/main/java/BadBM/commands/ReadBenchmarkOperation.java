package BadBM.commands;

import BadBM.ProgramInterface;

/**
 * This is a command class which allows you to run a basic Read Benchmark
 */
public class ReadBenchmarkOperation implements BenchmarkOperation{
    private int units;

    ProgramInterface programInterface;

    /**
     * Constructor for basic read disk benchmark
     * @param p Program Interface, which should be a ConsoleProgram
     * @param u units done so far, for processing progress bar
     */
    public ReadBenchmarkOperation(ProgramInterface p, int u) {
        programInterface = p;
        units = u;
    }

    /**
     * Execute the read benchmark
     * @return the number of units done
     */
    @Override
    public int execute() {
        ReadBenchmark readBenchmark = new ReadBenchmark();
        return readBenchmark.doReadBenchmark(programInterface, units);
    }
}
