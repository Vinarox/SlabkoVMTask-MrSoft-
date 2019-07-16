package by.bsu.slabko.vladislav.slabkovmtask.dagger.modules;

import android.app.Activity;
import android.content.Context;

import javax.inject.Named;

import by.bsu.slabko.vladislav.slabkovmtask.dagger.scope.SingletonApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private final Context context;

    ContextModule(Activity context){
        this.context = context;
    }

    @Named("activity_context")
    @SingletonApplicationScope
    @Provides
    public Context context(){ return context; }
}
