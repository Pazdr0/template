package Data.Model;

import Data.Model.Misdemeanors.MisdemeanorsDaily;

import java.time.LocalDate;

/*Klasa reprezentująca dane z tachografu*/
public class Data {

    private String date;
    private LocalDate localDate;
    private String activity;
    private String from;
    private String to;
    private String timeSpent;

    private MisdemeanorsDaily misdemeanors;

    public Data() {
        misdemeanors = new MisdemeanorsDaily();
    }

    public Data(String date, String activity, String since, String to, String timeSpent) {
        this.date = date;
        this.activity = activity;
        this.from = since;
        this.to = to;
        this.timeSpent = timeSpent;
        misdemeanors = new MisdemeanorsDaily();
    }

    private LocalDate transformStringToLocalDate(String date) {
        String splitter = " ";
        String newLine = "";
        String[] newDate = date.split(splitter);
        localDate = LocalDate.of(Integer.parseInt(newDate[3]), MonthConverter.convert(newDate[1]), Integer.parseInt(newDate[2]));

        return localDate;
    }

    public MisdemeanorsDaily getMisdemeanors() {
        return misdemeanors;
    }

    public void setMisdemeanors(MisdemeanorsDaily misdemeanors) {
        this.misdemeanors = misdemeanors;
    }

    public LocalDate getLocalDate() {
        transformStringToLocalDate(date);
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }

}
