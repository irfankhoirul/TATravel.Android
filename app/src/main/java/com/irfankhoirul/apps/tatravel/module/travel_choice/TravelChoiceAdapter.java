package com.irfankhoirul.apps.tatravel.module.travel_choice;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.data.pojo.OperatorTravel;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Irfan Khoirul on 12/24/2016.
 */

public class TravelChoiceAdapter extends RecyclerView.Adapter<TravelChoiceAdapter.TravelChoiceViewHolder> {

    private List<OperatorTravel> operatorTravelList;
    private OnSpecificItemClick mListener;

    public TravelChoiceAdapter(List<OperatorTravel> operatorTravelList, OnSpecificItemClick mListener) {
        this.operatorTravelList = operatorTravelList;
        this.mListener = mListener;
    }

    @Override
    public TravelChoiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item_operator_travel_choice, parent, false);

        return new TravelChoiceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TravelChoiceViewHolder holder, int position) {
        final OperatorTravel item = operatorTravelList.get(position);
        Picasso.with(holder.ivTravelLogo.getContext())
                .load(item.getLogo())
                .placeholder(R.drawable.ic_transport_2)
                .error(R.drawable.ic_transport_2)
                .into(holder.ivTravelLogo);

        holder.tvTravelLocationName.setText(item.getNama());
        holder.tvLocationDistance.setText(item.getKeterangan().get("distance") + " KM dari lokasi Anda");
        if (item.getBiayaLokasiKhusus() == 0) {
            holder.tvDistancePrice.setText("Gratis biaya penjemputan dan pengantaran");
        } else {
            holder.tvDistancePrice.setText("Rp " + item.getBiayaLokasiKhusus() + ",- per KM penjemputan dan pengantaran");
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return operatorTravelList.size();
    }

    public interface OnSpecificItemClick {
        void onItemClick(OperatorTravel lokasi);
    }

    public class TravelChoiceViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivTravelLogo)
        ImageView ivTravelLogo;
        @BindView(R.id.tvTravelLocationName)
        TextView tvTravelLocationName;
        @BindView(R.id.tvLocationDistance)
        TextView tvLocationDistance;
        @BindView(R.id.tvDistancePrice)
        TextView tvDistancePrice;

        public TravelChoiceViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
