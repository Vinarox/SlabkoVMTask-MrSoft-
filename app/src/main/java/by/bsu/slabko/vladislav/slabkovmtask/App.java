package by.bsu.slabko.vladislav.slabkovmtask;

import android.app.Application;
import android.content.Context;
import android.support.v7.preference.PreferenceManager;

import by.bsu.slabko.vladislav.slabkovmtask.dagger.components.DaggerMainActivityComponent;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.components.DaggerModelComponents;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.components.DaggerPresenterComponent;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.components.MainActivityComponent;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.components.ModelComponents;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.components.PresenterComponent;


public class App extends Application {
    private static MainActivityComponent mainActivityComponent;
    private static ModelComponents modelComponents;
    private static PresenterComponent presenterComponent;

    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        mainActivityComponent = DaggerMainActivityComponent.builder().build();
        modelComponents = DaggerModelComponents.builder().build();
        presenterComponent = DaggerPresenterComponent.builder().build();
        PreferenceManager.getDefaultSharedPreferences(this)
                .edit()
                .putBoolean("noSortState", true)
                .apply();
    }

    public static MainActivityComponent getMainActivityComponent() {
        return mainActivityComponent;
    }

    public static ModelComponents getModelComponents() {
        return modelComponents;
    }

    public static PresenterComponent getPresenterComponent() {
        return presenterComponent;
    }

    public static Context getAppContext() {
        return appContext;
    }
}
