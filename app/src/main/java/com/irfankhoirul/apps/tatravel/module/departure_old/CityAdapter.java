package com.irfankhoirul.apps.tatravel.module.departure_old;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.data.pojo.Kota;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Irfan Khoirul on 12/24/2016.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    private List<Kota> cities;
    private OnSpecificItemClick onSpecificItemClick;

    public CityAdapter(List<Kota> cities, OnSpecificItemClick onSpecificItemClick) {
        this.cities = cities;
        this.onSpecificItemClick = onSpecificItemClick;
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item_city, parent, false);

        return new CityViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        final Kota city = cities.get(position);
        holder.tvCity.setText(city.getNama() + ", ");
        holder.tvProvince.setText(city.getProvinsi().getNama());
        holder.llCityContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSpecificItemClick.onItemClick(city);
            }
        });

        if (position == 0) {
            holder.tvCurrentProvince.setText(city.getProvinsi().getNama());
            holder.tvCurrentProvince.setVisibility(View.VISIBLE);
        } else {
            if (city.getIdProvinsi() == cities.get(position - 1).getIdProvinsi()) {
                holder.tvCurrentProvince.setVisibility(View.GONE);
            } else {
                holder.tvCurrentProvince.setText(city.getProvinsi().getNama());
                holder.tvCurrentProvince.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public interface OnSpecificItemClick {
        void onItemClick(Kota city);
    }

    public class CityViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.llCityContainer)
        LinearLayout llCityContainer;
        @BindView(R.id.tvCity)
        TextView tvCity;
        @BindView(R.id.tvProvince)
        TextView tvProvince;
        @BindView(R.id.tvCurrentProvince)
        TextView tvCurrentProvince;

        public CityViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
