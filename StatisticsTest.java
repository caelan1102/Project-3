import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.GregorianCalendar;

/**
 * Tests made for the Statistics object
 * 
 * @author Caelan Artajo
 * @version 2018-10-3
 */
public class StatisticsTest
{
    /**
     * This tests that constructor that uses a dateTimeString rather than a
     * gregorianCalendar
     */
    @Test
    public void constructorTimeStringTest()
    {
        try
        {
            // Expected Values
            double value = 12.0;
            String stid = "MESO";
            String dateTimeString = "2018-11-02T17:35:00 Coordinated Universal "
                    + "Time";
            StatsType sType = StatsType.AVERAGE;

            // This is the parameter to be tested
            int expectedValidStations = 10;

            // Object to Test
            Statistics statTest = new Statistics(value, stid, dateTimeString,
                    expectedValidStations, sType);

            // Test that the constructor worked
            int actualValidStations = statTest.getNumberOfReportingStations();
            Assert.assertEquals(expectedValidStations, actualValidStations);
        }

        catch (ParseException e)
        {
            fail("A date could not be parsed from a legal date String");
        }
    }

    /**
     * This tests that constructor that uses a gregorianCalendar rather than a
     * dateTimeString
     */
    @Test
    public void constructorGregorianCalendarTest()
    {
        // Set example parameters
        double value = 12.0;
        String stid = "MESO";
        GregorianCalendar dateTime = new GregorianCalendar(2018, 10, 2, 17, 35);
        StatsType sType = StatsType.AVERAGE;

        // This is the parameter to be tested
        int expectedValidStations = 10;

        // Object to Test
        Statistics statTest = new Statistics(value, stid, dateTime,
                expectedValidStations, sType);

        // Test that the constructor worked
        int actualValidStations = statTest.getNumberOfReportingStations();
        Assert.assertEquals(expectedValidStations, actualValidStations);
    }

    /**
     * This tests the method which creates a gregorianCalendar based on a 
     * string representing the date of the statistics
     */
    @Test
    public void createDateFromStringTest()
    {
        try
        {
            // Expected Values
            double value = 12.0;
            String stid = "MESO";
            int validStations = 10;
            String dateTimeString = "2018-11-02T17:35:00 CDT";
            StatsType sType = StatsType.AVERAGE;

            // Object to Test
            Statistics statTest = new Statistics(value, stid, dateTimeString,
                    validStations, sType);

            // Test that the gregorian calendar was correctly made
            GregorianCalendar expectedDate = new GregorianCalendar(2018, 10, 2,
                    17, 35);
            GregorianCalendar actualDate = statTest
                    .createDateFromString(dateTimeString);

            assertEquals(expectedDate.getTime(), actualDate.getTime());
        }

        catch (ParseException e)
        {
            fail("Legal string threw an exception upon parsing");
        }

    }

    /**
     * This tests the method which creates a String based on a gregorianCalendar
     * representing the date of the statistics
     */
    @Test
    public void createStringFromDateTest()
    {
        // Set example parameters
        double value = 12.0;
        String stid = "MESO";
        int validStations = 10;
        GregorianCalendar dateTime = new GregorianCalendar(2018, 10, 2, 17, 35);
        StatsType sType = StatsType.AVERAGE;

        // Object to Test
        Statistics statTest = new Statistics(value, stid, dateTime,
                validStations, sType);

        // Test that the correct String was made
        String expectedTime = "2018-10-02T17:35:00 Central Standard Time";
        String actualTime = statTest.createStringFromDate(dateTime);
        assertEquals(expectedTime, actualTime);
    }

