
package rw.awesomity.covi_tracker.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

public class Country {

    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("countryInfo")
    @Expose
    private CountryInfo countryInfo;
    @SerializedName("cases")
    @Expose
    private String cases;
    @SerializedName("todayCases")
    @Expose
    private int todayCases;
    @SerializedName("deaths")
    @Expose
    private String deaths;
    @SerializedName("todayDeaths")
    @Expose
    private String todayDeaths;
    @SerializedName("recovered")
    @Expose
    private String recovered;
    @SerializedName("todayRecovered")
    @Expose
    private String todayRecovered;
    @SerializedName("active")
    @Expose
    private String active;
    @SerializedName("critical")
    @Expose
    private String critical;
    @SerializedName("casesPerOneMillion")
    @Expose
    private String casesPerOneMillion;
    @SerializedName("deathsPerOneMillion")
    @Expose
    private String deathsPerOneMillion;
    @SerializedName("tests")
    @Expose
    private String tests;
    @SerializedName("testsPerOneMillion")
    @Expose
    private String testsPerOneMillion;
    @SerializedName("population")
    @Expose
    private String population;
    @SerializedName("continent")
    @Expose
    private String continent;
    @SerializedName("oneCasePerPeople")
    @Expose
    private String oneCasePerPeople;
    @SerializedName("oneDeathPerPeople")
    @Expose
    private String oneDeathPerPeople;
    @SerializedName("oneTestPerPeople")
    @Expose
    private String oneTestPerPeople;
    @SerializedName("activePerOneMillion")
    @Expose
    private String activePerOneMillion;
    @SerializedName("recoveredPerOneMillion")
    @Expose
    private String recoveredPerOneMillion;
    @SerializedName("criticalPerOneMillion")
    @Expose
    private String criticalPerOneMillion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Country() {
    }

    /**
     * 
     * @param continent
     * @param country
     * @param recoveredPerOneMillion
     * @param cases
     * @param critical
     * @param oneCasePerPeople
     * @param active
     * @param testsPerOneMillion
     * @param population
     * @param oneDeathPerPeople
     * @param recovered
     * @param oneTestPerPeople
     * @param tests
     * @param criticalPerOneMillion
     * @param deathsPerOneMillion
     * @param todayRecovered
     * @param casesPerOneMillion
     * @param countryInfo
     * @param updated
     * @param deaths
     * @param activePerOneMillion
     * @param todayCases
     * @param todayDeaths
     */
    public Country(String updated, String country, CountryInfo countryInfo, String cases, int todayCases, String deaths, String todayDeaths, String recovered, String todayRecovered, String active, String critical, String casesPerOneMillion, String deathsPerOneMillion, String tests, String testsPerOneMillion, String population, String continent, String oneCasePerPeople, String oneDeathPerPeople, String oneTestPerPeople, String activePerOneMillion, String recoveredPerOneMillion, String criticalPerOneMillion) {
        super();
        this.updated = updated;
        this.country = country;
        this.countryInfo = countryInfo;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
        this.active = active;
        this.critical = critical;
        this.casesPerOneMillion = casesPerOneMillion;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.tests = tests;
        this.testsPerOneMillion = testsPerOneMillion;
        this.population = population;
        this.continent = continent;
        this.oneCasePerPeople = oneCasePerPeople;
        this.oneDeathPerPeople = oneDeathPerPeople;
        this.oneTestPerPeople = oneTestPerPeople;
        this.activePerOneMillion = activePerOneMillion;
        this.recoveredPerOneMillion = recoveredPerOneMillion;
        this.criticalPerOneMillion = criticalPerOneMillion;
    }

    public static final Comparator<Country> BY_NAME_ALPHABETICAL = new Comparator<Country>() {
        @Override
        public int compare(Country o1, Country o2) {
            return o1.country.compareTo(o2.country);
        }
    };

    public static final Comparator<Country> BY_TODAY_CASES = new Comparator<Country>() {
        @Override
        public int compare(Country o1, Country o2) {
            return o2.todayCases - o1.todayCases;
        }
    };

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(CountryInfo countryInfo) {
        this.countryInfo = countryInfo;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(String todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public String getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(String casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public String getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(String deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public String getTests() {
        return tests;
    }

    public void setTests(String tests) {
        this.tests = tests;
    }

    public String getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(String testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getOneCasePerPeople() {
        return oneCasePerPeople;
    }

    public void setOneCasePerPeople(String oneCasePerPeople) {
        this.oneCasePerPeople = oneCasePerPeople;
    }

    public String getOneDeathPerPeople() {
        return oneDeathPerPeople;
    }

    public void setOneDeathPerPeople(String oneDeathPerPeople) {
        this.oneDeathPerPeople = oneDeathPerPeople;
    }

    public String getOneTestPerPeople() {
        return oneTestPerPeople;
    }

    public void setOneTestPerPeople(String oneTestPerPeople) {
        this.oneTestPerPeople = oneTestPerPeople;
    }

    public String getActivePerOneMillion() {
        return activePerOneMillion;
    }

    public void setActivePerOneMillion(String activePerOneMillion) {
        this.activePerOneMillion = activePerOneMillion;
    }

    public String getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    public void setRecoveredPerOneMillion(String recoveredPerOneMillion) {
        this.recoveredPerOneMillion = recoveredPerOneMillion;
    }

    public String getCriticalPerOneMillion() {
        return criticalPerOneMillion;
    }

    public void setCriticalPerOneMillion(String criticalPerOneMillion) {
        this.criticalPerOneMillion = criticalPerOneMillion;
    }

}
