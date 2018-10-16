/**
 * This is an abstract of the observation class
 * 
 * @author caelan1102
 * @version 2018-10-3
 */
public abstract class AbstractObservation
{
    protected boolean valid;

    /**
     * The constructor for the abstract observation
     */
    public AbstractObservation()
    {
        valid = true;
    }

    /**
     * This returns valid as all observations are valid until they're given a
     * value, which abstract observations can't have
     * 
     * @return true
     */
    public boolean isValid()
    {
        return true;
    }
}
