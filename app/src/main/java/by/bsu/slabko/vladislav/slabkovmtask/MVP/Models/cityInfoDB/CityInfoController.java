package by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.cityInfoDB;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {CityInfoEntity.class}, version = 2, exportSchema = false)
public abstract class CityInfoController extends RoomDatabase {
    private static CityInfoController db;

    public abstract CityInfoDao LocalMedicineNamesDao();
}

