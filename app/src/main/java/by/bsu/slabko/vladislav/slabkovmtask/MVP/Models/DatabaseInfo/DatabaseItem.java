package by.bsu.slabko.vladislav.slabkovmtask.MVP.Models.DatabaseInfo;

public class DatabaseItem implements Comparable {
    private long id;
    private String cityName;
    private int population;
    private String spokenLanguage;
    private float averageSalaryLevel;
    private boolean isCapital;

    public DatabaseItem(long id, String cityName, int population, String spokenLanguage, float averageSalaryLevel, boolean isCapital) {
        this.id = id;
        this.cityName = cityName;
        this.population = population;
        this.spokenLanguage = spokenLanguage;
        this.averageSalaryLevel = averageSalaryLevel;
        this.isCapital = isCapital;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getSpokenLanguage() {
        return spokenLanguage;
    }

    public void setSpokenLanguage(String spokenLanguage) {
        this.spokenLanguage = spokenLanguage;
    }

    public float getAverageSalaryLevel() {
        return averageSalaryLevel;
    }

    public void setAverageSalaryLevel(float averageSalaryLevel) {
        this.averageSalaryLevel = averageSalaryLevel;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    @Override
    public int compareTo(Object o) {
        DatabaseItem obj = (DatabaseItem) o;
       if(this.averageSalaryLevel > obj.averageSalaryLevel)
           return 1;
       else
           return -1;
    }
}
