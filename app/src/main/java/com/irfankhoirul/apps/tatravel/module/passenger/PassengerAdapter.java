package com.irfankhoirul.apps.tatravel.module.passenger;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Irfan Khoirul on 12/24/2016.
 */

public class PassengerAdapter extends RecyclerView.Adapter<PassengerAdapter.ScheduleViewHolder> {

    private List<Penumpang> passengers;
    private OnSpecificItemClick mListener;

    public PassengerAdapter(List<Penumpang> passengers, OnSpecificItemClick mListener) {
        this.passengers = passengers;
        this.mListener = mListener;
    }

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item_passenger, parent, false);

        return new ScheduleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ScheduleViewHolder holder, int position) {
        holder.tvPassengerName.setText(passengers.get(position).getNama());
        holder.cbPassengerSelected.setChecked(passengers.get(position).isSelected());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passengers.get(holder.getAdapterPosition()).isSelected()) {
                    holder.cbPassengerSelected.setChecked(false);
                    passengers.get(holder.getAdapterPosition()).setSelected(false);
                    mListener.onItemClick(passengers.get(holder.getAdapterPosition()), false);
                } else {
                    holder.cbPassengerSelected.setChecked(true);
                    passengers.get(holder.getAdapterPosition()).setSelected(true);
                    mListener.onItemClick(passengers.get(holder.getAdapterPosition()), true);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mListener.oItemLongClick(passengers.get(holder.getAdapterPosition()), holder.getAdapterPosition());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return passengers.size();
    }

    public interface OnSpecificItemClick {
        void onItemClick(Penumpang passenger, boolean isSelected);

        void oItemLongClick(Penumpang passenger, int position);
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvPassengerName)
        TextView tvPassengerName;
        @BindView(R.id.cbPassengerSelected)
        CheckBox cbPassengerSelected;
        @BindView(R.id.llPassenger)
        LinearLayout llPassenger;

        public ScheduleViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
