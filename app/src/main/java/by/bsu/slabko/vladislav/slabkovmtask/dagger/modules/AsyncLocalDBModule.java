package by.bsu.slabko.vladislav.slabkovmtask.dagger.modules;

import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.AsyncTasks.AsyncLocalDB;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.scope.SingletonApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class AsyncLocalDBModule {
    @Provides
    AsyncLocalDB provideAsyncLocalDB() {
        return new AsyncLocalDB();
    }
}
