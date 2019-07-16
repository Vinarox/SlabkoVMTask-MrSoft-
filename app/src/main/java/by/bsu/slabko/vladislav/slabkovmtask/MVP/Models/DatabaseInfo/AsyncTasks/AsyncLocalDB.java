package by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.AsyncTasks;


import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import by.bsu.slabko.vladislav.slabkovmtask.App;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.DatabaseItem;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.cityInfoDB.CityInfoProvider;

public class AsyncLocalDB extends AsyncTask<List<DatabaseItem>, Void, Void> {

    @Override
    protected Void doInBackground(List<DatabaseItem>... lists) {
        ArrayList<DatabaseItem> items = (ArrayList<DatabaseItem>) lists[0];
        CityInfoProvider provider = CityInfoProvider.getInstance();
        provider.insertListOfData(items);
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }


}
