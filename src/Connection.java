public interface Connection {
    void openConnection();
    void closeConnection();
    boolean isConnect();
    Record getRecord(int index);
    boolean isRecord(String key);
    Record getRecord(String key) throws Exception;
    Record[] getRecords(int startIndex, int finishIndex);
    int getCountRecords();
    void setRecord(Record record);
    void updateRecord(int index, String key, String value) throws Exception;
    void updateValue(String key, String value) throws Exception;
}

