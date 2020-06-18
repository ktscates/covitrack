package rw.awesomity.covi_tracker.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String API_URL = "https://corona.lmao.ninja/v2/";


    public static Retrofit getInstance(){
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}