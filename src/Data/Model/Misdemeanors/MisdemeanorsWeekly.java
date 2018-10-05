package data.model.misdemeanors;

/*
 * Broken weekly restrictions
 * */
public class MisdemeanorsWeekly {

    private boolean exceededMaxWeeklyDriveTime;                 //checked
    private boolean exceededMaxWeeklyDriveTimeTwoWeeks;         //condition to be implemented in future
    private boolean exceededWeeklyExtendedDriveTimes;           //
    private boolean insufficientWeaklyBreak;                    //is not needed, because new week wont start if weekly break is insufficient
    private boolean exceededWeeklyInsufficientBreakTimes;       //checked

    /*
    * Checkers
    * */
    public boolean isExceededMaxWeeklyDriveTime() {
        return exceededMaxWeeklyDriveTime;
    }

    public boolean isExceededMaxWeeklyDriveTimeTwoWeeks() {
        return exceededMaxWeeklyDriveTimeTwoWeeks;
    }

    public boolean isExceededWeeklyExtendedDriveTimes() {
        return exceededWeeklyExtendedDriveTimes;
    }

    public boolean isInsufficientWeaklyBreak() {
        return insufficientWeaklyBreak;
    }

    public boolean isExceededWeeklyInsufficientBreakTimes() {
        return exceededWeeklyInsufficientBreakTimes;
    }

    /*
    * Setters
    * */
    public void setExceededMaxWeeklyDriveTime(boolean exceededMaxWeeklyDriveTime) {
        this.exceededMaxWeeklyDriveTime = exceededMaxWeeklyDriveTime;
    }

    public void setExceededMaxWeeklyDriveTimeTwoWeeks(boolean exceededMaxWeeklyDriveTimeTwoWeeks) {
        this.exceededMaxWeeklyDriveTimeTwoWeeks = exceededMaxWeeklyDriveTimeTwoWeeks;
    }

    public void setExceededWeeklyExtendedDriveTimes(boolean exceededWeeklyExtendedDriveTimes) {
        this.exceededWeeklyExtendedDriveTimes = exceededWeeklyExtendedDriveTimes;
    }

    public void setInsufficientWeaklyBreak(boolean insufficientWeaklyBreak) {
        this.insufficientWeaklyBreak = insufficientWeaklyBreak;
    }

    public void setExceededWeeklyInsufficientBreakTimes(boolean exceededWeeklyInsufficientBreakTimes) {
        this.exceededWeeklyInsufficientBreakTimes = exceededWeeklyInsufficientBreakTimes;
    }
}
