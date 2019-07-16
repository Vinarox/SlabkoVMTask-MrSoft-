package by.bsu.slabko.vladislav.slabkovmtask.dagger.modules;

import by.bsu.slabko.vladislav.slabkovmtask.dagger.scope.SingletonApplicationScope;
import by.bsu.slabko.vladislav.slabkovmtask.rxJava2.RxMenuItem;
import dagger.Module;
import dagger.Provides;

@Module
public class RxMenuItemModule {
    @SingletonApplicationScope
    @Provides
    RxMenuItem provideRxMenuItem() {
        return new RxMenuItem();
    }
}
