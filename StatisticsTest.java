import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
     * This tests that constructor that uses a zonedDateTime rather than a
     * GregorianCalendar
     */
    @Test
    public void constructorZonedDateTimeTest()
    {
        fail("Not implemented yet");
        // Set example parameters
        double value = 12.0;
        String stid = "MESO";
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2018, 10, 2, 17, 35, 0, 0, ZoneId.of("CST"));
        StatsType sType = StatsType.AVERAGE;

        // This is the parameter to be tested
        int expectedValidStations = 10;

        // Object to Test
        Statistics statTest = new Statistics(value, stid, zonedDateTime,
                expectedValidStations, sType);

        // Test that the constructor worked
        int actualValidStations = statTest.getNumberOfReportingStations();
        Assert.assertEquals(expectedValidStations, actualValidStations);
    }

    /**
     * This tests that constructor that uses a GregorianCalendar rather than a
     * ZonedDateTime
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
    public void createStringFromDateGCTest()
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
    public void newerThanGCTest()
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
    public void olderThanGCTest()
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
    public void sameAsGCTest()
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
     * This tests the method which creates a String based on a zonedDateTime
     * representing the date of the statistics
     */
    @Test
    public void createStringFromDateZDTTest()
    {
        fail("Not implemented yet");
        // Set example parameters
        double value = 12.0;
        String stid = "MESO";
        int validStations = 10;
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2018, 10, 2, 17, 35, 0, 0, ZoneId.of("CST"));
        StatsType sType = StatsType.AVERAGE;

        // Object to Test
        Statistics statTest = new Statistics(value, stid, zonedDateTime,
                validStations, sType);

        // Test that the correct String was made
        String expectedTime = "2018-10-02T17:35:00 Central Standard Time";
        String actualTime = statTest.createStringFromDate(zonedDateTime);
        assertEquals(expectedTime, actualTime);
    }
    
    /**
     * This tests the method that determines whether the recorded statistics are
     * newer than a given zonedDateTime
     */
    @Test
    public void newerThanZDTTest()
    {
        fail("Not implemented yet");
        // Set example parameters
        double value = 12.0;
        String stid = "MESO";
        int validStations = 10;
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2018, 10, 2, 17, 35, 0, 0, ZoneId.of("CST"));
        StatsType sType = StatsType.AVERAGE;

        // Object to Test
        Statistics statTest = new Statistics(value, stid, zonedDateTime,
                validStations, sType);

        // Create times prior and after the date used
        ZonedDateTime newer = ZonedDateTime.of(2019, 10, 2, 17, 35, 0, 0, ZoneId.of("CST"));
        ZonedDateTime older = ZonedDateTime.of(2017, 10, 2, 17, 35, 0, 0, ZoneId.of("CST"));


        assertTrue(statTest.newerThan(older));
        assertTrue(!statTest.newerThan(newer));
    }

    /**
     * This tests the method that determines whether the recorded statistics are
     * older than a given zonedDateTime
     */
    @Test
    public void olderThanZDTTest()
    {
        fail("Not implemented yet");
        // Set example parameters
        double value = 12.0;
        String stid = "MESO";
        int validStations = 10;
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2018, 10, 2, 17, 35, 0, 0, ZoneId.of("CST"));
        StatsType sType = StatsType.AVERAGE;

        // Object to Test
        Statistics statTest = new Statistics(value, stid, zonedDateTime,
                validStations, sType);

        // Create times prior and after the date used
        ZonedDateTime newer = ZonedDateTime.of(2019, 10, 2, 17, 35, 0, 0, ZoneId.of("CST"));
        ZonedDateTime older = ZonedDateTime.of(2017, 10, 2, 17, 35, 0, 0, ZoneId.of("CST"));

        assertTrue(statTest.olderThan(newer));
        assertTrue(!statTest.olderThan(older));
    }

    /**
     * This tests the method that determines whether the recorded statistics are
     * the same as a given zonedDateTime
     */
    @Test
    public void sameAsZDTTest()
    {
        fail("Not implemented yet");
        // Set example parameters
        double value = 12.0;
        String stid = "MESO";
        int validStations = 10;
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2018, 10, 2, 17, 35, 0, 0, ZoneId.of("CST"));
        StatsType sType = StatsType.AVERAGE;

        // Object to Test
        Statistics statTest = new Statistics(value, stid, zonedDateTime,
                validStations, sType);

        // Create times the same as, prior, and after the date used
        ZonedDateTime same = ZonedDateTime.of(2018, 10, 2, 17, 35, 0, 0, ZoneId.of("CST"));
        ZonedDateTime newer = ZonedDateTime.of(2019, 10, 2, 17, 35, 0, 0, ZoneId.of("CST"));
        ZonedDateTime older = ZonedDateTime.of(2017, 10, 2, 17, 35, 0, 0, ZoneId.of("CST"));

        assertTrue(statTest.sameAs(same));
        assertTrue(!statTest.sameAs(newer));
        assertTrue(!statTest.sameAs(older));
    }
}
