package com.irfankhoirul.apps.tatravel.module.reservation.creator;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragment;
import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */

public class ReservationFragment extends BaseFragment<ReservationActivity, ReservationContract.Presenter>
        implements ReservationContract.View {

    @BindView(R.id.tvDepartureLocation)
    TextView tvDepartureLocation;
    @BindView(R.id.tvDestinationLocation)
    TextView tvDestinationLocation;
    @BindView(R.id.tvOperatorTravel)
    TextView tvOperatorTravel;
    @BindView(R.id.tvDepartureTime)
    TextView tvDepartureTime;
    @BindView(R.id.tvArrivalTime)
    TextView tvArrivalTime;
    @BindView(R.id.tvSeatNumbers)
    TextView tvSeatNumbers;
    @BindView(R.id.tvPassengerCount)
    TextView tvPassengerCount;
    @BindView(R.id.tvPassengerNames)
    TextView tvPassengerNames;
    @BindView(R.id.tvTravelPrice)
    TextView tvTravelPrice;
    @BindView(R.id.tvPickUpPrice)
    TextView tvPickUpPrice;
    @BindView(R.id.tvTakePrice)
    TextView tvTakePrice;
    @BindView(R.id.tvTotalPrice)
    TextView tvTotalPrice;
    @BindView(R.id.tvBuyerName)
    TextView tvBuyerName;
    @BindView(R.id.tvBuyerPhoneNumber)
    TextView tvBuyerPhoneNumber;
    @BindView(R.id.tvBuyerEmail)
    TextView tvBuyerEmail;
    @BindView(R.id.tvPickUpLocation)
    TextView tvPickUpLocation;
    @BindView(R.id.tvPickUpCoordinate)
    TextView tvPickUpCoordinate;
    @BindView(R.id.tvTakeLocation)
    TextView tvTakeLocation;
    @BindView(R.id.tvTakeCoordinate)
    TextView tvTakeCoordinate;

    public ReservationFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setTitle() {
        title = "Detail Reservasi";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_reservation, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);

        return fragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(ReservationContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setLoadingDialog(boolean isLoading, @Nullable String message) {
        super.setLoadingDialog(isLoading, message);
    }

    @Override
    public void showStatus(int type, String message) {
        super.showStatus(type, message);
    }

    @Override
    public void showDetailReservation(Map<String, String> reservationData) {
        tvDepartureLocation.setText(reservationData.get("departureLocation"));
        tvPickUpLocation.setText(reservationData.get("pickUpLocation"));
        tvPickUpCoordinate.setText(reservationData.get("pickUpCoordinate"));
        tvDepartureTime.setText(reservationData.get("departureTime"));
        tvDestinationLocation.setText(reservationData.get("destinationLocation"));
        tvTakeLocation.setText(reservationData.get("takeLocation"));
        tvTakeCoordinate.setText(reservationData.get("takeCoordinate"));
        tvArrivalTime.setText(reservationData.get("arrivalTime"));
        tvOperatorTravel.setText(reservationData.get("operatorTravel"));
        tvPassengerCount.setText(reservationData.get("passengerCount"));
        tvPassengerNames.setText(reservationData.get("passengerNames"));
        tvSeatNumbers.setText(reservationData.get("seatNumbers"));
        tvTravelPrice.setText(reservationData.get("travelPrice"));
        tvPickUpPrice.setText(reservationData.get("pickUpPrice"));
        tvTakePrice.setText(reservationData.get("takePrice"));
        tvTotalPrice.setText(reservationData.get("totalPrice"));
        tvBuyerName.setText(reservationData.get("buyerName"));
        tvBuyerPhoneNumber.setText(reservationData.get("buyerPhoneNumber"));
        tvBuyerEmail.setText(reservationData.get("buyerEmail"));
    }

    @Override
    public void finishActivity() {
        activity.setResult(ConstantUtils.REQUEST_RESULT_SUCCESS);
        activity.finish();
    }

    @OnClick(R.id.btMakeReservation)
    public void btMakeReservation() {
        if (mPresenter.isTimeAvailable()) {
            AlertDialog.Builder builder = createAlert("Perhatian", "Setelah melakukan pemesanan, anda " +
                    "memiliki waktu 5 jam untuk melakukan pembayaran. Jika Anda tidak melakukan pembayaran " +
                    "hingga 5 jam setelah melakukan pemesanan, pesanan Anda akan dibatalkan.");
            builder.setCancelable(false);
            builder.setPositiveButton("Setuju", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mPresenter.makeReservation();
                }
            });
            builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create().show();
        } else {
            showStatus(ConstantUtils.STATUS_ERROR, "Waktu pemesanan habis. Silakan ulangi lagi.");
            activity.setResult(ConstantUtils.REQUEST_RESULT_ERROR);
            activity.finish();
        }
    }

}
