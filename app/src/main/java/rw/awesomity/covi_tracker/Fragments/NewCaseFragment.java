package rw.awesomity.covi_tracker.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rw.awesomity.covi_tracker.Adapters.NewCaseAdapter;
import rw.awesomity.covi_tracker.Api.Api;
import rw.awesomity.covi_tracker.Api.RetrofitClient;
import rw.awesomity.covi_tracker.Models.Country;
import rw.awesomity.covi_tracker.Models.CountryInfo;
import rw.awesomity.covi_tracker.R;

public class NewCaseFragment extends Fragment {

    private Api api;
    private RecyclerView recyclerView;
    private NewCaseAdapter newCaseAdapter;
    private List<Country> countryList;
    private List<CountryInfo> countryFlag;
    private Country country;
    private ShimmerFrameLayout shimmerFrameLayout;
    private EditText filterText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_cases, container, false);

        shimmerFrameLayout = (ShimmerFrameLayout)view.findViewById(R.id.shimmer_view_container);

        filterText = (EditText)view.findViewById(R.id.editText);

        countryList = new ArrayList<>();
        countryFlag = new ArrayList<>();
        recyclerView = view.findViewById(R.id.new_case_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        api = RetrofitClient.getInstance().create(Api.class);

        newCaseAdapter = new NewCaseAdapter(getContext(), countryList, countryFlag);
        recyclerView.setAdapter(newCaseAdapter);

        filterText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                getFilter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s){
            }
        });

        loadCountryData();
        loadCountryFlags();
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        shimmerFrameLayout.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        super.onPause();
        shimmerFrameLayout.stopShimmerAnimation();
    }

    public void getFilter(String text) {
        List<Country> list = new ArrayList<>();

        for (Country item : countryList) {
            if (item.getCountry().toLowerCase().contains(text.toLowerCase())) {
                list.add(item);
            }
        }

        newCaseAdapter.filteredCountry(list);
    }

    private void loadCountryFlags() {
        Call<List<CountryInfo>> call = api.getFlags();

        call.enqueue(new Callback<List<CountryInfo>>() {
            @Override
            public void onResponse(Call<List<CountryInfo>> call, Response<List<CountryInfo>> response) {
                countryFlag = response.body();
                Log.d("TAG", "Response = " + countryList);
                newCaseAdapter.loadFlag(countryFlag);

            }

            @Override
            public void onFailure(Call<List<CountryInfo>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }

    private void loadCountryData() {

        Call<List<Country>> call = api.getCountries();

        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                countryList = response.body();
                Collections.sort(countryList, Country.BY_TODAY_CASES.reversed());
                Log.d("TAG", "Response = " + countryList);
                shimmerFrameLayout.stopShimmerAnimation();
                shimmerFrameLayout.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                newCaseAdapter.loadCountries(countryList);


            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }

}
