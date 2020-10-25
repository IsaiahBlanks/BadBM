package BadBM;

import java.util.List;

public interface ProgramInterface {

    void runBenchmark();

    void setProgressVal(int progress);

    void publishMark(DiskMark mark);

    void finish();

    boolean isCancel();

    void addListenerForProperties();

    void displayMessage(String msg, String title);

    void setTitle(String title);

}