    /**
     * This tests the method which gets the date in the Coordinated Universal
     * Time zone
     */
    @Test
    public void getUTCDateTimeStringTest()
    {
        // Set example parameters
        double value = 12.0;
        String stid = "MESO";
        int validStations = 10;
        GregorianCalendar dateTime = new GregorianCalendar(2018, 10, 2, 17, 35);
        StatsType sType = StatsType.AVERAGE;

        // Object to Test
        Statistics statTest = new Statistics(value, stid, dateTime,
                validStations, sType);

        // Test that the time was correctly converted to UTC
        String expectedTime = "2018-10-02T17:35:00 Coordinated Universal Time";
        String actualTime = statTest.getUTCDateTimeString();
        assertEquals(expectedTime, actualTime);
    }

    /**
     * This tests the method that determines whether the recorded date is newer
     * than a given date
     */
    @Test
    public void newerThanTest()
    {
        // Set example parameters
        double value = 12.0;
        String stid = "MESO";
        int validStations = 10;
        GregorianCalendar dateTime = new GregorianCalendar(2018, 10, 2, 17, 35);
        StatsType sType = StatsType.AVERAGE;

        // Object to Test
        Statistics statTest = new Statistics(value, stid, dateTime,
                validStations, sType);

        // Create times prior and after the date used
        GregorianCalendar newer = new GregorianCalendar(2019, 10, 2, 17, 35);
        GregorianCalendar older = new GregorianCalendar(2017, 10, 2, 17, 35);

        assertTrue(statTest.newerThan(older));
        assertTrue(!statTest.newerThan(newer));
    }

    /**
     * This tests the method that determines whether the recorded date is older
     * than a given date
     */
    @Test
    public void olderThanTest()
    {
        // Set example parameters
        double value = 12.0;
        String stid = "MESO";
        int validStations = 10;
        GregorianCalendar dateTime = new GregorianCalendar(2018, 10, 2, 17, 35);
        StatsType sType = StatsType.AVERAGE;

        // Object to Test
        Statistics statTest = new Statistics(value, stid, dateTime,
                validStations, sType);

        // Create times prior and after the date used
        GregorianCalendar newer = new GregorianCalendar(2019, 10, 2, 17, 35);
        GregorianCalendar older = new GregorianCalendar(2017, 10, 2, 17, 35);

        assertTrue(statTest.olderThan(newer));
        assertTrue(!statTest.olderThan(older));
    }

    /**
     * This tests the method that determines whether the recorded date is the
     * same as a given date
     */
    @Test
    public void sameAsTest()
    {
        // Set example parameters
        double value = 12.0;
        String stid = "MESO";
        int validStations = 10;
        GregorianCalendar dateTime = new GregorianCalendar(2018, 10, 2, 17, 35);
        StatsType sType = StatsType.AVERAGE;

        // Object to Test
        Statistics statTest = new Statistics(value, stid, dateTime,
                validStations, sType);

        // Create times the same as, prior, and after the date used
        GregorianCalendar same = new GregorianCalendar(2018, 10, 2, 17, 35);
        GregorianCalendar newer = new GregorianCalendar(2019, 10, 2, 17, 35);
        GregorianCalendar older = new GregorianCalendar(2017, 10, 2, 17, 35);

        assertTrue(statTest.sameAs(same));
        assertTrue(!statTest.sameAs(newer));
        assertTrue(!statTest.sameAs(older));
    }

    /**
     * This tests that a string is correctly constructed from the parameters
     * passed to the Statistics constructor
     */
    @Test
    public void toStringTest()
    {
        // Set example parameters
        double value = 12.0;
        String stid = "MESO";
        int validStations = 10;
        GregorianCalendar dateTime = new GregorianCalendar(2018, 10, 2, 17, 35);
        StatsType sType = StatsType.AVERAGE;

        // Object to Test
        Statistics statTest = new Statistics(value, stid, dateTime,
                validStations, sType);

        String expected = "Station ID: MESO, Value: 12.0,"
                + " Number of Reporting Stations: 10, StatType: AVERAGE";

        // ", Number of Reporting Stations: %d, StatType: %s"
        // , this.getNumberOfReportingStations(), this.statType);

        String actual = statTest.toString();

        assertEquals(expected, actual);
    }
}
