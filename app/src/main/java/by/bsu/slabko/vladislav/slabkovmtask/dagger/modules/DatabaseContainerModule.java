package by.bsu.slabko.vladislav.slabkovmtask.dagger.modules;

import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.DatabaseContainer;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.scope.SingletonApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseContainerModule {
    @SingletonApplicationScope
    @Provides
    DatabaseContainer provideDatabaseContainer() {
        return new DatabaseContainer();
    }
}
