package data.model;


import data.model.misdemeanors.MisdemeanorsWeekly;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WorkWeek {

    private List<Data> dataList;
    private List<Day> dayList;
    private LocalDate weekStart;
    private LocalDate weekEnd;
    private MisdemeanorsWeekly misdemeanorsWeekly;
    private int exceededWeeklyExtendedDriveTimes;
    private int exceededWeeklyInsufficientBreakTimes;

    /*
    * Constructor
    * */
	public WorkWeek() {
        dataList = new ArrayList<Data>();
        dayList = new ArrayList<Day>();
        misdemeanorsWeekly = new MisdemeanorsWeekly();
    }

    private void sortIntoDays() {
	    for
    }

    /*
    * Getters
    * */
    public List<Data> getDataList() {
        return dataList;
    }

    public LocalDate getWeekStart() {
        return weekStart;
    }

    public LocalDate getWeekEnd() {
        return weekEnd;
    }

    public MisdemeanorsWeekly getMisdemeanorsWeekly() {
        return misdemeanorsWeekly;
    }

    public int getExceededWeeklyExtendedDriveTimes() {
        return exceededWeeklyExtendedDriveTimes;
    }

    public int getExceededWeeklyInsufficientBreakTimes() {
        return exceededWeeklyInsufficientBreakTimes;
    }

    /*
    * Setters
    * */
    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    public void setWeekStart(LocalDate start) {
        this.weekStart = start;
    }

    public void setWeekEnd(LocalDate end) {
        this.weekEnd = end;
    }

    public void setMisdemeanorsWeekly(MisdemeanorsWeekly misdemeanorsWeekly) {
        this.misdemeanorsWeekly = misdemeanorsWeekly;
    }

	public void setExceededWeeklyExtendedDriveTimes(int exceededWeeklyExtendedDriveTimes) {
		this.exceededWeeklyExtendedDriveTimes = exceededWeeklyExtendedDriveTimes;
	}

	public void setExceededWeeklyInsufficientBreakTimes(int exceededWeeklyInsufficientBreakTimes) {
        this.exceededWeeklyInsufficientBreakTimes = exceededWeeklyInsufficientBreakTimes;
    }
}
