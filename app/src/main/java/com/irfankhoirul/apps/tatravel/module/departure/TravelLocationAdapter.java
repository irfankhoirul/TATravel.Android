package com.irfankhoirul.apps.tatravel.module.departure;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Irfan Khoirul on 12/24/2016.
 */

public class TravelLocationAdapter extends RecyclerView.Adapter<TravelLocationAdapter.TravelLocationViewHolder> {

    private List<Lokasi> locations;
    private OnSpecificItemClick onSpecificItemClick;
    private String cityName;

    public TravelLocationAdapter(List<Lokasi> locations, OnSpecificItemClick onSpecificItemClick, String cityName) {
        this.locations = locations;
        this.cityName = cityName;
        this.onSpecificItemClick = onSpecificItemClick;
    }

    @Override
    public TravelLocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item_location, parent, false);

        return new TravelLocationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TravelLocationViewHolder holder, int position) {
        final Lokasi location = locations.get(position);
        holder.tvTravelName.setText(location.getOperatorTravel().getNama() + ", ");
        holder.tvTravelLocation.setText(location.getAlamat());
        holder.llLocationContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSpecificItemClick.onItemClick(location);
            }
        });

        Picasso.with(holder.ivTravelLogo.getContext())
                .load(location.getOperatorTravel().getLogo())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivTravelLogo);

        if (position == 0) {
            holder.tvCurrentCity.setText(cityName);
            holder.tvCurrentCity.setVisibility(View.VISIBLE);
        } else {
            holder.tvCurrentCity.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public interface OnSpecificItemClick {
        void onItemClick(Lokasi lokasi);
    }

    public class TravelLocationViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvCurrentCity)
        TextView tvCurrentCity;
        @BindView(R.id.llLocationContainer)
        LinearLayout llLocationContainer;
        @BindView(R.id.tvTravelName)
        TextView tvTravelName;
        @BindView(R.id.tvTravelLocation)
        TextView tvTravelLocation;
        @BindView(R.id.ivTravelLogo)
        ImageView ivTravelLogo;

        public TravelLocationViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
