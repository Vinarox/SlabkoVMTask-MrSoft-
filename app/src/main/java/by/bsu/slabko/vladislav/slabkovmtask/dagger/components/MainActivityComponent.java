package by.bsu.slabko.vladislav.slabkovmtask.dagger.components;

import by.bsu.slabko.vladislav.slabkovmtask.MVP.Presenters.DataPresenter;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Views.MainActivity;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Views.fragments.StartFragment;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.modules.DataPresenterModule;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.modules.IntentModule;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.modules.StartFragmentModule;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.scope.SingletonApplicationScope;
import dagger.Component;

@Component(modules = {StartFragmentModule.class, DataPresenterModule.class, IntentModule.class})
public interface MainActivityComponent {
    void injectsMainActivity(MainActivity mainActivity);
    StartFragment getStartFragment();
    DataPresenter getDataPresenter();
}
