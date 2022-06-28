import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class DataBase implements Connection{

    private Record[] records;
    private boolean connect = false;

    public Record[] getRecords() {
        return records;
    }

    public DataBase() {
        records = readRecords();
    }

    public static Record[] readRecords(){
        Gson gson = new Gson();
        String json = getJson("./file.json");
        return gson.fromJson(json, Record[].class);
    }

    static String getJson(String fileName){
        String json = "";
        Path path = Paths.get(fileName);
        try {
            json = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }


    @Override
    public void openConnection() {
        System.out.println("Connection is opened!");
        connect = true;
    }

    @Override
    public void closeConnection() {
        System.out.println("Connection is closed!");
        connect = false;
    }

    @Override
    public boolean isConnect() {
        System.out.printf("Connection is %b\n", connect);
        return connect;
    }

    @Override
    public Record getRecord(int index) {
        return records[index];
    }

    @Override
    public boolean isRecord(String key) {
        for(var e : records){
            if(e.getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Record getRecord(String key) throws Exception {
        for(var e : records){
            if(e.getKey().equals(key)){
                return e;
            }
        }
        throw new Exception("Такой записи нет!");
    }

    @Override
    public Record[] getRecords(int startIndex, int finishIndex) {
        return Arrays.copyOfRange(records,
                startIndex, finishIndex + 1);
    }

    @Override
    public int getCountRecords() {
        return records.length;
    }

    @Override
    public void setRecord(Record record) {
        records = Arrays.copyOf(records, records.length + 1);
        records[records.length - 1] = record;
    }

    @Override
    public void updateRecord(int index, String key, String value) throws Exception {
        if (index > 0 | index < records.length) {
            records[index].setKey(key);
            records[index].setValue(value);
        } else {
            throw new Exception("Такой записи нет!");
        }
    }

    @Override
    public void updateValue(String key, String value) throws Exception {
        if(isRecord(key)) {
            Record record = getRecord(key);
            record.setValue(value);
        }else {
            throw new Exception("Такой записи нет!");
        }
    }
}
