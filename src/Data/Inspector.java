package Data;

import Data.Model.*;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Class validating drivers working time
 * */
public enum Inspector {

	INSTANCE;
	
    private static final String TIME_FORMATTER = "H:m";		//Time formatter for DateTimeFormatter
    private static final int TWO_WEEKS = 14;
    private static final int ONE_WEEK = 7;
    private List<Data> dataInput;						//Input data from constructor, set as unmodifiable and final so the data doesn't get mixed up
    private List<WorkWeek> workWeeksList;					//Input data sorted into weeks of work are saved here

    
    /*
     * private Constructor for singleton
     * */
    private Inspector() {
        workWeeksList = new ArrayList<WorkWeek>();
    }
    /*
     * Constructor
     * */
/*    private Inspector(List<Data> data) {
        this.dataInput = Collections.unmodifiableList(data);
        this.workWeeksList = new ArrayList<WorkWeek>();
    }*/
    
    /*
     * Method to get singleton
     * */
    public static Inspector getInstance() {
        return Inspector.INSTANCE;
    }
    
    public void setData(List<Data> data) {
    	this.dataInput = Collections.unmodifiableList(data);
    }
    
    /*
     * Main method (and only one public) for checking data
     * It calls other methods in right order
     * */
    public void checkData() {
    	sortWeeks();
    }


    private void checkWeek(WorkWeek workWeek) {

    }
    
    
    
    
    
    
    
    
    
    //TODO przemyśleć czy lepiej pracować na składowej workWeekList czy może zrobić metody niezależne
    /*
     * Dividing data into separate work weeks
     * */
    private void sortWeeks() {
        Duration breakDuration = Duration.ZERO;             //Duration of weekly break time
        WorkWeek tempWorkWeek;      						//Temp WeekOfWork to be added into weekOfWorkList
        List<Data> dataOutput;								//Data to be put in tempWeekOfWork
        List<Data> tempData = new ArrayList<Data>();        //Temp data list to work with input data

        for (Data temp : dataInput) {						//Filling tempData with inputData
            tempData.add(temp);
        }

        while (!tempData.isEmpty()){						//To sort data into weeks, until tempData isn's empty method removes elements from tempData and ads them to dataOutput
        	
            tempWorkWeek = new WorkWeek();
            dataOutput = new ArrayList<Data>();             
            int tempDataSize = tempData.size();
 
            for (int j=0; j<tempDataSize; j++) {
 
                breakDuration = Duration.ZERO;
            	dataOutput.add(tempData.get(0));
            	
            	/* First it check if a driver is having break in 3 following days (if he is, the duration is being added to breakDuration),
            	 * because it's the maximum number of days one weekly break can take.
            	 * If driver takes a 5 day brake it doesn't matter, because it's going to add those breaks to next week, which will contain only break (empty like)
            	 * If the condition returns false it begins to check if data from 2 following days is time of break
            	 * As follows it check check if activity is break and adds it's time to breakDuration
            	 * If the next days are also breaks duration is summed up and Objects are removed from list
            	 * */
                if (tempData.size() >= 3 && tempData.get(2).getActivity().equals(Activities.BREAK.getActivity()) && tempData.get(1).getActivity().equals(Activities.BREAK.getActivity())
                		&& tempData.get(0).getActivity().equals(Activities.BREAK.getActivity())) {
                    breakDuration = DurationManager.addTime(breakDuration, tempData.get(0).getTimeSpent());
                    breakDuration = DurationManager.addTime(breakDuration, tempData.get(1).getTimeSpent());
                    breakDuration = DurationManager.addTime(breakDuration, tempData.get(2).getTimeSpent());  
                    dataOutput.add(tempData.get(1));
                    dataOutput.add(tempData.get(2));
                    tempData.remove(2);
                    tempData.remove(1);
                } else if (tempData.size() >= 2 && tempData.get(1).getActivity().equals(Activities.BREAK.getActivity())
                		&& tempData.get(0).getActivity().equals(Activities.BREAK.getActivity())) {
                    breakDuration = DurationManager.addTime(breakDuration, tempData.get(0).getTimeSpent());
                    breakDuration = DurationManager.addTime(breakDuration, tempData.get(1).getTimeSpent());
                    dataOutput.add(tempData.get(1));
                    tempData.remove(1);
                } else if (tempData.get(0).getActivity().equals(Activities.BREAK.getActivity())) {
                    breakDuration = DurationManager.addTime(breakDuration, tempData.get(0).getTimeSpent());
                }

                tempData.remove(0);
                
                /* All restrictions are set in Restrictions class.
                 * Conditions are checked, if breakDuration is greater than restriction, 
                 * loop ends and tempWorkWeek is being added to main week list
                 * or if there is no more data about week is being added.
                 * */
                if (DurationManager.compareDuration(breakDuration, TimeRestrictions.WEEKLY_BREAK)) {
                    tempWorkWeek.setDataList(dataOutput);
                    tempWorkWeek.setWeekStart(tempWorkWeek.getDataList().get(0).getLocalDate());
                    tempWorkWeek.setWeekEnd(tempWorkWeek.getDataList().get(tempWorkWeek.getDataList().size() - 1).getLocalDate());
                    break;
                } else if(DurationManager.compareDuration(breakDuration, TimeRestrictions.WEEKLY_BREAK_SHORTENED)) {
                    tempWorkWeek.setDataList(dataOutput);
                	tempWorkWeek.setExceededWeeklyInsufficientBreakTimes(tempWorkWeek.getExceededWeeklyInsufficientBreakTimes() + 1);
                    tempWorkWeek.setWeekStart(tempWorkWeek.getDataList().get(0).getLocalDate());
                    tempWorkWeek.setWeekEnd(tempWorkWeek.getDataList().get(tempWorkWeek.getDataList().size() - 1).getLocalDate());
                	break;
                } else if (tempData.size() == 0) {
                	tempWorkWeek.setDataList(dataOutput);
                    tempWorkWeek.setWeekStart(tempWorkWeek.getDataList().get(0).getLocalDate());
                    tempWorkWeek.setWeekEnd(tempWorkWeek.getDataList().get(tempWorkWeek.getDataList().size() - 1).getLocalDate());
                	break;
                }

            }
            workWeeksList.add(tempWorkWeek);
        }
    }

