package BadBM;

import BadBM.ui.Gui;
import BadBM.ui.MainFrame;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsoleTest {
    private final CountDownLatch waiter = new CountDownLatch(1);

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
        App.console = true;
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

    @Test
    public void consoleTest() throws IOException, InterruptedException {
        setupDefaultAsPerProperties();

        App.startBenchmark();

        //wait for App.programInterface to be initialized
        while (!App.benchmarkStarted) {
            waiter.await(10, TimeUnit.MILLISECONDS);
        }

        //wait for the benchmark to finish
        while (!App.programInterface.getFinished()) {
            waiter.await(10, TimeUnit.MILLISECONDS);
        }

        assertTrue(App.programInterface.getProgress() >= 100);
    }
}
