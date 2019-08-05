package by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

import by.bsu.slabko.vladislav.slabkovmtask.App;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.AsyncTasks.AsyncGetAllFromDB;

public class DatabaseContainer{
    private ArrayList<DatabaseItem> items;
    private boolean isNeedAllElements;
    private boolean isSorted;


    public DatabaseContainer(){
        items = new ArrayList<>();
        isSorted = false;
        isNeedAllElements = true;
        getAllDBInfo();
    }

    public boolean isSorted() {
        return isSorted;
    }

    public void setNeedAllElements(boolean needAllElements) {
        isNeedAllElements = needAllElements;
    }

    public ArrayList<DatabaseItem> getAllDBInfo() {
        items.clear();
        isSorted = false;
        isNeedAllElements = true;
        AsyncGetAllFromDB asyncGetAllFromDB = App.getModelComponents().asyncGetAllFromDB();
        asyncGetAllFromDB.execute();
        try {
            items = (ArrayList<DatabaseItem>) asyncGetAllFromDB.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return items;
    }

    public ArrayList<DatabaseItem> getItems() {
        return items;
    }

    public void sortByAverageSalary(){
        if(!isSorted && items.size() > 0){
            Collections.sort(items);
            isSorted = true;
        }
    }

    public void noSort() {
        if(isSorted) {
            if(isNeedAllElements)
                getAllDBInfo();
            isSorted = false;
        }
    }

    public void setItems(ArrayList<DatabaseItem> items) {
        isSorted = false;
        isNeedAllElements = false;
        this.items = items;
    }

    public void deleteItem(int pos){
        items.remove(pos);
    }
}
