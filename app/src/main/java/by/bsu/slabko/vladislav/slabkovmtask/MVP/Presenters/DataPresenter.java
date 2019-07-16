package by.bsu.slabko.vladislav.slabkovmtask.MVP.Presenters;

import android.content.Intent;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;

import by.bsu.slabko.vladislav.slabkovmtask.App;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.MainContract;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.services.LiveSearchService;
import by.bsu.slabko.vladislav.slabkovmtask.R;
import by.bsu.slabko.vladislav.slabkovmtask.rxJava2.RxMenuItem;
import by.bsu.slabko.vladislav.slabkovmtask.rxJava2.RxSearchView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public class DataPresenter implements MainContract.Presenter {
    private boolean noSort;
    private SearchView searchView;
    private MenuItem salarySortItem;
    private MenuItem noSortItem;
    private RxSearchView rxSearchView;
    private RxMenuItem rxMenuItem;

    private CompositeDisposable disposables;

    MainContract.View mView;
    MainContract.Model mModel;

    public DataPresenter() {
        this.disposables = new CompositeDisposable();
        this.noSort = true;
        this.mModel = App.getPresenterComponent().getMainModel();
        this.rxMenuItem = App.getPresenterComponent().getRxMenuItem();
        this.rxSearchView = App.getPresenterComponent().getRxSearchView();
    }

    @Override
    public void onAttach(MainContract.View mView, SearchView searchView,
                         MenuItem salarySortItem, MenuItem noSortItem) {
        this.mView = mView;
        this.searchView = searchView;
        this.salarySortItem = salarySortItem;
        this.noSortItem = noSortItem;
        rxSearchViewListener();
        rxMenuItemListener();

    }

    private void rxMenuItemListener(){
        disposables.add( rxMenuItem.fromMenuItem(salarySortItem, noSortItem)
                .distinctUntilChanged()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<MenuItem>() {
                    @Override
                    public void onNext(MenuItem item) {
                        int id = item.getItemId();
                        item.setChecked(true);
                        switch (id){
                            case R.id.salarySort:
                                setNoSortState(false);
                                mView.saveNoSortStateToSharedPreferences(false);
                                needSalarySort();
                                break;
                            case R.id.noSort:
                                setNoSortState(true);
                                mView.saveNoSortStateToSharedPreferences(true);
                                needNoSort();
                                break;
                            default:
                                    break;
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {}
                }));
    }

    private void rxSearchViewListener() {
        disposables.add( rxSearchView.fromSearchView(searchView)
                .debounce(150, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<String>() {
                    @Override
                    public void onNext(String s) {
                        if(s.length() > 0){
                            mModel.setNeedAllElements(false);
                            mView.startService(s);
                        }
                        else{
                            mModel.getInfoFromDB();
                            mModel.setNeedAllElements(true);
                            if(mView.getSalarySortState().isChecked()) {
                                setNoSortState(false);
                                needSalarySort();
                            }
                            mView.updateScreenList("updateList");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {}
                }));
    }

    @Override
    public void onDetach() {
        this.mView = null;
        disposables.dispose();
    }

    @Override
    public void addTestData(boolean isDataAvailable) {
        if(!isDataAvailable){
            boolean isAdded = mModel.loadTestData();
            if(isAdded) {
                mView.renewSharedPreferences();
                mView.updateScreenList("updateList");
            }
        }
    }

    @Override
    public boolean getNoSortValue() {
        return noSort;
    }

    @Override
    public void needNoSort() {
        mModel.toNoSortState();
        mView.updateScreenList("updateList");
    }

    @Override
    public void needSalarySort() {
        mModel.toSalarySortState();
        mView.updateScreenList("updateList");
    }

    @Override
    public void processBroadcastEvent(Intent intent, MenuItem salarySort) {
        String result = intent.getStringExtra(LiveSearchService.EXTRA_KEY_OUT);
        if(result.equals("updateList")) {
            if(salarySort.isChecked()) {
                setNoSortState(false);
                needSalarySort();
            }
            mView.updateScreenList(result);
        }
    }

    @Override
    public void setNoSortState(boolean value) {
        noSort = value;
    }
}
