package by.bsu.slabko.vladislav.slabkovmtask.dagger.modules;

import by.bsu.slabko.vladislav.slabkovmtask.MVP.Views.fragments.StartFragment;
import dagger.Module;
import dagger.Provides;

@Module
public class StartFragmentModule {
    @Provides
    StartFragment provideStartFragment(){
        return new StartFragment();
    }
}
