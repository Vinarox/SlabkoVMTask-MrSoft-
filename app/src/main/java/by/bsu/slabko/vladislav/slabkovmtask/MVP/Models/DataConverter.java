package by.bsu.slabko.vladislav.slabkovmtask.MVP.Models;

import java.util.ArrayList;
import java.util.List;

import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.DatabaseItem;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.cityInfoDB.CityInfoEntity;

public class DataConverter {

    public List<DatabaseItem> convertList(List<CityInfoEntity> entityList){
        ArrayList<DatabaseItem> items = new ArrayList<>();
        for (CityInfoEntity obj: entityList) {
            items.add(
                    new DatabaseItem(
                            obj.city_id,
                            obj.cityName,
                            obj.population,
                            obj.spokenLanguage,
                            obj.averageSalaryLevel,
                            obj.isCapital
                    )
            );

        }
        return items;
    }
}
