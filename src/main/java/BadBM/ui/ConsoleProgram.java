package BadBM.ui;

import BadBM.DiskMark;
import BadBM.ProgramInterface;

public class ConsoleProgram implements ProgramInterface {
    int progress = 0;
    @Override
    public void runBenchmark() {
    }

    @Override
    public void setProgressVal(int progress) {
        if(progress > this.progress) {
            System.out.println("Progress: " + progress);
        }
        this.progress = progress;
    }

    @Override
    public void publishMark(DiskMark mark) {
        System.out.println(mark);
    }

    @Override
    public void finish() {
    }

    @Override
    public boolean isCancel() {
        return false;
    }

    @Override
    public void addListenerForProperties() {
    }

    @Override
    public void displayMessage(String msg, String title) {
        System.out.println(title + ": " + msg);
    }

    @Override
    public void setTitle(String title) {
        System.out.println("---- " + title + " ----");
    }
}
