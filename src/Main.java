import Data.DataResolver;
import Data.Inspector;

public class Main {
	
    public static void main(String[] args) {
        DataResolver dataResolver = DataResolver.getInstance();
        dataResolver.downloadDataFromFile("C:\\Users\\bgolc\\Documents\\Docs\\PKK_cze_2017.csv");
//        Inspector inspector = new Inspector(dataResolver.getData());
        Inspector inspector = Inspector.getInstance();
        inspector.setData(dataResolver.getData());
        
        inspector.checkData();
        inspector.displayWeeksOfWork();
        
        //TODO w controlerze przekazac dane do Serwisu zapisującego danego na bazie lub zrobić to w klasie DataResolver, ale chyba bedzie to mniej czytelne
        
//        inspector.displayWeeksOfWork();
        
        
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


//        inspector.displayAllData();
    }
}
