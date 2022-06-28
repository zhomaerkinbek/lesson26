import java.util.Arrays;

public class Main {

    public static void main(String[] args)  {
        DataBase db = new DataBase();
        db.openConnection();
        if(db.isConnect()){
            Record[] records = db.getRecords();
            System.out.println("--------------------Records------------------");
            for (var e: records) {
                System.out.println(e);
            }
            System.out.println("----------------------------------------------");
            System.out.println("Get record by index 2: " + db.getRecord(2));
            System.out.println("Is have record by key - 'abc': " + db.isRecord("abc"));
            try {
                System.out.println("Get record by key - 'ABC': " + db.getRecord("ABC"));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Get array of record: start index = 1, finish index = 3");
            for(var e : db.getRecords(1, 3)){
                System.out.println(e);
            }
            System.out.printf("Count of records is - %d\n", db.getCountRecords());
            System.out.println("Added new record: key = 'new', value = '099'!");
            Record record = new Record("new", "099");
            db.setRecord(record);
            System.out.println("Update record by index = 0 to new: key='2', value='Two'");
            try {
                db.updateRecord(0, "2", "Two");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                System.out.println("Update value of record by key = 'over9000' to new: value='New value'");
                db.updateValue("over9000", "New value");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Record[] records1 = db.getRecords();
            System.out.println("--------------------Records------------------");
            for (var e: records1) {
                System.out.println(e);
            }
            System.out.println("----------------------------------------------");

        }

        db.closeConnection();
    }
}
