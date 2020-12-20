package BadBM.commands;

import BadBM.App;
import BadBM.DiskMark;
import BadBM.ProgramInterface;
import BadBM.Util;
import BadBM.persist.DiskRun;
import BadBM.persist.EM;
import BadBM.ui.Gui;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import static BadBM.App.*;
import static BadBM.App.msg;
import static BadBM.DiskMark.MarkType.WRITE;

/**
 * Receiver class for Write Benchmark commands. Performs the actual benchmark operation. The DiskRun class is used to
 * keep track of and persist info about each benchmark at a higher level (a run), while the DiskMark class describes
 * each iteration's result, which is displayed by the UI as the benchmark run progresses.
 */
public class WriteBenchmark {

    public int doWriteBenchmark(ProgramInterface programInterface, int units) {
        // declare local vars formerly in DiskWorker

        DiskMark wMark;
        int startFileNum = App.nextMarkNumber;

        int wUnitsComplete = 0,
            rUnitsComplete = units,
            unitsComplete;

        int wUnitsTotal = App.writeTest ? numOfBlocks * numOfMarks : 0;
        int rUnitsTotal = App.readTest ? numOfBlocks * numOfMarks : 0;
        int unitsTotal = wUnitsTotal + rUnitsTotal;
        float percentComplete;

        int blockSize = blockSizeKb*KILOBYTE;
        byte [] blockArr = new byte [blockSize];
        for (int b=0; b < blockArr.length; b++) {
            if (b%2==0) {
                blockArr[b]=(byte)0xFF;
            }
        }

        DiskRun run = initializeRun(DiskRun.IOMode.WRITE);

        programInterface.setTitle(run.getDiskInfo());

        createDataFile();

        /**
         * Begin an outer loop for specified duration (number of 'marks') of benchmark,
         * that keeps writing data (in its own loop - for specified # of blocks). Each 'Mark' is timed
         * and is reported to the GUI for display as each Mark completes.
         */
        for (int m = startFileNum; m < startFileNum + App.numOfMarks && !programInterface.isCancel(); m++) {

            if (App.multiFile) {
                testFile = new File(dataDir.getAbsolutePath()
                        + File.separator + "testdata" + m + ".jdm");
            }
            wMark = new DiskMark(WRITE);    // starting to keep track of a new bench Mark
            wMark.setMarkNum(m);
            long startTime = System.nanoTime();
            long totalBytesWrittenInMark = 0;

            String mode = "rw";
            if (App.writeSyncEnable) {
                mode = "rwd";
            }

            try {
                try (RandomAccessFile rAccFile = new RandomAccessFile(testFile, mode)) {
                    for (int b = 0; b < numOfBlocks; b++) {
                        if (App.blockSequence == DiskRun.BlockSequence.RANDOM) {
                            int rLoc = Util.randInt(0, numOfBlocks - 1);
                            rAccFile.seek(rLoc * blockSize);
                        } else {
                            rAccFile.seek(b * blockSize);
                        }
                        rAccFile.write(blockArr, 0, blockSize);
                        totalBytesWrittenInMark += blockSize;
                        wUnitsComplete++;
                        unitsComplete = rUnitsComplete + wUnitsComplete;
                        percentComplete = (float) unitsComplete / (float) unitsTotal * 100f;

                        /**
                         * Report to GUI what percentage level of Entire BM (#Marks * #Blocks) is done.
                         */
                        programInterface.setProgressVal((int) percentComplete);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }

            /**
             * Compute duration, throughput of this Mark's step of BM
             */
            long endTime = System.nanoTime();
            long elapsedTimeNs = endTime - startTime;
            double sec = (double) elapsedTimeNs / (double) 1000000000;
            double mbWritten = (double) totalBytesWrittenInMark / (double) MEGABYTE;
            wMark.setBwMbSec(mbWritten / sec);
            msg("m:" + m + " write IO is " + wMark.getBwMbSecAsString() + " MB/s     "
                    + "(" + Util.displayString(mbWritten) + "MB written in "
                    + Util.displayString(sec) + " sec)");
            App.updateMetrics(wMark);

            /**
             * Let the GUI know the interim result described by the current Mark
             */
            programInterface.setMark(wMark);

            // Keep track of statistics to be displayed and persisted after all Marks are done.
            run.setRunMax(wMark.getCumMax());
            run.setRunMin(wMark.getCumMin());
            run.setRunAvg(wMark.getCumAvg());
            run.setEndTime(new Date());
        } // END outer loop for specified duration (number of 'marks') for WRITE bench mark

        /**
         * Persist info about the Write BM Run (e.g. into Derby Database) and add it to a GUI panel
         */
        EntityManager em = EM.getEntityManager();
        em.getTransaction().begin();
        em.persist(run);
        em.getTransaction().commit();

        Gui.runPanel.addRun(run);
        return wUnitsComplete;
    }

    private void createDataFile() {
        // Create a test data file using the default file system and config-specified location
        if (!App.multiFile) {
            testFile = new File(dataDir.getAbsolutePath() + File.separator + "testdata.jdm");
        }
    }

    private DiskRun initializeRun(DiskRun.IOMode write) {
        DiskRun run = new DiskRun(write, App.blockSequence);
        setRunConfig(run);

        // Tell logger and GUI to display what we know so far about the Run
        msg("disk info: (" + run.getDiskInfo() + ")");
        return run;
    }

    private void setRunConfig(DiskRun run) {
        run.setNumMarks(App.numOfMarks);
        run.setNumBlocks(App.numOfBlocks);
        run.setBlockSize(App.blockSizeKb);
        run.setTxSize(App.targetTxSizeKb());
        run.setDiskInfo(Util.getDiskInfo(dataDir));
    }
}
