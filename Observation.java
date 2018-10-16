/**
 * This is the observation class. It stores the individual observations for
 * every station to be used by the mapdata class in calculations of the
 * minimums, maximums, totals, and averages
 * 
 * @author Caelan Artajo
 * @version 2018-10-3
 */
public class Observation extends AbstractObservation
{
    private double value;
    private String stid;

    /**
     * This the constructor for the observation it's passed two parameters which
     * assist in reading and calculating the observations
     * 
     * @param value
     *            This is the actual read of the observation
     * @param stid
     *            This is the identifies the station where the read was taken
     */
    public Observation(double value, String stid)
    {
        this.value = value;
        this.stid = stid;
    }

    /**
     * This returns the value of the observation
     * 
     * @return value The value of the observation
     */
    public double getValue()
    {
        return value;
    }

    /**
     * 
     */
    @Override
    public boolean isValid()
    {
        if (value < -900)
        {
            super.valid = false;
        }
        else
        {
            super.valid = true;
        }
        return super.valid;
    }

    /**
     * Getter for the Station ID
     * 
     * @return stid The identifier of the observation
     */
    public String getStid()
    {
        return stid;
    }

    /**
     * Returns the observation in a readable format
     * 
     * @return string This is the readable string
     */
    public String toString()
    {
        return String.format("Station ID: %s, Value: %.1f", this.stid,
                this.value);
    }
}
