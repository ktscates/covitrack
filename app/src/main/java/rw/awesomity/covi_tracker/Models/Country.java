
package rw.awesomity.covi_tracker.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

public class Country {

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
    @SerializedName("updated")
    @Expose
    private String updated;

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
     * @param critical
     * @param deathsPerOneMillion
     * @param active
     * @param casesPerOneMillion
     * @param countryInfo
     * @param updated
     * @param deaths
     * @param todayCases
     * @param todayDeaths
     */
    public Country(String country, CountryInfo countryInfo, String cases, int todayCases, String deaths, String todayDeaths, String recovered, String active, String critical, String casesPerOneMillion, String deathsPerOneMillion, String updated) {
        super();
        this.country = country;
        this.countryInfo = countryInfo;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
        this.casesPerOneMillion = casesPerOneMillion;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.updated = updated;
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

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public Country withCases(String cases) {
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

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public Country withDeaths(String deaths) {
        this.deaths = deaths;
        return this;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public Country withTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
        return this;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public Country withRecovered(String recovered) {
        this.recovered = recovered;
        return this;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Country withActive(String active) {
        this.active = active;
        return this;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public Country withCritical(String critical) {
        this.critical = critical;
        return this;
    }

    public String getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(String casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public Country withCasesPerOneMillion(String casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
        return this;
    }

    public String getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(String deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public Country withDeathsPerOneMillion(String deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
        return this;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Country withUpdated(String updated) {
        this.updated = updated;
        return this;
    }

}
