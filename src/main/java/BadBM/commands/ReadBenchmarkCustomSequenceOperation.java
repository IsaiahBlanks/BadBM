package BadBM.commands;

import BadBM.App;
import BadBM.ProgramInterface;
import BadBM.persist.DiskRun;

/**
 * This is a command class which allows you to run a Read Benchmark with a custom
 * sequence of disk blocks to be used
 */
public class ReadBenchmarkCustomSequenceOperation implements BenchmarkOperation {
    private int units;

    ProgramInterface programInterface;

    /**
     * Constructor for read benchmark with custom sequence of disk blocks
     * @param p Program Interface, which should be a ConsoleProgram
     * @param u units done so far, for processing progress bar
     * @param sequence sequence of blocks to do
     */
    public ReadBenchmarkCustomSequenceOperation(ProgramInterface p, int u, DiskRun.BlockSequence sequence) {
        App.blockSequence = sequence;
        programInterface = p;
        units = u;
    }

    /**
     * Execute the read benchmark with custom sequence of blocks
     * @return the number of units done
     */
    @Override
    public int execute() {
        ReadBenchmark readBenchmark = new ReadBenchmark();
        return readBenchmark.doReadBenchmark(programInterface, units);
    }
}
