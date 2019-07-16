package by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.cityInfoDB;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface CityInfoDao {
    @Query("SELECT * FROM CityInfoEntity")
    List<CityInfoEntity> getAll();

    @Query("SELECT * FROM CityInfoEntity WHERE city_id = :id")
    List<CityInfoEntity> getByID(long id);

    @Query("SELECT * FROM CityInfoEntity WHERE cityName = :cityName ")
    CityInfoEntity getByName(String cityName);

    @Query("SELECT * FROM CityInfoEntity WHERE cityName LIKE '%' || :cityName || '%'")
    List<CityInfoEntity> getAllByName(String cityName);

    @Insert
    void insert(CityInfoEntity info);

    @Update
    void update(CityInfoEntity info);

    @Delete
    void delete(CityInfoEntity info);
}
