package by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.cityInfoDB;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class CityInfoEntity {
    @PrimaryKey
    public long city_id;

    @ColumnInfo(name = "cityName")
    public String cityName;

    @ColumnInfo(name = "population")
    public int population;

    @ColumnInfo(name = "spokenLanguage")
    public String spokenLanguage;

    @ColumnInfo(name = "averageSalaryLevel")
    public float averageSalaryLevel;

    @ColumnInfo(name = "isCapital")
    public boolean isCapital;
}
