package by.bsu.slabko.vladislav.slabkovmtask.dagger.components;

import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DataConverter;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.AsyncTasks.AsyncGetAllFromDB;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.AsyncTasks.AsyncLocalDB;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.DatabaseContainer;
import by.bsu.slabko.vladislav.slabkovmtask.TestData;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.modules.AsyncGetAllFromDBModule;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.modules.AsyncLocalDBModule;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.modules.DataConverterModule;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.modules.DatabaseContainerModule;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.modules.TestDataModule;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.scope.SingletonApplicationScope;
import dagger.Component;

@SingletonApplicationScope
@Component(modules = {AsyncGetAllFromDBModule.class, AsyncLocalDBModule.class,
        DatabaseContainerModule.class, DataConverterModule.class, TestDataModule.class})
public interface ModelComponents {
    AsyncGetAllFromDB asyncGetAllFromDB();
    AsyncLocalDB getAsyncLocalDB();
    DatabaseContainer getDatabaseContainer();
    DataConverter getDataConverter();
    TestData getTestData();

}
