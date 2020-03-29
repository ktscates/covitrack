package rw.awesomity.covi_tracker.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("cases")
    @Expose
    private String cases;
    @SerializedName("deaths")
    @Expose
    private String deaths;
    @SerializedName("recovered")
    @Expose
    private String recovered;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("active")
    @Expose
    private String active;

    /**
     * No args constructor for use in serialization
     *
     */
    public Stats() {
    }

    /**
     *
     * @param recovered
     * @param cases
     * @param active
     * @param updated
     * @param deaths
     */
    public Stats(String cases, String deaths, String recovered, String updated, String active) {
        super();
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
        this.updated = updated;
        this.active = active;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public Stats withCases(String cases) {
        this.cases = cases;
        return this;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public Stats withDeaths(String deaths) {
        this.deaths = deaths;
        return this;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public Stats withRecovered(String recovered) {
        this.recovered = recovered;
        return this;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Stats withUpdated(String updated) {
        this.updated = updated;
        return this;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Stats withActive(String active) {
        this.active = active;
        return this;
    }

}