package by.bsu.slabko.vladislav.slabkovmtask.dagger.components;

import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.MainModel;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.modules.MainModelModule;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.modules.RxMenuItemModule;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.modules.RxSearchViewModule;
import by.bsu.slabko.vladislav.slabkovmtask.dagger.scope.SingletonApplicationScope;
import by.bsu.slabko.vladislav.slabkovmtask.rxJava2.RxMenuItem;
import by.bsu.slabko.vladislav.slabkovmtask.rxJava2.RxSearchView;
import dagger.Component;

@SingletonApplicationScope
@Component(modules = {MainModelModule.class, RxMenuItemModule.class, RxSearchViewModule.class})
public interface PresenterComponent {
    MainModel getMainModel();
    RxMenuItem getRxMenuItem();
    RxSearchView getRxSearchView();
}
