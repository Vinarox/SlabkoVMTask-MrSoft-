package by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.cityInfoDB;


import android.arch.persistence.room.Room;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.DatabaseItem;

public class CityInfoProvider extends ContentProvider {
    private static CityInfoProvider instance;
    private CityInfoController db;
    private CityInfoDao infoDao;

    public static CityInfoProvider getInstance() {
        return instance;
    }

    @Override
    public boolean onCreate() {
        instance = this;
        db = Room.databaseBuilder(getContext(), CityInfoController.class,
                "cityInfoTable")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        infoDao = db.LocalMedicineNamesDao();
        return false;
    }



    public CityInfoController getDatabase() {
        return db;
    }


    public List<CityInfoEntity> getAll(){
        return infoDao.getAll();
    }

    public CityInfoEntity getItemByName(String name){
        return infoDao.getByName(name);
    }

    public List<CityInfoEntity> getAllItemsByName(String name){
        return infoDao.getAllByName(name);
    }
    
    public void insertListOfData(ArrayList<DatabaseItem> list){
        for (DatabaseItem obj: list) {
            CityInfoEntity entity = new CityInfoEntity();
            entity.city_id = obj.getId();
            entity.cityName = obj.getCityName();
            entity.population = obj.getPopulation();
            entity.spokenLanguage = obj.getSpokenLanguage();
            entity.averageSalaryLevel = obj.getAverageSalaryLevel();
            entity.isCapital = obj.isCapital();
            infoDao.insert(entity);
        }
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}

