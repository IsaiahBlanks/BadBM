package BadBM;

import java.util.List;

public interface ProgramInterface {

    void runBenchmark();

    void setProgressVal(int progress);

    boolean isCancel();

    void addListenerForProperties();

    void displayMessage(String msg, String title);

    void setTitle(String title);

    void setMark(DiskMark mark);

    void setRunning(Boolean val);

    void setFinished(Boolean val);

    boolean getFinished();

    int getProgress();

}
