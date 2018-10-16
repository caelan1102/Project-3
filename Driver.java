import java.io.IOException;

/**
 * The driver class which passes the date, time, and directory location of and
 * mdf file. These parameters are used to make the name of the file to be
 * parsed. The file contains weather readings from different stations at the
 * time specified by the name of the file. These readings are then read and
 * minimum, maximum, and average values for the air temperature(both at 1.5m and
 * at 9m) and the solar radiation are found and displayed.
 * 
 * @author Caelan Artajo
 * @version 2018-10-3
 * 
 *
 */
public class Driver
{
    /**
     * This is the entry point for the driver, where the mapdata is passed its
     * parameters and the results are displayed
     * 
     * @param args
     *            The body of the driver
     * @throws IOException
     *             in case the file fails to be read
     */
    public static void main(String[] args) throws IOException
    {

        final int YEAR = 2018;
        final int MONTH = 8;
        final int DAY = 30;
        final int HOUR = 17;
        final int MINUTE = 45;

        final String DIRECTORY = "data";

        MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE,
                DIRECTORY);

        mapData.parseFile();
        System.out.println(mapData.toString());
    }

}