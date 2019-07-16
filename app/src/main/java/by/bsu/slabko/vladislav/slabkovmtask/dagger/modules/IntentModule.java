package by.bsu.slabko.vladislav.slabkovmtask.dagger.modules;

import android.content.Context;
import android.content.Intent;

import javax.inject.Named;

import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.services.LiveSearchService;
import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class IntentModule {
    @Provides
    Intent provideIntent(@Named("application_context")Context c) {
        return new Intent(c, LiveSearchService.class);
    }
}
