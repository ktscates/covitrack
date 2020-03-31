package rw.awesomity.covi_tracker.Fragments;


import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rw.awesomity.covi_tracker.Api.Api;
import rw.awesomity.covi_tracker.Api.RetrofitClient;
import rw.awesomity.covi_tracker.Models.Country;
import rw.awesomity.covi_tracker.R;

public class HomeFragment extends Fragment {

    private Api api;
    ImageView flag_img;
    TextView country_name;
    TextView total_cases;
    TextView new_cases;
    TextView active;
    TextView recovered;
    TextView deaths;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        country_name = (TextView)view.findViewById(R.id.country);
        total_cases = (TextView)view.findViewById(R.id.total_cases);
        new_cases = (TextView)view.findViewById(R.id.new_cases);
        active = (TextView)view.findViewById(R.id.active);
        recovered = (TextView)view.findViewById(R.id.recovered);
        deaths = (TextView)view.findViewById(R.id.deaths);
        flag_img = (ImageView)view.findViewById(R.id.flag);

        String flag = "https://raw.githubusercontent.com/NovelCOVID/API/master/assets/flags/rw.png";
        Picasso.get().load(flag).fit().centerCrop().into(flag_img);

        api = RetrofitClient.getInstance().create(Api.class);

        Call<Country> call = api.getOneCountry();

        call.enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {

                Country country = response.body();

                    country_name.setText(country.getCountry());
                    total_cases.setText("Total cases: " + country.getCases());
                    new_cases.setText("New cases: " + country.getTodayCases());
                    active.setText("Active cases: " + country.getActive());
                    recovered.setText("Total recovered: " + country.getRecovered());
                    deaths.setText("Total deaths: " + country.getDeaths());

            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }
        });


        return view;
    }
}
