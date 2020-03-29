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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rw.awesomity.covi_tracker.Api.Api;
import rw.awesomity.covi_tracker.Api.RetrofitClient;
import rw.awesomity.covi_tracker.Models.Country;
import rw.awesomity.covi_tracker.Models.Stats;
import rw.awesomity.covi_tracker.R;

public class StatFragment extends Fragment {

    Api api;
    ImageView earth;
    TextView total_cases;
    TextView updated;
    TextView active;
    TextView recovered;
    TextView deaths;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stat, container, false);

        total_cases = (TextView)view.findViewById(R.id.total_cases);
        updated = (TextView)view.findViewById(R.id.new_cases);
        active = (TextView)view.findViewById(R.id.active);
        recovered = (TextView)view.findViewById(R.id.recovered);
        deaths = (TextView)view.findViewById(R.id.deaths);
        earth = (ImageView)view.findViewById(R.id.flag);

        api = RetrofitClient.getInstance().create(Api.class);

        Call<Stats> call = api.getAll();

        call.enqueue(new Callback<Stats>() {
            @Override
            public void onResponse(Call<Stats> call, Response<Stats> response) {

                Stats stats = response.body();

                if (stats != null) {
                    total_cases.setText("Cases: " + stats.getCases());
                    deaths.setText("Deaths: " + stats.getDeaths());
                    recovered.setText("Recovered: " + stats.getRecovered());
                    updated.setText("Updated: " + stats.getUpdated());
                    active.setText("Active: " + stats.getActive());
                }


            }

            @Override
            public void onFailure(Call<Stats> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }
        });
        return view;
    }
}
