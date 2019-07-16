package by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.services;

import android.app.IntentService;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import by.bsu.slabko.vladislav.slabkovmtask.App;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.DatabaseContainer;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.DatabaseItem;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.cityInfoDB.CityInfoEntity;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.cityInfoDB.CityInfoProvider;

public class LiveSearchService extends IntentService {

    public static final String ACTION_MYINTENTSERVICE = "RESPONSE";
    public static final String EXTRA_KEY_OUT = "EXTRA_OUT";

    public LiveSearchService() {
        super("liveSearchService");
    }

    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String text = intent.getStringExtra("text");
        List<CityInfoEntity> entityItems;
        CityInfoProvider provider = CityInfoProvider.getInstance();
        entityItems = provider.getAllItemsByName(text);
        DatabaseContainer databaseContainer = App.getModelComponents().getDatabaseContainer();
        databaseContainer.setItems(
                (ArrayList<DatabaseItem>) App.getModelComponents().getDataConverter().convertList(entityItems)
        );

        String extraOut = "updateList";
        Intent responseIntent = new Intent();
        responseIntent.setAction(ACTION_MYINTENTSERVICE);
        responseIntent.addCategory(Intent.CATEGORY_DEFAULT);
        responseIntent.putExtra(EXTRA_KEY_OUT, extraOut);
        sendBroadcast(responseIntent);
    }
}