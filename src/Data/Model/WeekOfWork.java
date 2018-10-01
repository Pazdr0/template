package Data.Model;


import Data.Model.Misdemeanors.MisdemeanorsWeekly;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WeekOfWork {

    private List<Data> dataList;
    private LocalDate weekStart;
    private LocalDate weekEnd;
    private MisdemeanorsWeekly misdemeanorsWeekly;
    private int exceededWeeklyInsufficientBreakTimes;
    private int exceededWeeklyExtendedDriveTimes;

    public WeekOfWork() {
        dataList = new ArrayList<Data>();
        misdemeanorsWeekly = new MisdemeanorsWeekly();
    }

    public MisdemeanorsWeekly getMisdemeanorsWeekly() {
        return misdemeanorsWeekly;
    }

    public void setMisdemeanorsWeekly(MisdemeanorsWeekly misdemeanorsWeekly) {
        this.misdemeanorsWeekly = misdemeanorsWeekly;
    }

    public int getExceededWeeklyInsufficientBreakTimes() {
        return exceededWeeklyInsufficientBreakTimes;
    }

    public void setExceededWeeklyInsufficientBreakTimes(int exceededWeeklyInsufficientBreakTimes) {
        this.exceededWeeklyInsufficientBreakTimes = exceededWeeklyInsufficientBreakTimes;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    public LocalDate getWeekStart() {
        return weekStart;
    }

    public void setWeekStart(LocalDate start) {
        this.weekStart = start;
    }

    public LocalDate getWeekEnd() {
        return weekEnd;
    }

    public void setWeekEnd(LocalDate end) {
        this.weekEnd = end;
    }
}
