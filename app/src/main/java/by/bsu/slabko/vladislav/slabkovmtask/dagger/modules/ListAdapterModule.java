package by.bsu.slabko.vladislav.slabkovmtask.dagger.modules;

import android.content.Context;
import android.view.LayoutInflater;

import javax.inject.Named;

import by.bsu.slabko.vladislav.slabkovmtask.MVP.Views.adapters.ListAdapter;
import dagger.Module;
import dagger.Provides;

//@Module(includes = ContextModule.class)
public class ListAdapterModule {
  //  @Provides
    ListAdapter provideListAdapter(/*@Named("application_context")*/Context c, LayoutInflater ltInflater) {
        return new ListAdapter(c, ltInflater);
    }
}
