package com.irfankhoirul.apps.tatravel.module.schedule;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.core.components.util.CurrencyUtils;
import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Irfan Khoirul on 12/24/2016.
 */

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    private List<JadwalPerjalanan> schedules;
    private OnSpecificItemClick mListener;

    public ScheduleAdapter(List<JadwalPerjalanan> schedules, OnSpecificItemClick mListener) {
        this.schedules = schedules;
        this.mListener = mListener;
    }

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item_travel_schedule, parent, false);

        return new ScheduleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ScheduleViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(schedules.get(holder.getAdapterPosition()));
            }
        });

        JadwalPerjalanan item = schedules.get(position);

        holder.tvDepartureLocation.setText(item.getLokasiPemberangkatan().getNama() + ", " +
                item.getLokasiPemberangkatan().getKota().getNama());

        holder.tvDepartureTime.setText(item.getWaktuKeberangkatan() + " " + item.getTimezone());

        holder.tvDestinationLocation.setText(item.getLokasiTujuan().getNama() + ", " +
                item.getLokasiTujuan().getKota().getNama());

        holder.tvDestinationTime.setText(item.getWaktuKedatangan() + " " + item.getTimezone());

        holder.tvPrice.setText(CurrencyUtils.formatRupiah(item.getHarga()) + "*");

    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }

    public interface OnSpecificItemClick {
        void onItemClick(JadwalPerjalanan schedule);
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvPrice)
        TextView tvPrice;
        @BindView(R.id.tvDepartureLocation)
        TextView tvDepartureLocation;
        @BindView(R.id.tvDepartureTime)
        TextView tvDepartureTime;
        @BindView(R.id.tvDestinationLocation)
        TextView tvDestinationLocation;
        @BindView(R.id.tvDestinationTime)
        TextView tvDestinationTime;

        public ScheduleViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
