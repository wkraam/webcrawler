package org.example.database;

public interface DatabaseInterface {
    public void connectToDatabase(String url);
    public void addToDatabase();
    public <object> object getFromDatabase(int ID);
}
