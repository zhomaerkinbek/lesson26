public interface Connection {
    void openConnection();
    void closeConnection();
    boolean isConnect();
    Record getRecord(int index);
    boolean isValue(String key);
    Record getRecord(String key);
    Record[] getRecords(int startIndex, int finishIndex);
    int getCountRecords();
    void setRecord(Record record);
    void updateRecord(Record record, int index);
    void updateValue(String key, String value);
}
