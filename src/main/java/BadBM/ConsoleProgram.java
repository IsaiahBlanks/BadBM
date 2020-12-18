package BadBM;

import BadBM.DiskMark;
import BadBM.ProgramInterface;

public class ConsoleProgram implements ProgramInterface {
    int progress = 0;
    boolean running = false;
    boolean finished = false;
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

    @Override
    public void setMark(DiskMark mark) {
        System.out.println(mark);
    }

    @Override
    public void setRunning(Boolean val) {
        running = true;
    }

    @Override
    public void setFinished(Boolean val) {
        finished = val;
    }

    @Override
    public boolean getFinished() {
        return finished;
    }

    @Override
    public int getProgress() {
        return progress;
    }
}
