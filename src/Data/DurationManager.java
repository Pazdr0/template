package Data;

import java.time.Duration;

import Data.Model.TimeRestrictions;

/*
 * Final class managing duration variables
 * Constructor is private so that an object of this class can't be created
 * Class is only being used for calculations
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
        //TODO sprawdzic czy zmienna temp jest w ogóle potrzebna
    	Duration temp = Duration.ZERO;
        String[] timeComponents = timeToAdd.split(":");
        temp = timeSum.plus(Duration.ofHours(Integer.parseInt(timeComponents[0])).plusMinutes(Integer.parseInt(timeComponents[1])));

        return temp;
    }
    
    /*
     * Method to compare duration with restriction
     * */
/*    public static boolean compareDuration(Duration duration, int restriction) {
        if (duration.toMinutes() >= restriction) {
            return true;
        } else {
            return false;
        }
    }*/
    
    /*
     * Method to compare duration with restriction (using Enums) updated
     * */
    public static boolean compareDuration(Duration duration, TimeRestrictions restriction) {
    	if (duration.toMinutes() >= restriction.getRestriction()) {
            return true;
        } else {
            return false;
        }
    }

}
