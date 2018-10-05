package data;

import data.model.Data;

import java.util.List;

public interface DataResolver {

    public List<Data> getData();

    public void downloadDataFromFile(String pattern);

    public void downloadDataFromDb();
}
