package by.bsu.slabko.vladislav.slabkovmtask.MVP;

import android.content.Intent;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import io.reactivex.Completable;
import io.reactivex.ObservableSource;

public interface MainContract {
    interface View {
        void renewSharedPreferences();
        ObservableSource<Completable> startService(String newText);
        void updateScreenList(String command);
        MenuItem getSalarySortState();
        void saveNoSortStateToSharedPreferences(boolean value);
    }

    interface Presenter {
        void onAttach(MainContract.View mView, SearchView searchView,
                      MenuItem salarySortItem, MenuItem noSortItem);
        void onDetach();
        void addTestData(boolean isDataAvailable);
        void setNoSortState(boolean value);
        boolean getNoSortValue();
        void needNoSort();
        void needSalarySort();
        void processBroadcastEvent(Intent intent, MenuItem salarySort);
    }

    interface Model {
        boolean loadTestData();
        void setNeedAllElements(boolean value);
        void getInfoFromDB();
        void toNoSortState();
        void toSalarySortState();
    }
}
