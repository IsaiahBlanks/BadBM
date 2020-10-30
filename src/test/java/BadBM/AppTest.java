package BadBM;

import BadBM.ui.Gui;
import BadBM.ui.MainFrame;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    /**
     * This test checks for a 'Right' result from the targetMarkSizeKb() method. The correct answer is that the block
     * size for each mark is 512, so it must be some multiple of 512. If it isn't, we are set to the wrong value
     */
    @Test
    public void targetMarkSizeKbTest() {
        long returnVal = App.targetMarkSizeKb();
        assertEquals(returnVal % 512, 0);
    }

    /**
     * This test checks to see that the getVersion() method returns a string that conforms to the X.X format, as
     * outlined by the 'Conformance' guideline of CORRECT.
     */
    @Test
    public void getVersionFormatConformanceTest() {
        App app = new App();

        String version = App.getVersion();
        System.out.println(version);

        assertTrue(version.matches("\\d{1}.\\d{1}"));
    }

    /**
     * This test checks to see what happens when we pass a new DiskMark that hasn't had any data set into
     * updateMetricsBoundary(). This is to check for the existence of issues at Boundary conditions, as this is
     * essentially a null DiskMark.
     */
    @Test
    public void updateMetricsBoundaryTest() {
        DiskMark mark = new DiskMark(DiskMark.MarkType.READ);

        App.updateMetrics(mark);

        assertNotNull(App.rMax);
        assertNotNull(App.rMin);
        assertNotNull(App.rAvg);
    }

    /**
     * This test uses the 'P' of BICEP to test the performance of the application. If it is taking too long to do the
     * benchmark, this is likely due to some issue with the application, and not the drive. We set the duration to be
     * quite long. This isn't supposed to fail for slow drives, only for issues with the application ie. if it hangs.
     */
    @Test
    public void benchmarkPerformanceWriteTest() {
        setupDefaultAsPerProperties();
        App.readTest = false; //Write and Read are both true by default. Setting this to false will run a write test
        App.startBenchmark();
        long startTime = System.currentTimeMillis();

        while (!App.worker.isDone()) {
            //wait
        }
        long duration = System.currentTimeMillis() - startTime;

        assertTrue(duration < 300_000); //Assert benchmark took less than 300 seconds

    }

    /**
     * Bruteforce setup of static classes/fields to allow DiskWorker to run.
     *
     * @author lcmcohen
     */
    private void setupDefaultAsPerProperties()
    {
        /// Do the minimum of what  App.init() would do to allow to run.
        Gui.mainFrame = new MainFrame();
        App.p = new Properties();
        App.loadConfig();
        System.out.println(App.getConfigString());
        Gui.progressBar = Gui.mainFrame.getProgressBar(); //must be set or get Nullptr

        // configure the embedded DB in .jDiskMark
        System.setProperty("derby.system.home", App.APP_CACHE_DIR);

        // code from startBenchmark
        //4. create data dir reference
        App.dataDir = new File(App.locationDir.getAbsolutePath()+File.separator+App.DATADIRNAME);

        //5. remove existing test data if exist
        if (App.dataDir.exists()) {
            if (App.dataDir.delete()) {
                App.msg("removed existing data dir");
            } else {
                App.msg("unable to remove existing data dir");
            }
        }
        else
        {
            App.dataDir.mkdirs(); // create data dir if not already present
        }
    }
}
