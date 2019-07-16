package by.bsu.slabko.vladislav.slabkovmtask;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.AsyncTasks.AsyncLocalDB;
import by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo.DatabaseItem;

public class TestData {
    private ArrayList<DatabaseItem> items = new ArrayList<>();


    public boolean fillDB() {
        items.add(new DatabaseItem(0, "Минск", 1974000,
                "Русский",800f, true));
        items.add(new DatabaseItem(1, "Брест", 350000,
                "Русский",600f, false));
        items.add(new DatabaseItem(2, "Гомель", 536000,
                "Русский",700f, false));
        items.add(new DatabaseItem(3, "Витебск", 378000,
                "Русский",600f, false));
        items.add(new DatabaseItem(4, "Гродно", 373000,
                "Русский",600f, false));
        items.add(new DatabaseItem(5, "Могилев", 383000,
                "Русский",500f, false));
        items.add(new DatabaseItem(6, "Москва", 12615000,
                "Русский",1700f, true));
        items.add(new DatabaseItem(7, "Манчестер", 510000,
                "Английский",2400f, false));
        items.add(new DatabaseItem(8, "Лондон", 8787000,
                "Английский",3500f, true));
        items.add(new DatabaseItem(9, "Львов", 721000,
                "Украинский",800f, false));
        items.add(new DatabaseItem(10, "Прага", 1280000,
                "Чешский",1700f, true));
        items.add(new DatabaseItem(11, "Кёльн", 1075000,
                "Немецкий",1900f, false));
        items.add(new DatabaseItem(12, "Неаполь", 966000,
                "Итальянский",1700f, false));
        items.add(new DatabaseItem(13, "Лион", 513000,
                "Французский",1600f, false));
        items.add(new DatabaseItem(14, "Ганновер", 532000,
                "Немецкий", 2200f, false));
        items.add(new DatabaseItem(15, "Стокгольм", 939000,
                "Шведский",1900f, false));
        items.add(new DatabaseItem(16, "Марсель", 869000,
                "Французский", 1400f, false));
        items.add(new DatabaseItem(17, "Лидс", 784000,
                "Английский", 1800f, false));
        items.add(new DatabaseItem(18, "Осло", 673000,
                "Норвежский", 2600f, true));
        items.add(new DatabaseItem(19, "Роттердам", 641000,
                "Нидерландский",2200f, false));
        items.add(new DatabaseItem(20, "Брюссель", 1198000,
                "Французский",2500f, true));

        AsyncLocalDB asyncLocalDB = App.getModelComponents().getAsyncLocalDB();
        asyncLocalDB.execute(items);
        try {
            asyncLocalDB.get();
            return true;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
