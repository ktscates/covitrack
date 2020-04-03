package rw.awesomity.covi_tracker.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

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
    ProgressBar progressBar;
    TextView errorText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        progressBar = (ProgressBar)view.findViewById(R.id.progress_bar);
        errorText = (TextView)view.findViewById(R.id.error);

        country_name = (TextView)view.findViewById(R.id.country);
        total_cases = (TextView)view.findViewById(R.id.total_cases);
        new_cases = (TextView)view.findViewById(R.id.new_cases);
        active = (TextView)view.findViewById(R.id.active);
        recovered = (TextView)view.findViewById(R.id.recovered);
        deaths = (TextView)view.findViewById(R.id.deaths);
        flag_img = (ImageView)view.findViewById(R.id.flag);

        api = RetrofitClient.getInstance().create(Api.class);

        Call<Country> call = api.getOneCountry();

        call.enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {

                Country country = response.body();

                DecimalFormat formatter = new DecimalFormat("#,###,###");
                country_name.setText(country.getCountry());
                total_cases.setText(getString(R.string.total_cases) + " " + formatter.format(Integer.parseInt(country.getCases())));
                new_cases.setText(getString(R.string.cases) + " " + formatter.format(country.getTodayCases()));
                active.setText(getString(R.string.active) + " " + formatter.format(Integer.parseInt(country.getActive())));
                recovered.setText(getString(R.string.recovered) + " " + formatter.format(Integer.parseInt(country.getRecovered())));
                deaths.setText(getString(R.string.deaths) + " " + formatter.format(Integer.parseInt(country.getDeaths())));

                String flag = country.getCountryInfo().getFlag();
                Picasso.get().load(flag).fit().centerInside().into(flag_img);
                progressBar.setVisibility(View.GONE);


            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
                showFailureMessage();
            }
        });

        return view;
    }

    private void showFailureMessage() {
        errorText.setText(getString(R.string.error));
        errorText.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }
}