    /* 
     * TODO delete when it'll become useless
     * */
    public void displayWeeksOfWork() {
//        int i = 1;
        int j = 1;
        /*for (WorkWeek temp : workWeeksList) {
            System.out.print(i++ + " tydzien pracy");
            for (Data tempData : temp.getDataList()) {
                System.out.println(j++ + " " + tempData.getTimeSpent());
            }
        }*/
        
        System.out.println(workWeeksList.size() + ", list 1 size: " + workWeeksList.get(0).getDataList().size() + ", list 2 size: " + workWeeksList.get(1).getDataList().size() 
        		+ ", list 3 size: " + workWeeksList.get(2).getDataList().size() + ", list 4 size: " + workWeeksList.get(3).getDataList().size());
    	for (j=0; j<workWeeksList.get(0).getDataList().size(); j++) {
    		System.out.print("\n" + (j + 1) + " \t");
    		if (workWeeksList.get(0).getDataList().size() > j) {
    			System.out.print(workWeeksList.get(0).getDataList().get(j).getTimeSpent());
    		}
    		System.out.print(" \t");
    		if (workWeeksList.get(1).getDataList().size() > j) {
    			System.out.print(workWeeksList.get(1).getDataList().get(j).getTimeSpent());
    		}
    		System.out.print(" \t");
    		if (workWeeksList.get(2).getDataList().size() > j) {
    			System.out.print(workWeeksList.get(2).getDataList().get(j).getTimeSpent()); 

    		}
    		System.out.print(" \t");
    		if (workWeeksList.get(3).getDataList().size() > j) {
    	 		System.out.print(workWeeksList.get(3).getDataList().get(j).getTimeSpent());
    		}
        }
    }
    

    /*
     * TODO to be rewritten
     * */
    private boolean checkOneTimeDrive(String timeSpent) {
        LocalTime time = LocalTime.parse(timeSpent, DateTimeFormatter.ofPattern(TIME_FORMATTER));
      /*  LocalTime maxOneTimeDrive = LocalTime.parse(Restrictions.MAX_ONE_TIME_DRIVE, DateTimeFormatter.ofPattern(TIME_FORMATTER));

        if (time.isBefore(maxOneTimeDrive) || time.equals(maxOneTimeDrive)) {
//            System.out.println("Przepisowo, czas jazdy: " + time.toString());
            return false;
        } else {
//            System.out.println("Wykroczenie");
*/            return true;
       
    }

    /*
     * TODO to be rewritten
     * */
    private void checkTwoNextWeeks() {
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
                if (temp.getActivity().equals(Activities.DRIVE_TIME) || temp.getActivity().equals(Activities.WORK)) {
                    //                timeSum = Adder.addTime(timeSum, temp.getTimeSpent());
                    duration = DurationManager.addTime(duration, temp.getTimeSpent());
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

}
