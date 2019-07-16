package by.bsu.slabko.vladislav.slabkovmtask.dagger.modules;

import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.AsyncTasks.AsyncGetAllFromDB;
import dagger.Module;
import dagger.Provides;

@Module
public class AsyncGetAllFromDBModule {
    @Provides
    AsyncGetAllFromDB provideAsyncGetAllFromDB(){
        return new AsyncGetAllFromDB();
    }
}
