package Data.Model.Misdemeanors;

/*
 * Broken weekly restrictions
 * */
public class MisdemeanorsWeekly {

    private boolean exceededMaxWeeklyDriveTime;
    private boolean exceededMaxWeeklyDriveTimeTwoWeeks;
    private boolean exceededWeeklyExtendedDriveTimes;
    private boolean insufficientWeaklyBreak;
    private boolean exceededWeeklyInsufficientBreakTimes;

    public boolean isExceededMaxWeeklyDriveTime() {
        return exceededMaxWeeklyDriveTime;
    }

    public void setExceededMaxWeeklyDriveTime(boolean exceededMaxWeeklyDriveTime) {
        this.exceededMaxWeeklyDriveTime = exceededMaxWeeklyDriveTime;
    }

    public boolean isExceededMaxWeeklyDriveTimeTwoWeeks() {
        return exceededMaxWeeklyDriveTimeTwoWeeks;
    }

    public void setExceededMaxWeeklyDriveTimeTwoWeeks(boolean exceededMaxWeeklyDriveTimeTwoWeeks) {
        this.exceededMaxWeeklyDriveTimeTwoWeeks = exceededMaxWeeklyDriveTimeTwoWeeks;
    }

    public boolean isExceededWeeklyExtendedDriveTimes() {
        return exceededWeeklyExtendedDriveTimes;
    }

    public void setExceededWeeklyExtendedDriveTimes(boolean exceededWeeklyExtendedDriveTimes) {
        this.exceededWeeklyExtendedDriveTimes = exceededWeeklyExtendedDriveTimes;
    }

    public boolean isInsufficientWeaklyBreak() {
        return insufficientWeaklyBreak;
    }

    public void setInsufficientWeaklyBreak(boolean insufficientWeaklyBreak) {
        this.insufficientWeaklyBreak = insufficientWeaklyBreak;
    }

    public boolean isExceededWeeklyInsufficientBreakTimes() {
        return exceededWeeklyInsufficientBreakTimes;
    }

    public void setExceededWeeklyInsufficientBreakTimes(boolean exceededWeeklyInsufficientBreakTimes) {
        this.exceededWeeklyInsufficientBreakTimes = exceededWeeklyInsufficientBreakTimes;
    }



}
