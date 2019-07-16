package by.bsu.slabko.vladislav.slabkovmtask.dagger.modules;

import by.bsu.slabko.vladislav.slabkovmtask.TestData;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.scope.SingletonApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class TestDataModule {
    @SingletonApplicationScope
    @Provides
    TestData provideTestData() {
        return new TestData();
    }
}
