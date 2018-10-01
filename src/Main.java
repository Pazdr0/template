import Data.DataResolver;
import Data.Inspector;
import Data.Model.Data;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Inspector inspector = new Inspector();
        DataResolver dataResolver = new DataResolver();

//        dataResolver.readData();

/*        inspector.checkData();
        inspector.checkTwoNextWeeks();
        List<Data> data = inspector.getDataOutput();*/

//        int i = 0;
/*        for (Data temp : data) {
            if (temp.getMisdemeanors().isExceededMaxWeeklyDriveTimeTwoWeeks() == true) {
//                System.out.println("wykroczenie czasu jazdy na 2 tyg" + i++);
            } else {
//                System.out.println("brak wykroczenia" + i++);
            }
        }*/

        inspector.sortWeeks();
        inspector.displayWeeksOfWork();
//        inspector.displayAllData();
    }
}
