package rw.awesomity.covi_tracker.Fragments;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rw.awesomity.covi_tracker.Api.Api;
import rw.awesomity.covi_tracker.Api.RetrofitClient;
import rw.awesomity.covi_tracker.Models.Stats;
import rw.awesomity.covi_tracker.R;

public class StatFragment extends Fragment {

    Api api;
    ImageView earth;
    TextView total_cases;
    TextView active;
    TextView recovered;
    TextView deaths;
    ProgressBar progressBar;
    TextView errorText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stat, container, false);

        progressBar = (ProgressBar) view.findViewById(R.id.progress);
        errorText = (TextView)view.findViewById(R.id.error);

        total_cases = (TextView)view.findViewById(R.id.total_cases);
        active = (TextView)view.findViewById(R.id.active);
        recovered = (TextView)view.findViewById(R.id.recovered);
        deaths = (TextView)view.findViewById(R.id.deaths);
        earth = (ImageView)view.findViewById(R.id.flag);

        api = RetrofitClient.getInstance().create(Api.class);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadCountryData();
    }

    private void loadCountryData() {
        Log.e("TAG","helli");
        Call<Stats> call = api.getAll();

        call.enqueue(new Callback<Stats>() {


            @Override
            public void onResponse(Call<Stats> call, Response<Stats> response) {
                Stats stats = response.body();

                DecimalFormat formatter = new DecimalFormat("#,###,###");
                total_cases.setText(getString(R.string.total_world_cases) + " " + formatter.format(Integer.parseInt(stats.getCases())));
                deaths.setText(getString(R.string.total_world_deaths) + " " + formatter.format(Integer.parseInt(stats.getDeaths())));
                recovered.setText(getString(R.string.total_world_recovered) + " " + formatter.format(Integer.parseInt(stats.getRecovered())));
                active.setText(getString(R.string.total_world_active) + " " + formatter.format(Integer.parseInt(stats.getActive())));
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<Stats> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
                showFailureMessage();
            }
        });
    }

    private void showFailureMessage() {
        errorText.setText(getString(R.string.error));
        errorText.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

}
