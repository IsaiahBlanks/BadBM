package BadBM;

import BadBM.ui.Gui;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.util.List;

import static BadBM.App.dataDir;
import static BadBM.DiskMark.MarkType.WRITE;

public class SwingProgram extends SwingWorker<Boolean, DiskMark> implements ProgramInterface {
    @Override
    public void runBenchmark() {

        execute();
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        Gui.updateLegend();

        if (App.autoReset) {
            App.resetTestData();
            Gui.resetTestData();
        }

        return null;
    }

    @Override
    public void setProgressVal(int progress) {
        setProgress(progress);
    }

    @Override
    public void publishMark(DiskMark mark) {
        publish(mark);
    }

    @Override
    public void finish() {

    }

    @Override
    public boolean isCancel() {
        return isCancelled();
    }

    @Override
    public void addListenerForProperties() {
        addPropertyChangeListener((final PropertyChangeEvent event) -> {
            switch (event.getPropertyName()) {
                case "progress":
                    int value = (Integer) event.getNewValue();
                    Gui.progressBar.setValue(value);
                    long kbProcessed = (value) * App.targetTxSizeKb() / 100;
                    Gui.progressBar.setString(kbProcessed + " / " + App.targetTxSizeKb());
                    break;
                case "state":
                    switch ((StateValue) event.getNewValue()) {
                        case STARTED:
                            Gui.progressBar.setString("0 / " + App.targetTxSizeKb());
                            break;
                        case DONE:
                            break;
                    } // end inner switch
                    break;
            }
        });
    }

    @Override
    public void displayMessage(String msg, String title) {
        JOptionPane.showMessageDialog(Gui.mainFrame, msg, title, JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public void setTitle(String title) {
        Gui.chartPanel.getChart().getTitle().setVisible(true);
        Gui.chartPanel.getChart().getTitle().setText(title);
    }

    @Override
    protected void process(List<DiskMark> markList) {
        /**
         * We are passed a list of one or more DiskMark objects that our thread has previously
         * published to Swing. Watch Professor Cohen's video - Module_6_RefactorBadBM Swing_DiskWorker_Tutorial.mp4
         */
        markList.stream().forEach((dm) -> {
            if (dm.type == WRITE) {
                Gui.addWriteMark(dm);
            } else {
                Gui.addReadMark(dm);
            }
        });
    }

    @Override
    protected void done() {
        if (App.autoRemoveData) {
            Util.deleteDirectory(dataDir);
        }
        App.state = App.State.IDLE_STATE;
        Gui.mainFrame.adjustSensitivity();
    }
}
