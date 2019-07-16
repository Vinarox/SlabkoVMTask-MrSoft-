package by.bsu.slabko.vladislav.slabkovmtask.dagger.modules;

import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DataConverter;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.scope.SingletonApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class DataConverterModule {
    @SingletonApplicationScope
    @Provides
    DataConverter provideDataConverter(){
        return new DataConverter();
    }
}
