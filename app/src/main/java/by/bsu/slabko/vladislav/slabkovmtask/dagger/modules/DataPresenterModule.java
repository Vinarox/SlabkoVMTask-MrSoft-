package by.bsu.slabko.vladislav.slabkovmtask.dagger.modules;

import by.bsu.slabko.vladislav.slabkovmtask.MVP.Presenters.DataPresenter;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.scope.SingletonApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class DataPresenterModule {
    @Provides
    DataPresenter provideDataPresenter(){
        return new DataPresenter();
    }
}
