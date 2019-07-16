package by.bsu.slabko.vladislav.slabkovmtask.dagger.modules;

import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.MainModel;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Presenters.DataPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class MainModelModule {
    @Provides
    MainModel provideMainModule(){
        return new MainModel();
    }
}
