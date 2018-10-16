import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests for the Observation object
 * 
 * @author Caelan Artajo
 * @version 2018-10-3
 */
public class ObservationTest
{
    /**
     * This tests the Observation constructor and its getters
     */
    @Test
    public void constructorTest()
    {
        // Create expected observation
        double expectedValue = 2.1;
        String expectedStid = "MESO";
        Observation obs = new Observation(expectedValue, expectedStid);

        // Test against actual output
        assertEquals(expectedValue, obs.getValue(), 0);
        assertEquals(expectedStid, obs.getStid());
    }

    /**
     * This tests whether or not an observation is valid to use in calculating
     * statistics. This eliminates the need to test the AbstractObservation
     */
    @Test
    public void isValidTest()
    {
        // Create a valid observation
        double validValue = 2.1;
        String Stid = "MESO";
        Observation validObs = new Observation(validValue, Stid);

        // Create an invalid observation
        double invalidValue = -999;
        Observation invalidObs = new Observation(invalidValue, Stid);

        assertTrue(validObs.isValid());
        assertFalse(invalidObs.isValid());
    }

    /**
     * This tests Observation's toString method
     */
    @Test
    public void toStringTest()
    {
        // Create the observation with the expected values
        double Value = 2.1;
        String Stid = "MESO";
        Observation obs = new Observation(Value, Stid);

        // Create the expected and actual String to compare
        String expected = "Station ID: MESO, Value: 2.1";
        String actual = obs.toString();

        // Compare the two
        assertEquals(expected, actual);
    }
}
