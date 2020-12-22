package BadBM.commands;

import BadBM.App;
import BadBM.ProgramInterface;

/**
 * This is a command class which allows you to run a Write Benchmark with a custom
 * number of disk marks to be used
 */
public class WriteBenchmarkCustomNumMarksOperation implements BenchmarkOperation {
    private int units;

    ProgramInterface programInterface;

    /**
     * Constructor for write benchmark with custom number of disk marks
     * @param p Program Interface, which should be a ConsoleProgram
     * @param u units done so far, for processing progress bar
     * @param marks number of disk marks to use
     */
    public WriteBenchmarkCustomNumMarksOperation(ProgramInterface p, int u, int marks) {
        App.numOfMarks = marks;
        programInterface = p;
        units = u;
    }

    /**
     * Execute the write benchmark with custom disk marks
     * @return the number of units done
     */
    @Override
    public int execute() {
        WriteBenchmark writeBenchmark = new WriteBenchmark();
        return writeBenchmark.doWriteBenchmark(programInterface, units);
    }
}
