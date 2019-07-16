package by.bsu.slabko.vladislav.slabkovmtask.MVP.Models;

import by.bsu.slabko.vladislav.slabkovmtask.App;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.MainContract;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.DatabaseContainer;

public class MainModel implements MainContract.Model {
    DatabaseContainer databaseContainer = App.getModelComponents().getDatabaseContainer();
    public MainModel(){}

    @Override
    public boolean loadTestData(){
        boolean isAdded =  App.getModelComponents().getTestData().fillDB();
        getInfoFromDB();
        return isAdded;

    }

    @Override
    public void setNeedAllElements(boolean value) {
        databaseContainer.setNeedAllElements(value);
    }

    @Override
    public void getInfoFromDB() {
        databaseContainer.getAllDBInfo();
    }

    @Override
    public void toNoSortState() {
        databaseContainer.noSort();
    }

    @Override
    public void toSalarySortState() {
        databaseContainer.sortByAverageSalary();
    }

}
