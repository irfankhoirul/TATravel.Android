package com.irfankhoirul.apps.tatravel.module.reservation.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.core.activity.MainActivity;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragment;
import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */

public class ReservationDetailFragment extends BaseFragment<MainActivity, ReservationDetailContract.Presenter>
        implements ReservationDetailContract.View {

    @BindView(R.id.btPay)
    Button btPay;
    @BindView(R.id.tvDepartureLocation)
    TextView tvDepartureLocation;
    @BindView(R.id.tvPickUpLocation)
    TextView tvPickUpLocation;
    @BindView(R.id.tvPickUpCoordinate)
    TextView tvPickUpCoordinate;
    @BindView(R.id.tvDepartureTime)
    TextView tvDepartureTime;
    @BindView(R.id.tvDestinationLocation)
    TextView tvDestinationLocation;
    @BindView(R.id.tvTakeLocation)
    TextView tvTakeLocation;
    @BindView(R.id.tvTakeCoordinate)
    TextView tvTakeCoordinate;
    @BindView(R.id.tvArrivalTime)
    TextView tvArrivalTime;
    @BindView(R.id.tvOperatorTravel)
    TextView tvOperatorTravel;
    @BindView(R.id.tvPassengerCount)
    TextView tvPassengerCount;
    @BindView(R.id.tvPassengerNames)
    TextView tvPassengerNames;
    @BindView(R.id.tvSeatNumbers)
    TextView tvSeatNumbers;
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

    private Pemesanan reservation;

    public ReservationDetailFragment() {
        // Required empty public constructor
    }

    public static ReservationDetailFragment newInstance(Pemesanan reservation) {
        ReservationDetailFragment reservationDetailFragment = new ReservationDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("reservation", Parcels.wrap(reservation));
        reservationDetailFragment.setArguments(bundle);

        return reservationDetailFragment;
    }

    @Override
    protected void setTitle() {
        title = "Detail Reservasi";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_reservation_detail, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);

        reservation = Parcels.unwrap(getArguments().getParcelable("reservation"));
//        showReservationDetail();

        return fragmentView;
    }

    public void showReservationDetail() {
        tvDepartureLocation.setText(reservation.getJadwalPerjalanan().getLokasiPemberangkatan().getNama() + ", " +
                reservation.getJadwalPerjalanan().getLokasiPemberangkatan().getKota().getNama());
        tvPickUpLocation.setText(reservation.getLokasiPenjemputan().getAlamat());
        tvPickUpCoordinate.setText(reservation.getLokasiPenjemputan().getLatitude() + ", " +
                reservation.getLokasiPenjemputan().getLongitude());
        tvDepartureTime.setText(reservation.getJadwalPerjalanan().getWaktuKeberangkatan() + " " +
                reservation.getJadwalPerjalanan().getTimezone());
        tvDestinationLocation.setText(reservation.getJadwalPerjalanan().getLokasiTujuan().getNama() + ", " +
                reservation.getJadwalPerjalanan().getLokasiTujuan().getKota().getNama());
        tvTakeLocation.setText(reservation.getLokasiPengantaran().getAlamat());
        tvTakeCoordinate.setText(reservation.getLokasiPengantaran().getLatitude() + ", " +
                reservation.getLokasiPengantaran().getLongitude());
        tvArrivalTime.setText(reservation.getJadwalPerjalanan().getWaktuKedatangan() + " " +
                reservation.getJadwalPerjalanan().getTimezone());
        tvOperatorTravel.setText(reservation.getJadwalPerjalanan().getOperatorTravel().getNama());
//        tvPassengerCount.setText();
//        tvPassengerNames.setText();
//        tvSeatNumbers.setText();
//        tvTravelPrice.setText();
//        tvPickUpPrice.setText();
//        tvTakePrice.setText();
//        tvTotalPrice.setText();
//        tvBuyerName.setText();
//        tvBuyerPhoneNumber.setText();
//        tvBuyerEmail.setText();
    }

    @Override
    public void setPresenter(ReservationDetailContract.Presenter presenter) {
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

    @OnClick(R.id.btPay)
    public void btPay() {

    }
}
