package by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.AsyncTasks;


import android.os.AsyncTask;

import java.util.List;

import by.bsu.slabko.vladislav.slabkovmtask.App;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DataConverter;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.DatabaseItem;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.cityInfoDB.CityInfoEntity;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.cityInfoDB.CityInfoProvider;

public class AsyncGetAllFromDB extends AsyncTask<Void, Void, List<DatabaseItem>> {

    @Override
    protected List<DatabaseItem> doInBackground(Void... voids) {
        List<DatabaseItem> items;
        List<CityInfoEntity> entityItems;
        CityInfoProvider provider = CityInfoProvider.getInstance();
        entityItems = provider.getAll();
        items = App.getModelComponents().getDataConverter().convertList(entityItems);
        return items;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(List<DatabaseItem> result) {
        super.onPostExecute(result);
    }


}
