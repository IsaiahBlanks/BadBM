package BadBM.commands;

import BadBM.App;
import BadBM.ProgramInterface;

/**
 * This is a command class which allows you to run a Read Benchmark with a custom
 * number of disk marks to be used
 */
public class ReadBenchmarkCustomNumMarksOperation implements BenchmarkOperation {
    private int units;

    ProgramInterface programInterface;

    /**
     * Constructor for read benchmark with custom number of disk marks
     * @param p Program Interface, which should be a ConsoleProgram
     * @param u units done so far, for processing progress bar
     * @param marks number of disk marks to use
     */
    public ReadBenchmarkCustomNumMarksOperation(ProgramInterface p, int u, int marks) {
        App.numOfMarks = marks;
        programInterface = p;
        units = u;
    }

    /**
     * Execute the read benchmark with custom disk marks
     * @return the number of units done
     */
    @Override
    public int execute() {
        ReadBenchmark readBenchmark = new ReadBenchmark();
        return readBenchmark.doReadBenchmark(programInterface, units);
    }
}
