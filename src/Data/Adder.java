package Data;

import Data.Model.Data;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class Adder {

    private static final String TIME_FORMATTER = "H:m";

    private Adder() {}

 /*   public static LocalTime addTime(LocalTime timeSum, String timeToAdd) {
        LocalTime temp = LocalTime.parse(timeToAdd, DateTimeFormatter.ofPattern(TIME_FORMATTER));
        LocalTime temp2 = null;

        temp2 = temp.plusHours(timeSum.getHour()).plusMinutes(timeSum.getMinute());

        return temp2;
    }*/

    public static Duration addTime(Duration timeSum, String timeToAdd) {
        Duration temp = Duration.ZERO;
        String[] timeComponents = timeToAdd.split(":");
        temp = timeSum.plus(Duration.ofHours(Integer.parseInt(timeComponents[0])).plusMinutes(Integer.parseInt(timeComponents[1])));

        return temp;
    }

    public static boolean compareDuration(Duration duration, int restriction) {

        if (duration.toMinutes() >= restriction) {
//            System.out.println("jest winksze");
            return true;
        } else {
//            System.out.println("nie jest winksze");
            return false;
        }
    }

}
