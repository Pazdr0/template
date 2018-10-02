package Data.Model;

/*
 * Converts 3 first letters of month
 * in polish to a int variable
 * */
public class MonthConverter {
    private static final String JANUARY = "sty";
    private static final String FEBRUARY = "lut";
    private static final String MARCH = "mar";
    private static final String APRIL = "kwi";
    private static final String MAY = "maj";
    private static final String JUNE = "cze";
    private static final String JULY = "lip";
    private static final String AUGUST = "sie";
    private static final String SEPTEMBER = "wrz";
    private static final String OCTOBER = "paz";
    private static final String NOVEMBER = "lis";
    private static final String DECEMBER= "gru";

    public static int convert(String month) {
        int monthNumber = 0;

        if (month.equals(JANUARY)) {
            monthNumber = 1;
        } else if (month.equals(FEBRUARY)) {
            monthNumber = 2;
        } else if (month.equals(MARCH)) {
            monthNumber = 3;
        } else if (month.equals(APRIL)) {
            monthNumber = 4;
        } else if (month.equals(MAY)) {
            monthNumber = 5;
        } else if (month.equals(JUNE)) {
            monthNumber = 6;
        } else if (month.equals(JULY)) {
            monthNumber = 7;
        } else if (month.equals(AUGUST)) {
            monthNumber = 8;
        } else if (month.equals(SEPTEMBER)) {
            monthNumber = 9;
        } else if (month.equals(OCTOBER)) {
            monthNumber = 10;
        } else if (month.equals(NOVEMBER)) {
            monthNumber = 11;
        } else if (month.equals(DECEMBER)) {
            monthNumber = 12;
        }

        return monthNumber;
    }
}
