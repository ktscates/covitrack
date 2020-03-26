
package rw.awesomity.covi_tracker.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryInfo {

    @SerializedName("_id")
    @Expose
    private int _id;
    @SerializedName("lat")
    @Expose
    private int lat;
    @SerializedName("long")
    @Expose
    private int _long;
    @SerializedName("flag")
    @Expose
    private String flag;
    @SerializedName("iso3")
    @Expose
    private String iso3;
    @SerializedName("iso2")
    @Expose
    private String iso2;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CountryInfo() {
    }

    /**
     * 
     * @param flag
     * @param _long
     * @param _id
     * @param iso2
     * @param lat
     * @param iso3
     */
    public CountryInfo(int _id, int lat, int _long, String flag, String iso3, String iso2) {
        super();
        this._id = _id;
        this.lat = lat;
        this._long = _long;
        this.flag = flag;
        this.iso3 = iso3;
        this.iso2 = iso2;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public CountryInfo with_id(int _id) {
        this._id = _id;
        return this;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public CountryInfo withLat(int lat) {
        this.lat = lat;
        return this;
    }

    public int getLong() {
        return _long;
    }

    public void setLong(int _long) {
        this._long = _long;
    }

    public CountryInfo with_long(int _long) {
        this._long = _long;
        return this;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public CountryInfo withFlag(String flag) {
        this.flag = flag;
        return this;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public CountryInfo withIso3(String iso3) {
        this.iso3 = iso3;
        return this;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public CountryInfo withIso2(String iso2) {
        this.iso2 = iso2;
        return this;
    }

}
