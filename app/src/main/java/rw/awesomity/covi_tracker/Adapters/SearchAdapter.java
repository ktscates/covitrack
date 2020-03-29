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

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> implements Filterable{

    Context context;
    List<Country> countryList;
    List<Country> countryListSearch;
    List<CountryInfo> countryFlag;

    public SearchAdapter(Context context, List<Country> countryList, List<CountryInfo> countryFlag) {
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
    public SearchAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_recycler, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.SearchViewHolder holder, int position) {
        Country item = countryList.get(position);

        CountryInfo countryInfo = item.getCountryInfo();

        String flag = countryInfo.getFlag();
        String country_name = item.getCountry();
//        int cases = item.getCases();
//        int today_cases = item.getTodayCases();
//        int actives = item.getActive();
//        int recover = item.getRecovered();
//        int death = item.getDeaths();

        Picasso.get().load(flag).fit().centerInside().into(holder.flags);
        holder.country.setText("Country: " + country_name);
//        holder.total_cases.setText("Total: " +cases);
//        holder.new_cases.setText("New Cases: " +today_cases);
//        holder.active.setText("Active Cases: " +actives);
//        holder.recovered.setText("Recovered: " +recover);
//        holder.deaths.setText("Total Death: " +death);
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    @Override
    public Filter getFilter(){
        return countryListFilter;
    }

    private Filter countryListFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Country> filteredCharacters = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredCharacters.addAll(countryListSearch);
            } else {
                String filterCharacter = constraint.toString().toLowerCase().trim();

                for (Country item : countryListSearch) {
                    if (item.getCountry().toLowerCase().contains(filterCharacter)) {
                        filteredCharacters.add(item);
                    }
                }
            }

            FilterResults result = new FilterResults();
            result.values = filteredCharacters;

            return result;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            countryList.clear();
            countryList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        ImageView flags;
        TextView country;
//        TextView total_cases;
//        TextView new_cases;
//        TextView active;
//        TextView recovered;
//        TextView deaths;

        public SearchViewHolder(View itemView) {
            super(itemView);
            flags = (ImageView) itemView.findViewById(R.id.flag);
            country = (TextView)itemView.findViewById(R.id.country);
//            total_cases = (TextView)itemView.findViewById(R.id.total_cases);
//            new_cases = (TextView)itemView.findViewById(R.id.new_cases);
//            active = (TextView)itemView.findViewById(R.id.active);
//            recovered = (TextView)itemView.findViewById(R.id.recovered);
//            deaths = (TextView)itemView.findViewById(R.id.deaths);
        }
    }
}

