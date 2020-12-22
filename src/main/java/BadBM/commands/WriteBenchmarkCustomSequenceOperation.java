package BadBM.commands;

import BadBM.App;
import BadBM.ProgramInterface;
import BadBM.persist.DiskRun;

/**
 * This is a command class which allows you to run a Write Benchmark with a custom
 * sequence of disk blocks to be used
 */
public class WriteBenchmarkCustomSequenceOperation implements BenchmarkOperation {
    private int units;
    ProgramInterface programInterface;

    /**
     * Constructor for write benchmark with custom sequence of disk blocks
     * @param p Program Interface, which should be a ConsoleProgram
     * @param u units done so far, for processing progress bar
     * @param sequence sequence of blocks to do
     */
    public WriteBenchmarkCustomSequenceOperation(ProgramInterface p, int u, DiskRun.BlockSequence sequence) {
        App.blockSequence = sequence;
        programInterface = p;
        units = u;
    }

    /**
     * Execute the write benchmark with custom sequence of blocks
     * @return the number of units done
     */
    @Override
    public int execute() {
        WriteBenchmark writeBenchmark = new WriteBenchmark();
        return writeBenchmark.doWriteBenchmark(programInterface, units);
    }
}
