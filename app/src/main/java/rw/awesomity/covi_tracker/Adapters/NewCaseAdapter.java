package rw.awesomity.covi_tracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

import rw.awesomity.covi_tracker.Models.Country;
import rw.awesomity.covi_tracker.Models.CountryInfo;
import rw.awesomity.covi_tracker.R;

public class NewCaseAdapter extends RecyclerView.Adapter<NewCaseAdapter.NewCaseViewHolder>{

    Context context;
    List<Country> countryList;
    List<CountryInfo> countryFlag;

    public NewCaseAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    public void loadCountries(List<Country> countryList){
        this.countryList = countryList;
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
            int cases = item.getTodayCases();

        DecimalFormat formatter = new DecimalFormat("#,###,###");

            Picasso.get().load(flag).fit().centerInside().into(holder.flags);
            holder.country.setText(country_name);
            holder.total_cases.setText(context.getString(R.string.cases) + " " + formatter.format(cases).toString());

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public void filteredCountry(List<Country> list) {
        countryList = list;
        notifyDataSetChanged();
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

