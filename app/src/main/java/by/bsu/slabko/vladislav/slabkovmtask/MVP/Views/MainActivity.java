package by.bsu.slabko.vladislav.slabkovmtask.MVP.Views;


import android.animation.LayoutTransition;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import by.bsu.slabko.vladislav.slabkovmtask.App;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.MainContract;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Views.fragments.StartFragment;
import by.bsu.slabko.vladislav.slabkovmtask.R;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.services.LiveSearchService;
import io.reactivex.Completable;
import io.reactivex.ObservableSource;


public class MainActivity extends AppCompatActivity implements MainContract.View {
    //@Inject
    MainContract.Presenter mPresenter;

    //@Inject
    Fragment startFragment;
    private MainActivity context;

    private SearchView searchView;
    private MenuItem salarySort;
    private MenuItem noSort;
    private IntentFilter intentFilter;

    private OnActivityInteractionListener onActivityInteractionListener;
    private MyBroadcastReceiver mMyBroadcastReceiver;

    public interface OnActivityInteractionListener {
        void onStringSelected(String str);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //App.getMainActivityComponent().injectsMainActivity(this);
        startFragment = App.getMainActivityComponent().getStartFragment();
        mPresenter = App.getMainActivityComponent().getDataPresenter();



        context = this;

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        startFragment = StartFragment.newInstance();
        onActivityInteractionListener = (OnActivityInteractionListener)startFragment;

        FragmentManager transaction = getSupportFragmentManager();
        transaction.beginTransaction()
                .replace(R.id.fragment_cont, startFragment)
                .commit();

        mMyBroadcastReceiver = new MyBroadcastReceiver();

        intentFilter = new IntentFilter(
                LiveSearchService.ACTION_MYINTENTSERVICE);
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);

    }

    @Override
    public void onStart() {
        super.onStart();
        registerReceiver(mMyBroadcastReceiver, intentFilter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        salarySort = menu.findItem(R.id.salarySort);
        noSort = menu.findItem(R.id.noSort);

        if(loadSharedPreferences().getBoolean("noSortState", true))
            noSort.setChecked(true);
        else
            salarySort.setChecked(true);

        final MenuItem searchItem = menu.findItem(R.id.search_icon);
        searchView =
                (SearchView) searchItem.getActionView();

        LinearLayout searchBar = searchView.findViewById(R.id.search_bar);
        searchBar.setLayoutTransition(new LayoutTransition());

        mPresenter.onAttach(this, searchView, salarySort, noSort);

        boolean isDataAvailable = checkAvailabilityOfTestData();
        mPresenter.addTestData(isDataAvailable);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onDetach();
        unregisterReceiver(mMyBroadcastReceiver);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter = null;
        startFragment = null;
        onActivityInteractionListener = null;
        mMyBroadcastReceiver = null;
    }


    private SharedPreferences loadSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(App.getAppContext());
    }

    private boolean checkAvailabilityOfTestData() {
        SharedPreferences sharedPreferences = loadSharedPreferences();
        return sharedPreferences.getBoolean("isLocalDBExists", false);
    }

    @Override
    public void renewSharedPreferences() {
        SharedPreferences sharedPreferences = loadSharedPreferences();
        sharedPreferences
                .edit()
                .putBoolean("isLocalDBExists", true)
                .apply();
    }

    @Override
    public ObservableSource<Completable> startService(String newText) {
        Intent intentMyIntentService = new Intent(context, LiveSearchService.class);
        startService(intentMyIntentService.putExtra("text", newText));
        return null;
    }

    @Override
    public void updateScreenList(String command) {
        onActivityInteractionListener.onStringSelected(command);
    }

    @Override
    public MenuItem getSalarySortState() {
        return salarySort;
    }

    @Override
    public void saveNoSortStateToSharedPreferences(boolean value) {
        SharedPreferences sharedPreferences = loadSharedPreferences();
        sharedPreferences
                .edit()
                .putBoolean("noSortState", value)
                .apply();
    }

    public class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            mPresenter.processBroadcastEvent(intent, salarySort);
        }
    }
}
