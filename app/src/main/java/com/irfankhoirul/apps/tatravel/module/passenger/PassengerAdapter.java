package com.irfankhoirul.apps.tatravel.module.passenger;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

public class PassengerAdapter extends RecyclerView.Adapter<PassengerAdapter.TravelChoiceViewHolder> {

    private List<Penumpang> passengers;
    private OnSpecificItemClick mListener;

    public PassengerAdapter(List<Penumpang> passengers, OnSpecificItemClick mListener) {
        this.passengers = passengers;
        this.mListener = mListener;
    }

    @Override
    public TravelChoiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item_passenger, parent, false);

        return new TravelChoiceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TravelChoiceViewHolder holder, int position) {
        final Penumpang item = passengers.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(item);
                if (holder.cbPassengerSelected.isSelected()) {
                    holder.cbPassengerSelected.setSelected(false);
                } else {
                    holder.cbPassengerSelected.setSelected(true);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mListener.oItemLongClick(item);
                return true;
            }
        });

        holder.tvPassengerName.setText(item.getNama());
        holder.cbPassengerSelected.setSelected(item.isSelected());

        holder.cbPassengerSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                holder.itemView.performClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return passengers.size();
    }

    public interface OnSpecificItemClick {
        void onItemClick(Penumpang passenger);

        void oItemLongClick(Penumpang passenger);
    }

    public class TravelChoiceViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvPassengerName)
        TextView tvPassengerName;
        @BindView(R.id.cbPassengerSelected)
        CheckBox cbPassengerSelected;
        @BindView(R.id.llPassenger)
        LinearLayout llPassenger;

        public TravelChoiceViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
