package Data;

import Data.Model.*;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*Class validating drivers working time*/
public class Inspector {

    private static final String TIME_FORMATTER = "H:m";
    private static final int TWO_WEEKS = 14;
    private static final int ONE_WEEK = 7;
    private final List<Data> dataInput;
    private List<Data> dataOutput;

    private List<WeekOfWork> weekOfWorkList;

    /*Constructor*/
    public Inspector() {
        DataResolver dataResolver = new DataResolver();
        dataResolver.downloadDataFromFile("C:\\Users\\Bartek\\Documents\\Dokumenty\\PKK_cze_2017.csv");
        dataInput = Collections.unmodifiableList(dataResolver.getData());
        dataOutput = new ArrayList<Data>();
/*        for (Data temp : dataInput) {
            dataOutput.add(temp);
        }*/
        weekOfWorkList = new ArrayList<WeekOfWork>();
    }

    /*Dividing data into separate weeks of work*/
    public void sortWeeks() {
        Duration breakDuration = Duration.ZERO;             //Duration of weekly break time
        WeekOfWork tempWeekOfWork;       //Temp WeekOfWork to be added into weekOfWorkList
        List<Data> tempData = new ArrayList<>();            //Temp data list to work with input data

        for (Data temp : dataInput) {
            tempData.add(temp);
        }

        int k = 1;
        for (int i = 0; !tempData.isEmpty(); i++) {
//            System.out.println(tempData.size());


            tempWeekOfWork = new WeekOfWork();
            dataOutput = new ArrayList<>();                 //Data output to be added to tempWeekOfWork

            for (int j = 0; j < tempData.size(); j++) {
                dataOutput.add(tempData.get(0));
                breakDuration = Duration.ZERO;

                if (tempData.get(0).getActivity().equals(Actions.BREAK)) {
                    breakDuration = Adder.addTime(breakDuration, tempData.get(0).getTimeSpent());
//                    System.out.println(breakDuration.toMinutes());

                    if (tempData.size() >= 2 && tempData.get(1).getActivity().equals(Actions.BREAK)) {
                        breakDuration = Adder.addTime(breakDuration, tempData.get(1).getTimeSpent());
//                        dataOutput.add(tempData.get(1));

                        if (tempData.size() >= 3 && tempData.get(2).getActivity().equals(Actions.BREAK)) {
                            breakDuration = Adder.addTime(breakDuration, tempData.get(2).getTimeSpent());
//                            dataOutput.add(tempData.get(2));
//                            tempData.remove(2);
//                            tempData.remove(1);
                        }
                    }
                }
                System.out.println(k++ + " " + breakDuration.toMinutes());
//                System.out.println(k++);

                tempData.remove(0);

                if (Adder.compareDuration(breakDuration, Restrictions.WEEKLY_BREAK)) {
                    tempWeekOfWork.setDataList(dataOutput);
//                    tempWeekOfWork.setExceededWeeklyInsufficientBreakTimes(tempWeekOfWork.getExceededWeeklyInsufficientBreakTimes() + 1);
/*                    if (Adder.compareDuration(breakDuration, Restrictions.WEEKLY_BREAK)) {
                        tempWeekOfWork.setExceededWeeklyInsufficientBreakTimes(tempWeekOfWork.getExceededWeeklyInsufficientBreakTimes() - 1);
                    }*/

                    break;
                }
            }
            weekOfWorkList.add(tempWeekOfWork);

        }
    }
    public void displayAllData() {

    }

    public void displayWeeksOfWork() {
        int i = 1;
        int j = 1;
        System.out.println(weekOfWorkList.size());
        for (WeekOfWork temp : weekOfWorkList) {
            System.out.println(i++ + " tydzien pracy");
            for (Data tempData : temp.getDataList()) {
                System.out.println(j++ + " " + tempData.getTimeSpent());
            }
        }
    }

    public void checkData() {

/*        if (!dataInput.isEmpty()) {
            for (Data tempData : dataInput) {
                if (tempData.getActivity().equals(Actions.DRIVE_TIME)) {
                    checkOneTimeDrive(tempData.getTimeSpent());

                }
            }*/
   /*         for (int i=0; i<dataInput.size(); i++) {
                if (dataInput.get(i).getActivity().equals(Actions.DRIVE_TIME)) {
                    dataInput.get(i).getMisdemeanors().setExceededOneTimeDrive(checkOneTimeDrive(dataInput.get(i).getTimeSpent()));
                }
            }*/
/*        } else {
            System.out.println("Brak danych");
        }*/

    }

    private boolean checkOneTimeDrive(String timeSpent) {
        LocalTime time = LocalTime.parse(timeSpent, DateTimeFormatter.ofPattern(TIME_FORMATTER));
        LocalTime maxOneTimeDrive = LocalTime.parse(Restrictions.MAX_ONE_TIME_DRIVE, DateTimeFormatter.ofPattern(TIME_FORMATTER));

        if (time.isBefore(maxOneTimeDrive) || time.equals(maxOneTimeDrive)) {
//            System.out.println("Przepisowo, czas jazdy: " + time.toString());
            return false;
        } else {
//            System.out.println("Wykroczenie");
            return true;
        }
    }

    public void checkTwoNextWeeks() {
        List<Data> twoWeeksData = new ArrayList<Data>();
        Duration duration;

        for (Data temp : dataInput) {
            twoWeeksData.add(temp);
        }

        int j = 0;
        while (!twoWeeksData.isEmpty()) {
            duration = Duration.ZERO;
            List<Data> tempData = new ArrayList<Data>();
            for (Data temp : twoWeeksData) {
                if (temp.getLocalDate().isBefore(twoWeeksData.get(0).getLocalDate().plusDays(ONE_WEEK)) || temp.getLocalDate().equals(twoWeeksData.get(0).getLocalDate().plusDays(ONE_WEEK))) {
                    tempData.add(temp);
                }
            }

            for (int i = 0; i < tempData.size(); i++) {
                if (!twoWeeksData.isEmpty()) {
                    twoWeeksData.remove(0);
                } else {
                    break;
                }
            }

            for (Data temp : tempData) {
                if (temp.getActivity().equals(Actions.DRIVE_TIME) || temp.getActivity().equals(Actions.WORK)) {
                    //                timeSum = Adder.addTime(timeSum, temp.getTimeSpent());
                    duration = Adder.addTime(duration, temp.getTimeSpent());
                    //                System.out.println(timeSum.toString());
                    //                System.out.println(duration);
                }
            }
            System.out.println(duration);
            System.out.println(tempData.size());

 /*           if (Adder.compareDuration(duration, 2520)) {
                for (; j < dataOutput.size()-(dataOutput.size()-tempData.size()); j++) {
                    dataOutput.get(j).getMisdemeanors().setExceededMaxWeeklyDriveTimeTwoWeeks(true);
                }
            } else {
                for (; j < dataOutput.size(); j++) {
                    dataOutput.get(j).getMisdemeanors().setExceededMaxWeeklyDriveTimeTwoWeeks(false);
                }
            }*/
        }
    }

    public List<Data> getDataOutput() {
        return dataOutput;
    }
}
