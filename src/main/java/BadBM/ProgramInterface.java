package BadBM;

import java.util.List;

/**
 * This interface defines the basic capabilites of a class which allows the user to interface with the
 * BadBM application, whether executing via the console or Swing. It provides all the methods necessary for a
 * Read or Write benchmark to make its results meaningful
 */
public interface ProgramInterface {

    /**
     * Initiate tracking of the benchmark
     */
    void runBenchmark();

    /**
     * Set current progress amount
     * @param progress number representing progress
     */
    void setProgressVal(int progress);

    /**
     * @return Whether or not the benchmark is cancelled
     */
    boolean isCancel();

    /**
     * Adds a listener to the benchmark to check in updates on properties
     */
    void addListenerForProperties();

    /**
     * Allows the benchmark to display important messages
     * @param msg the message to display
     * @param title message title
     */
    void displayMessage(String msg, String title);

    /**
     * Allows the program to set a title for the benchmark
     * @param title title
     */
    void setTitle(String title);

    /**
     * Allows the program to set the current mark relevant to the UI
     * @param mark the Disk Mark
     */
    void setMark(DiskMark mark);

    void setRunning(Boolean val);

    void setFinished(Boolean val);

    boolean getFinished();

    int getProgress();

}
