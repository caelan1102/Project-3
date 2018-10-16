import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * The statistics are more specialized observations, they are observations which
 * represent the maximum, minimum, average, and total values of different types
 * of observations. On top of this they store the date of the observation
 * 
 * @author Caelan Artajo
 * @version 2018-10-3
 *
 */
public class Statistics extends Observation implements DateTimeComparable
{
    protected final static String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss z";
    private GregorianCalendar utcDateTime;
    private int numberOfReportingStations;
    private StatsType statType;

    /**
     * The Constructor for a statistic observation, this particular constructor
     * is passed a date in the form of a string
     * 
     * @param value
     *            Value of the observation
     * @param stid
     *            Station ID where the observation was taken
     * @param dateTimeStr
     *            The string representation of the date
     * @param numberOfValidStations
     *            Number of stations taken into consideration when determining
     *            the value
     * @param inStatType
     *            The type of statistic
     * @throws ParseException
     *             Thrown if a date could not be parsed from dateTimeStr
     */
    public Statistics(double value, String stid, String dateTimeStr,
            int numberOfValidStations, StatsType inStatType)
            throws ParseException
    {
        super(value, stid);
        numberOfReportingStations = numberOfValidStations;
        GregorianCalendar dateTime = (this.createDateFromString(dateTimeStr));
        this.utcDateTime = dateTime;
        utcDateTime.setTimeZone(TimeZone.getTimeZone("UTC"));
        statType = inStatType;
    }

    /**
     * The Constructor for a statistic observation, this particular constructor
     * is passed a date in the form of a string
     * 
     * @param value
     *            Value of the observation
     * @param stid
     *            Station ID where the observation was taken
     * @param dateTime
     *            The calendar representation of the date
     * @param numberOfValidStations
     *            Number of stations taken into consideration when determining
     *            the value
     * @param inStatType
     *            The type of statistic from dateTimeStr
     */
    public Statistics(double value, String stid, GregorianCalendar dateTime,
            int numberOfValidStations, StatsType inStatType)
    {
        super(value, stid);
        this.numberOfReportingStations = numberOfValidStations;
        this.utcDateTime = (GregorianCalendar) dateTime.clone();
        this.utcDateTime.setTimeZone(TimeZone.getTimeZone("UTC"));
        statType = inStatType;
    }

    /**
     * Creates a gregorian calendar object by parsing the passed string
     * 
     * @param dateTimeStr
     *            The string passed from the constructor
     * @return The calendar representation of the string
     * @throws ParseException
     *             Thrown if a date cannot be parsed from the string
     */
    public GregorianCalendar createDateFromString(String dateTimeStr)
            throws ParseException
    {
        // Create the format in which the String is to be parsed
        SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_FORMAT);

        // Create the GregorianCalendar and set it by parsing the string
        GregorianCalendar dateTime = new GregorianCalendar();
        dateTime.setTime(format.parse(dateTimeStr));

        // Return it
        return dateTime;
    }

    /**
     * This creates a string based on a gregorian calendar object
     * 
     * @param calendar
     *            The date passed from the constructor
     * @return The string representation of the date
     */
    public String createStringFromDate(GregorianCalendar calendar)
    {
        // Return the string in the given format
        return String.format("%04d-%02d-%02dT%02d:%02d:%02d %s",
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND),
                calendar.getTimeZone().getDisplayName());
    }

    /**
     * Getter for the number of reporting stations
     * 
     * @return The number of reporting stations
     */
    public int getNumberOfReportingStations()
    {
        return numberOfReportingStations;
    }

    /**
     * Getter for the UTC string representation of the date
     * 
     * @return The UTC string representation of the date
     */
    public String getUTCDateTimeString()
    {
        // Return the string in the given format
        return String.format("%04d-%02d-%02dT%02d:%02d:%02d %s",
                utcDateTime.get(Calendar.YEAR), utcDateTime.get(Calendar.MONTH),
                utcDateTime.get(Calendar.DAY_OF_MONTH),
                utcDateTime.get(Calendar.HOUR_OF_DAY),
                utcDateTime.get(Calendar.MINUTE),
                utcDateTime.get(Calendar.SECOND),
                utcDateTime.getTimeZone().getDisplayName());

    }

    /**
     * Tests that this statistic's date is newer than the given date
     */
    @Override
    public boolean newerThan(GregorianCalendar date)
    {
        date.setTimeZone(TimeZone.getTimeZone("UTC"));
        if (utcDateTime.compareTo(date) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Tests that this statistic's date is older than the given date
     */
    @Override
    public boolean olderThan(GregorianCalendar date)
    {
        date.setTimeZone(TimeZone.getTimeZone("UTC"));
        if (this.utcDateTime.compareTo(date) < 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Tests that this statistic's date is the same as the given date
     */
    @Override
    public boolean sameAs(GregorianCalendar date)
    {
        date.setTimeZone(TimeZone.getTimeZone("UTC"));
        if (utcDateTime.compareTo(date) == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Returns the string form of this statistic
     */
    public String toString()
    {
        return super.toString() + String.format(
                ", Number of Reporting Stations: %d, StatType: %s",
                this.getNumberOfReportingStations(), this.statType);
    }
}
