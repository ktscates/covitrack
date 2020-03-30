package rw.awesomity.covi_tracker.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("countryInfo")
    @Expose
    private CountryInfo countryInfo;
    @SerializedName("cases")
    @Expose
    private int cases;
    @SerializedName("todayCases")
    @Expose
    private int todayCases;
    @SerializedName("deaths")
    @Expose
    private int deaths;
//    @SerializedName("todayDeaths")
//    @Expose
//    private int todayDeaths;
    @SerializedName("recovered")
    @Expose
    private int recovered;
    @SerializedName("active")
    @Expose
    private int active;
//    @SerializedName("critical")
//    @Expose
//    private int critical;
//    @SerializedName("casesPerOneMillion")
//    @Expose
//    private int casesPerOneMillion;
//    @SerializedName("deathsPerOneMillion")
//    @Expose
//    private int deathsPerOneMillion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Country() {
    }



    /**
     * 
     * @param country
     * @param recovered
     * @param cases
//     * @param critical
//     * @param deathsPerOneMillion
     * @param active
//     * @param casesPerOneMillion
     * @param countryInfo
     * @param deaths
     * @param todayCases
//     * @param todayDeaths
     */

    public Country(String country, CountryInfo countryInfo, int cases, int todayCases, int deaths, int recovered, int active) {
        this.country = country;
        this.countryInfo = countryInfo;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.recovered = recovered;
        this.active = active;
    }


//    public Country(String country, int cases, int todayCases, int deaths, int todayDeaths, int recovered, int active, int critical, int casesPerOneMillion, int deathsPerOneMillion) {
//        super();
//        this.country = country;
////        this.countryInfo = countryInfo;
//        this.cases = cases;
//        this.todayCases = todayCases;
//        this.deaths = deaths;
//        this.todayDeaths = todayDeaths;
//        this.recovered = recovered;
//        this.active = active;
//        this.critical = critical;
//        this.casesPerOneMillion = casesPerOneMillion;
//        this.deathsPerOneMillion = deathsPerOneMillion;
//    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Country withCountry(String country) {
        this.country = country;
        return this;
    }

    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(CountryInfo countryInfo) {
        this.countryInfo = countryInfo;
    }

    public Country withCountryInfo(CountryInfo countryInfo) {
        this.countryInfo = countryInfo;
        return this;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public Country withCases(int cases) {
        this.cases = cases;
        return this;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public Country withTodayCases(int todayCases) {
        this.todayCases = todayCases;
        return this;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public Country withDeaths(int deaths) {
        this.deaths = deaths;
        return this;
    }
//
//    public int getTodayDeaths() {
//        return todayDeaths;
//    }
//
//    public void setTodayDeaths(int todayDeaths) {
//        this.todayDeaths = todayDeaths;
//    }
//
//    public Country withTodayDeaths(int todayDeaths) {
//        this.todayDeaths = todayDeaths;
//        return this;
//    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public Country withRecovered(int recovered) {
        this.recovered = recovered;
        return this;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Country withActive(int active) {
        this.active = active;
        return this;
    }

//    public int getCritical() {
//        return critical;
//    }
//
//    public void setCritical(int critical) {
//        this.critical = critical;
//    }
//
//    public Country withCritical(int critical) {
//        this.critical = critical;
//        return this;
//    }

//    public int getCasesPerOneMillion() {
//        return casesPerOneMillion;
//    }
//
//    public void setCasesPerOneMillion(int casesPerOneMillion) {
//        this.casesPerOneMillion = casesPerOneMillion;
//    }
//
//    public Country withCasesPerOneMillion(int casesPerOneMillion) {
//        this.casesPerOneMillion = casesPerOneMillion;
//        return this;
//    }
//
//    public int getDeathsPerOneMillion() {
//        return deathsPerOneMillion;
//    }
//
//    public void setDeathsPerOneMillion(int deathsPerOneMillion) {
//        this.deathsPerOneMillion = deathsPerOneMillion;
//    }
//
//    public Country withDeathsPerOneMillion(int deathsPerOneMillion) {
//        this.deathsPerOneMillion = deathsPerOneMillion;
//        return this;
//    }

}
