package by.bsu.slabko.vladislav.slabkovmtask.rxJava2;

import android.view.MenuItem;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class RxMenuItem {
    public Observable<MenuItem> fromMenuItem(MenuItem... menuItem) {
        final MenuItem[] menuItems = menuItem;

        final Observable<MenuItem> subject = Observable.create(new ObservableOnSubscribe<MenuItem>() {
            @Override
            public void subscribe(final ObservableEmitter<MenuItem> emitter) throws Exception {
                for (MenuItem item: menuItems) {
                    item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            emitter.onNext(item);
                            return true;
                        }
                    });
                }
            }
        });


        return subject;
    }
}
