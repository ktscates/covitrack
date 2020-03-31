package rw.awesomity.covi_tracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import rw.awesomity.covi_tracker.Models.Country;
import rw.awesomity.covi_tracker.Models.CountryInfo;
import rw.awesomity.covi_tracker.R;

public class NewCaseAdapter extends RecyclerView.Adapter<NewCaseAdapter.NewCaseViewHolder> {

    Context context;
    List<Country> countryList;
    List<Country> countryListSearch;
    List<CountryInfo> countryFlag;

    public NewCaseAdapter(Context context, List<Country> countryList, List<CountryInfo> countryFlag) {
        this.context = context;
        this.countryList = countryList;
        countryListSearch = new ArrayList<>(countryList);
        this.countryFlag = countryFlag;

    }

    public void loadCountries(List<Country> countryList){
        this.countryList = countryList;
        notifyDataSetChanged();
    }
    public void loadFlag(List<CountryInfo> countryFlag){
        this.countryFlag = countryFlag;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewCaseAdapter.NewCaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_case_recycler, parent, false);
        return new NewCaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewCaseAdapter.NewCaseViewHolder holder, int position) {
        Country item = countryList.get(position);

        CountryInfo countryInfo = item.getCountryInfo();

            String flag = countryInfo.getFlag();
            String country_name = item.getCountry();
            String cases = item.getTodayCases();

            Picasso.get().load(flag).fit().centerInside().into(holder.flags);
            holder.country.setText(country_name);
            holder.total_cases.setText("New cases: " + cases);

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class NewCaseViewHolder extends RecyclerView.ViewHolder {
        ImageView flags;
        TextView country;
        TextView total_cases;

        public NewCaseViewHolder(View itemView) {
            super(itemView);
            flags = (ImageView) itemView.findViewById(R.id.flag);
            country = (TextView)itemView.findViewById(R.id.country);
            total_cases = (TextView)itemView.findViewById(R.id.total_cases);
        }
    }
}

