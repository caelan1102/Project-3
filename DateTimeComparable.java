import java.util.GregorianCalendar;

/**
 * The interface DateTime comparable is inherited by Statistics to compare
 * statistics over different dates
 * 
 * @author caelan1102
 *
 */
public interface DateTimeComparable
{
    boolean newerThan(GregorianCalendar inDateTimeUTC);

    boolean olderThan(GregorianCalendar inDateTimeUTC);

    boolean sameAs(GregorianCalendar inDateTimeUTC);
}
