package Data;

import Data.Model.Data;
import Data.Model.MonthConverter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/*Klasa pobierajaca dane z bazy lub pliku*/
public class DataResolver {

    //TODO dodac zapisywanie danych do bazy w metodzie downloadDataFromFile
    private ArrayList<Data> data;

    public DataResolver() {
        data = new ArrayList<Data>();
    }

    public ArrayList<Data> getData() {
        return data;
    }

    /*Method downloads String from file and reorders it to Data class*/
    private void downloadFromFile(String pattern) {
        String splitter = ";";
        String newLine = "";
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(pattern));

            while((newLine = bufferedReader.readLine()) != null) {
                Data tempData = new Data();
                String[] line = newLine.split(splitter);
                tempData.setDate(line[0]);
                tempData.setActivity(line[1]);
                tempData.setFrom(line[2]);
                tempData.setTo(line[3]);
                tempData.setTimeSpent(line[4]);
                data.add(tempData);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File not found exception: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Data error" + ex.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    System.err.println("Error closing reader: " + ex.getMessage());
                }
            }
        }
    }

    /*Uses data from downloadFromFile method and deletes unwanted characters*/
    protected void downloadDataFromFile(String pattern) {
//        pattern = "C:\\Users\\Bartek\\Documents\\Dokumenty\\PKK_cze_2017.csv";

        ArrayList<Data> newData = new ArrayList<Data>();
        downloadFromFile(pattern);

        for (Data temp : data) {
            if (!temp.getDate().equals("data")) {
                temp.setLocalDate(transformStringToLocalDate(temp.getDate()));
                newData.add(temp);
            }
        }
        data = null;
        data = newData;
    }

    /*Method to download data from database*/
    protected ArrayList<Data> downloadDataFromDb() {
        ArrayList<Data> newData = new ArrayList<Data>();

        //TODO Pobrac dane z bazy i przeformowac je do listy <Data>

        return newData;
    }

    private LocalDate transformStringToLocalDate(String date) {
/*        Calendar calendar = GregorianCalendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy", Locale.GERMANY);
*/
        String splitter = " ";
        String newLine = "";
        String[] newDate = date.split(splitter);

//        calendar.setFirstDayOfWeek(Calendar.MONDAY);*/

        LocalDate localDate = LocalDate.of(Integer.parseInt(newDate[3]), MonthConverter.convert(newDate[1]), Integer.parseInt(newDate[2]));

/*        try {
            calendar.setTime(simpleDateFormat.parse(newDate[2] + " " + MonthConverter.convert(newDate[1]) + " " + newDate[3]));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }*/
//        calendar.set(Integer.parseInt(newDate[3]), MonthConverter.convert(newDate[1]), Integer.parseInt(newDate[2]));

        return localDate;
    }

    /*Metoda do usuniecia*/
    public void readData() {
        downloadDataFromFile("C:\\Users\\Bartek\\Documents\\Dokumenty\\PKK_cze_2017.csv");
/*        for (Data tempData : data) {
            System.out.println(tempData.getCalendarDate().get(Calendar.YEAR) + " " + (tempData.getCalendarDate().get(Calendar.MONTH) + 1) + " " +
                    tempData.getCalendarDate().get(Calendar.DAY_OF_MONTH) + ", Day of week: " + tempData.getCalendarDate().get(Calendar.DAY_OF_WEEK));
        }*/
        for (Data tempData : data) {
            System.out.println(tempData.getLocalDate().getYear() + " " + tempData.getLocalDate().getMonth() + " " +
                    tempData.getLocalDate().getDayOfMonth() + ", Day of week: " + tempData.getLocalDate().getDayOfWeek());
        }
    }
}