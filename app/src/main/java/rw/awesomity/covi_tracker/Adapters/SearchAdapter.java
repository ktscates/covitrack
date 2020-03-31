package rw.awesomity.covi_tracker.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import rw.awesomity.covi_tracker.Models.Country;
import rw.awesomity.covi_tracker.Models.CountryInfo;
import rw.awesomity.covi_tracker.R;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    Context context;
    List<Country> countryList;
    List<CountryInfo> countryFlag;
    Dialog dialogBoxInfo;

    public SearchAdapter(Context context, List<Country> countryList, List<CountryInfo> countryFlag) {
        this.context = context;
        this.countryList = countryList;
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
        final SearchViewHolder viewHolder = new SearchViewHolder(view);

        dialogBoxInfo = new Dialog(context);
        dialogBoxInfo.setContentView(R.layout.dialog_country_info);

        viewHolder.search_recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_country_name = (TextView) dialogBoxInfo.findViewById(R.id.dialog_coutry);
                TextView dialog_total = (TextView) dialogBoxInfo.findViewById(R.id.dialog_total);
                TextView dialog_cases = (TextView) dialogBoxInfo.findViewById(R.id.dialog_cases);
                TextView dialog_active = (TextView) dialogBoxInfo.findViewById(R.id.dialog_active);
                TextView dialog_recover = (TextView) dialogBoxInfo.findViewById(R.id.dialog_recover);
                TextView dialog_death = (TextView) dialogBoxInfo.findViewById(R.id.dialog_death);
                ImageView dialog_flag = (ImageView) dialogBoxInfo.findViewById(R.id.dialog_flag);

                dialog_country_name.setText(countryList.get(viewHolder.getAdapterPosition()).getCountry());
                dialog_total.setText("Total cases: " + countryList.get(viewHolder.getAdapterPosition()).getCases());
                dialog_cases.setText("New cases: " + countryList.get(viewHolder.getAdapterPosition()).getTodayCases());
                dialog_active.setText("Active cases: " + countryList.get(viewHolder.getAdapterPosition()).getActive());
                dialog_recover.setText("Total recovered: " + countryList.get(viewHolder.getAdapterPosition()).getRecovered());
                dialog_death.setText("Total deaths: " + countryList.get(viewHolder.getAdapterPosition()).getDeaths());
                Picasso.get().load(countryFlag.get(viewHolder.getAdapterPosition()).getFlag()).into(dialog_flag);

                dialogBoxInfo.show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.SearchViewHolder holder, int position) {
        Country item = countryList.get(position);
        CountryInfo countryInfo = item.getCountryInfo();

        String flag = countryInfo.getFlag();
        String country_name = item.getCountry();
        String cases = item.getCases();

        Picasso.get().load(flag).fit().centerCrop().into(holder.flags);
        holder.country.setText(country_name);
        holder.total_cases.setText("Total cases: " + cases);
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        CardView search_recycler;
        ImageView flags;
        TextView country;
        TextView total_cases;

        public SearchViewHolder(View itemView) {
            super(itemView);
            search_recycler = (CardView) itemView.findViewById(R.id.search_recycler);
            flags = (ImageView) itemView.findViewById(R.id.flag);
            country = (TextView)itemView.findViewById(R.id.country);
            total_cases = (TextView)itemView.findViewById(R.id.total_cases);
        }
    }
}

