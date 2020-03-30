package rw.awesomity.covi_tracker.Fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import rw.awesomity.covi_tracker.R;

public class HomeFragment extends Fragment {

    private Api api;
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

        api = RetrofitClient.getInstance().create(Api.class);

        loadCountryData();
        return view;
    }

    private void loadCountryData() {
        Call<List<Country>> call = api.getCountries();

        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }
        });
    }
}
