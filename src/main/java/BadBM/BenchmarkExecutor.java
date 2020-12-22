package BadBM;

import BadBM.commands.BenchmarkOperation;

/**
 * Simple execution layer for Benchmark Commands
 */
public class BenchmarkExecutor {

    /**
     * Executes benchmark commands
     * @param benchmarkOperation The class which represents the type of command to run
     * @return number of units processed in this command. This is relevant to the UI
     */
    public int executeBenchmarkOperation(BenchmarkOperation benchmarkOperation) {
        return benchmarkOperation.execute();
    }
}
