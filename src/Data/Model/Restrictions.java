package Data.Model;

/*
 * Restrictions for professional drivers 
 * in UE in minutes
 * */
public class Restrictions {

	public static final String  MAX_ONE_TIME_DRIVE = "4:30"; 				//4.5h
    public static final String MAX_DAILY_DRIVE_TIME = "9:00"; 				//9h
    public static final String EXTENDED_MAX_DAILY_DRIVE_TIME = "10:00";		//10h
    public static final int MAX_EXTENDED_DRIVES_WEEKLY = 2; 				//2 x a week
    public static final int MAX_WEEKLY_DRIVE_TIME_ONE_WEEK = 3360; 			//56h
    public static final int MAX_WEEKLY_DRIVE_TIME_TWO_WEEKS = 5400; 		//90h
    public static final int SHORT_BREAK_15 = 15;
    public static final int SHORT_BREAK_30 = 30;
    public static final int SHORT_BREAK_45 = 45;
    public static final int DAILY_BREAK = 660; 								//11h
    public static final int DAILY_BREAK_DIVIDED_3 = 180; 					//3h
    public static final int DAILY_BREAK_DIVIDED_9 = 540; 					//9h
    public static final int MAX_DAILY_BREAK_SHORTENED = 3; 					//3 x in two weeks
    public static final int WEEKLY_BREAK = 2700;					 		//45h
    public static final int WEEKLY_BREAK_SHORTENED = 1440; 					//24h
}