package BadBM.persist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DiskRunTest {

    /**
     * This test takes advantage of the 'C' of BICEP by cross checking the result of the getMax() method, which returns
     * a String, with the getRunMax() method which returns a double. It also checks to see that we get the correct value
     * for the Max.
     */
    @Test
    void getMaxCrossTest(){
        DiskRun diskRun = new DiskRun();
        diskRun.setMax(100);
        double doubleResult = diskRun.getRunMax();
        String stringResult = diskRun.getMax();

        assertEquals(doubleResult, Double.parseDouble(stringResult));
        assertEquals(doubleResult, 100);
        assertEquals(Double.parseDouble(stringResult), 100);
    }

    /**
     * Here we are able to force an error with the getDuration() method (This covers the 'E' of BICEP). We set the start
     * time of the run to 1,000s after 0, and the end time to 1,000,000 seconds after 0. Logically, this should return
     * a duration of 999,000s. However, we assert that this method does not return 999,000s, rather it produces an error.
     * It actually returns 39s
     */
    @Test
    void getDurationErrorCondition() {
        DiskRun diskRun = new DiskRun();
        diskRun.startTime = new Date(1_000);
        diskRun.setEndTime(new Date(1_000_000));

        String duration = diskRun.getDuration();

        assertNotEquals(duration, "999000s");
    }

    /**
     * This test asserts the Existence of an IOMode property in a DiskRun which we would expect to have such a field.
     * If the ioMode came back null in this circumstance, there would be an issue. This follows the 'E' of CORRECT
     */
    @Test
    void ioModeExistenceCheck() {
        DiskRun diskRun = new DiskRun(DiskRun.IOMode.READ, DiskRun.BlockSequence.RANDOM); //Using parameterized
        //constructor, as this is how the IOMode is expected to be set for a DiskRun

        DiskRun.IOMode ioMode = diskRun.getIoMode();

        assertNotNull(ioMode);
    }

    /**
     * This is a simple sets to see that getNumMarks() corrects returns the set number
     * of marks for the DiskRun. It takes advantage of ParameterizedTest to perform the
     * same test multiple times with different values.
     * @param arg
     */
    @ParameterizedTest
    @ValueSource(ints = {4, 9, 11, 19})
    void getNumMarksTest(int arg) {
        DiskRun diskRun = new DiskRun();
        diskRun.setNumMarks(arg);

        int numMarks = diskRun.getNumMarks();

        assertEquals(numMarks, arg);
    }

}
