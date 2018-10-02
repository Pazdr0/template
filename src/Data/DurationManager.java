package Data;

import java.time.Duration;

/*
 * Final class managing duration variables
 * Constructor is private so that an object can't of this class be created
 * It's only being used for calculations
 * */
public final class DurationManager {
	
    private DurationManager() {}

    /*
     * Addition of duration variable and duration saved as string
     * Works only if format of string is 'H:m'.
     * Method should throw an custom exception (to be added)
     * TODO create exception like 'WrongFormatException' to be thrown by this method
     * */
    public static Duration addTime(Duration timeSum, String timeToAdd) {
        Duration temp = Duration.ZERO;
        String[] timeComponents = timeToAdd.split(":");
        temp = timeSum.plus(Duration.ofHours(Integer.parseInt(timeComponents[0])).plusMinutes(Integer.parseInt(timeComponents[1])));

        return temp;
    }
    
    /*
     * Method to compare duration with restriction
     * */
    public static boolean compareDuration(Duration duration, int restriction) {
        if (duration.toMinutes() >= restriction) {
            return true;
        } else {
            return false;
        }
    }

}
