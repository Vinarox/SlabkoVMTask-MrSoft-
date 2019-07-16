package by.bsu.slabko.vladislav.slabkovmtask.rxJava2;

import android.support.v7.widget.SearchView;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class RxSearchView {
    public  Observable<String> fromSearchView(SearchView searchView) {
        final SearchView mSearchView = searchView;

        final Observable<String> subject = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(final ObservableEmitter<String> emitter) throws Exception {
                emitter.setCancellable(()-> mSearchView.setOnQueryTextListener(null));
                mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String s) {
                        emitter.onNext(s.trim());
                        return true;
                    }

                    @Override
                    public boolean onQueryTextChange(String text) {
                        emitter.onNext(text.trim());
                        return true;
                    }
                });
            }
        });
        return subject;
    }
}
