package com.irfankhoirul.apps.tatravel.module.seat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragment;
import com.irfankhoirul.apps.tatravel.data.pojo.KursiPerjalanan;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */

public class SeatFragment extends BaseFragment<SeatActivity> implements
        SeatContract.View {

    @BindView(R.id.llSeatLayout)
    LinearLayout llSeatLayout;

    SeatContract.Presenter mPresenter;

    private View layout;
    private List<ImageView> seatViews = new ArrayList<>();
    private KursiPerjalanan selectedSeat;

    public SeatFragment() {
        // Required empty public constructor
    }

    public static SeatFragment newInstance(int scheduleId) {
        SeatFragment seatFragment = new SeatFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("scheduleId", scheduleId);
        seatFragment.setArguments(bundle);

        return seatFragment;
    }

    @Override
    protected void setTitle() {
        title = "Pilih Kursi";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_seat, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        mPresenter.start();

        mPresenter.getCarSeats(getArguments().getInt("scheduleId"));

        return fragmentView;
    }

    @Override
    public void setPresenter(SeatContract.Presenter presenter) {
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

    @OnClick(R.id.btSetSeat)
    public void btSetSeat() {
        if (selectedSeat != null) {
            // Show dialog batas waktu order = 10 menit
            AlertDialog.Builder builder = createAlert("Perhatian", "Setelah memilih kursi, anda memiliki waktu 10 menit untuk menyelesaikan pemesanan sebelum anda harus melakukan pembayaran");
            builder.setCancelable(false);
            builder.setPositiveButton("Lanjutkan", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mPresenter.bookSeat(selectedSeat);
                }
            });
            builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create().show();
        }
    }

    @Override
    public void showSeats(List<KursiPerjalanan> seats) {
        switch (seats.size()) {
            case 5:
                layout = activity.getLayoutInflater().inflate(R.layout.car_5_seat, null);
                llSeatLayout.addView(layout);
                setup5Seats();
                handelSeatClick(seats);
                break;
            case 6:
                layout = activity.getLayoutInflater().inflate(R.layout.car_6_seat, null);
                llSeatLayout.addView(layout);
                setup6Seats();
                handelSeatClick(seats);
                break;
            case 10:
                layout = activity.getLayoutInflater().inflate(R.layout.car_10_seat, null);
                llSeatLayout.addView(layout);
                setup10Seats();
                handelSeatClick(seats);
                break;
            case 14:
                layout = activity.getLayoutInflater().inflate(R.layout.car_14_seat, null);
                llSeatLayout.addView(layout);
                setup14Seats();
                handelSeatClick(seats);
                break;
            case 19:
                layout = activity.getLayoutInflater().inflate(R.layout.car_19_seat, null);
                llSeatLayout.addView(layout);
                setup19Seats();
                handelSeatClick(seats);
                break;
        }
    }

    @Override
    public void redirectToReservationDetail() {
        // Intent ke detail order
    }

    @Override
    public void setup5Seats() {
        seatViews.clear();
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat1));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat2));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat3));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat4));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat5));
    }

    @Override
    public void setup6Seats() {
        seatViews.clear();
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat1));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat2));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat3));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat4));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat5));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat6));
    }

    @Override
    public void setup10Seats() {
        seatViews.clear();
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat1));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat2));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat3));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat4));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat5));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat6));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat7));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat8));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat9));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat10));
    }

    @Override
    public void setup14Seats() {
        seatViews.clear();
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat1));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat2));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat3));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat4));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat5));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat6));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat7));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat8));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat9));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat10));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat11));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat12));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat13));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat14));
    }

    @Override
    public void setup19Seats() {
        seatViews.clear();
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat1));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat2));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat3));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat4));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat5));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat6));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat7));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat8));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat9));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat10));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat11));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat12));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat13));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat14));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat15));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat16));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat17));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat18));
        seatViews.add((ImageView) layout.findViewById(R.id.ivSeat19));
    }

    public void handelSeatClick(final List<KursiPerjalanan> seats) {
        for (int i = 0; i < seatViews.size(); i++) {
            if (seats.get(i).getStatus().equalsIgnoreCase("A")) {
                final int finalI = i;
                seatViews.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selectedSeat = null;
                        for (int j = 0; j < seatViews.size(); j++) {
                            if (j != finalI) {
                                seatViews.get(j).setImageResource(R.drawable.ic_car_seat_available);
                                seats.get(finalI).setSelected(false);
                            }
                        }

                        if (!seats.get(finalI).isSelected()) {
                            selectedSeat = seats.get(finalI);
                            seatViews.get(finalI).setImageResource(R.drawable.ic_car_seat_selected);
                            seats.get(finalI).setSelected(true);
                        } else {
                            seatViews.get(finalI).setImageResource(R.drawable.ic_car_seat_available);
                            seats.get(finalI).setSelected(false);
                        }
                    }
                });
            } else {
                seatViews.get(i).setImageResource(R.drawable.ic_car_seat_unavailable);
            }
        }
    }
}
