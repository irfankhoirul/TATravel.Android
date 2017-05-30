package com.irfankhoirul.apps.tatravel.module.reservation_history;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.core.utils.DateUtils;
import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Irfan Khoirul on 12/24/2016.
 */

public class ReservationHistoryAdapter extends RecyclerView.Adapter<ReservationHistoryAdapter.ScheduleViewHolder> {

    private List<Pemesanan> reservations;
    private OnSpecificItemClick mListener;
    private Calendar today;

    public ReservationHistoryAdapter(List<Pemesanan> reservations, OnSpecificItemClick mListener) {
        this.reservations = reservations;
        this.mListener = mListener;
        today = Calendar.getInstance();
    }

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item_reservation_history, parent, false);

        return new ScheduleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ScheduleViewHolder holder, int position) {
        final Pemesanan item = reservations.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(item);
            }
        });

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            Date date = dateFormat.parse(item.getCreatedAt());
            holder.tvOrderDate.setText(DateUtils.getStandardDayFormat(date.getTime()));
            holder.tvOrderDate.setVisibility(View.VISIBLE);
        } catch (ParseException e) {
            e.printStackTrace();
            holder.tvOrderDate.setVisibility(View.GONE);
        }

//        String dateCreated = item.getCreatedAt().substring(0, 9);
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        Date date;
//        try {
//            date = df.parse(dateCreated);
//            holder.tvOrderDate.setText(DateUtils.getStandardDayFormat(date.getTime()));
//            holder.tvOrderDate.setVisibility(View.VISIBLE);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            holder.tvOrderDate.setVisibility(View.GONE);
//        }

        if (item.getJadwalPerjalanan().getOperatorTravel().getLogo() != null) {
            Picasso.with(holder.ivTravelLogo.getContext())
                    .load(item.getJadwalPerjalanan().getOperatorTravel().getLogo())
                    .error(R.drawable.ic_transport_1)
                    .placeholder(R.drawable.ic_transport_1)
                    .into(holder.ivTravelLogo);
        } else {
            holder.ivTravelLogo.setImageResource(R.drawable.ic_transport_1);
        }

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar scheduleCalendar = Calendar.getInstance();
            scheduleCalendar.setTimeInMillis(format.parse(item.getJadwalPerjalanan().getTanggalKeberangkatan()).getTime());
            if (item.getPembayaran().getStatus().equalsIgnoreCase("O")) {
                holder.llReservationHistoryContainer.setBackgroundColor(
                        ContextCompat.getColor(holder.llReservationHistoryContainer.getContext(),
                                R.color.red_50));
            } else {
                if (scheduleCalendar.after(today)) {
                    holder.llReservationHistoryContainer.setBackgroundColor(
                            ContextCompat.getColor(holder.llReservationHistoryContainer.getContext(),
                                    R.color.green_50));
                } else if (scheduleCalendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)
                        && scheduleCalendar.get(Calendar.YEAR) == today.get(Calendar.YEAR)) {
                    holder.llReservationHistoryContainer.setBackgroundColor(
                            ContextCompat.getColor(holder.llReservationHistoryContainer.getContext(),
                                    R.color.blue_50));
                } else {
                    holder.llReservationHistoryContainer.setBackgroundColor(
                            ContextCompat.getColor(holder.llReservationHistoryContainer.getContext(),
                                    R.color.grey_100));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.tvTravelName.setText(item.getJadwalPerjalanan().getOperatorTravel().getNama());
        if (item.getPembayaran().getStatus().equalsIgnoreCase("P")) {
            holder.tvStatus.setText("Sudah Dibayar");
            holder.tvStatus.setTextColor(
                    ContextCompat.getColor(holder.llReservationHistoryContainer.getContext(),
                            R.color.colorPrimary));
        } else if (item.getPembayaran().getStatus().equalsIgnoreCase("U")) {
            holder.tvStatus.setText("Belum Dibayar");
            holder.tvStatus.setTextColor(
                    ContextCompat.getColor(holder.llReservationHistoryContainer.getContext(),
                            R.color.colorAccent));
        } else if (item.getPembayaran().getStatus().equalsIgnoreCase("O")) {
            holder.tvStatus.setText("Waktu Pembayaran Habis");
            holder.tvStatus.setTextColor(
                    ContextCompat.getColor(holder.llReservationHistoryContainer.getContext(),
                            R.color.alizarin));
        }

        holder.tvDepartureLocation.setText(item.getJadwalPerjalanan().getLokasiPemberangkatan().getNama() + ", " +
                item.getJadwalPerjalanan().getLokasiPemberangkatan().getKota().getNama());
        holder.tvDepartureTime.setText(item.getJadwalPerjalanan().getWaktuKeberangkatan() + " " +
                item.getJadwalPerjalanan().getTimezone());
        holder.tvDestinationLocation.setText(item.getJadwalPerjalanan().getLokasiTujuan().getNama() + ", " +
                item.getJadwalPerjalanan().getLokasiTujuan().getKota().getNama());
        holder.tvDestinationTime.setText(item.getJadwalPerjalanan().getWaktuKedatangan() + " " +
                item.getJadwalPerjalanan().getTimezone());
    }

    @Override
    public int getItemCount() {
        return reservations.size();
    }

    public interface OnSpecificItemClick {
        void onItemClick(Pemesanan reservation);
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.llReservationHistoryContainer)
        LinearLayout llReservationHistoryContainer;
        @BindView(R.id.ivTravelLogo)
        ImageView ivTravelLogo;
        @BindView(R.id.tvTravelName)
        TextView tvTravelName;
        @BindView(R.id.tvStatus)
        TextView tvStatus;
        @BindView(R.id.tvDepartureLocation)
        TextView tvDepartureLocation;
        @BindView(R.id.tvDepartureTime)
        TextView tvDepartureTime;
        @BindView(R.id.tvDestinationLocation)
        TextView tvDestinationLocation;
        @BindView(R.id.tvDestinationTime)
        TextView tvDestinationTime;
        @BindView(R.id.tvOrderDate)
        TextView tvOrderDate;

        public ScheduleViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
