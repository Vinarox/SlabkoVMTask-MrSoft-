package by.bsu.slabko.vladislav.slabkovmtask.dagger.modules;

import by.bsu.slabko.vladislav.slabkovmtask.dagger.scope.SingletonApplicationScope;
import by.bsu.slabko.vladislav.slabkovmtask.rxJava2.RxSearchView;
import dagger.Module;
import dagger.Provides;

@Module
public class RxSearchViewModule {
    @SingletonApplicationScope
    @Provides
    RxSearchView provideRxSearchView() {
        return new RxSearchView();
    }
}
