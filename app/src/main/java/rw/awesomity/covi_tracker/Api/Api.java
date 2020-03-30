package rw.awesomity.covi_tracker.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rw.awesomity.covi_tracker.Models.Country;
import rw.awesomity.covi_tracker.Models.CountryInfo;
import rw.awesomity.covi_tracker.Models.Stats;

public interface Api {

    @GET("countries")
    Call<List<Country>> getCountries();

    @GET("all")
    Call<Stats> getAll();

    @GET("countries")
    Call<Country> getOneCountry();

    @GET("countries")
    Call<List<CountryInfo>> getFlags();
}
