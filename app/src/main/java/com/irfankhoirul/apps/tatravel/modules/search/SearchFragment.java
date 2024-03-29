package com.irfankhoirul.apps.tatravel.modules.search;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.components.ConstantUtils;
import com.irfankhoirul.apps.tatravel.components.DateUtils;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;
import com.irfankhoirul.apps.tatravel.modules.MainActivity;
import com.irfankhoirul.apps.tatravel.modules.departure.DepartureActivity;
import com.irfankhoirul.apps.tatravel.modules.destination.DestinationActivity;
import com.irfankhoirul.apps.tatravel.modules.passenger.PassengerActivity;
import com.irfankhoirul.apps.tatravel.modules.reservation_detail.ReservationDetailActivity;
import com.irfankhoirul.apps.tatravel.modules.schedule.ScheduleActivity;
import com.irfankhoirul.mvp_core.base.BaseFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.irfankhoirul.apps.tatravel.components.ConstantUtils.STATUS_ERROR;

/**
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (7 November 2016)
 * @since 1.0
 */
public class SearchFragment extends BaseFragment<MainActivity, SearchContract.Presenter> implements SearchContract.View {

    @BindView(R.id.llDeparture)
    LinearLayout llDeparture;
    @BindView(R.id.llDestination)
    LinearLayout llDestination;
    @BindView(R.id.tvDeparture)
    TextView tvDeparture;
    @BindView(R.id.tvDestination)
    TextView tvDestination;
    @BindView(R.id.tvDateGo)
    TextView tvDateGo;
    @BindView(R.id.tvPassenger)
    TextView tvPassenger;
    @BindView(R.id.llDepartureDate)
    LinearLayout llDepartureDate;
    @BindView(R.id.llReturnDate)
    LinearLayout llReturnDate;
    @BindView(R.id.llPassenger)
    LinearLayout llPassenger;

    private FragmentListener listener;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setTitle() {
        title = getString(R.string.app_name);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        unbinder = ButterKnife.bind(this, view);
//        setRetainInstance(true);

//        mPresenter.getPromo();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (FragmentListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public void redirectToLoginOrRegister() {
        AlertDialog.Builder builder = createAlert("Login", "Anda harus login untuk menambahkan penumpang");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.redirectToLoginOrRegister();
            }
        });
        builder.create().show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ConstantUtils.ACTIVITY_REQUEST_CODE_DEPARTURE && resultCode == ConstantUtils.REQUEST_RESULT_SUCCESS) {
            String departureLocation = "";
            if (data.getStringExtra("thoroughfare") == null && data.getStringExtra("locality") == null &&
                    data.getStringExtra("sub_admin") == null) {
                departureLocation += String.valueOf(data.getDoubleExtra("latitude", 0)) + ", " +
                        String.valueOf(data.getDoubleExtra("longitude", 0));
            } else {
                if (data.getStringExtra("thoroughfare") != null) {
                    departureLocation += data.getStringExtra("thoroughfare");
                }
                if (data.getStringExtra("locality") != null) {
                    if (data.getStringExtra("thoroughfare") != null) {
                        departureLocation += ", ";
                    }
                    departureLocation += data.getStringExtra("locality");
                }
                if (data.getStringExtra("sub_admin") != null) {
                    if (data.getStringExtra("locality") != null) {
                        departureLocation += ", ";
                    }
                    departureLocation += data.getStringExtra("sub_admin");
                }
            }

            Map<String, String> departureData = new HashMap<>();
            departureData.put("address", departureLocation);
            departureData.put("latitude", String.valueOf(data.getDoubleExtra("latitude", 0)));
            departureData.put("longitude", String.valueOf(data.getDoubleExtra("longitude", 0)));
            departureData.put("operatorTravelId", String.valueOf(data.getIntExtra("id_operator_travel", -1)));
            departureData.put("operatorTravelLocationIds", new Gson().toJson(data.getIntegerArrayListExtra("operatorTravelLocationIds")));

            mPresenter.setDeparture(departureData);

            setDepartureView(departureLocation);

            // Reset destination karena departure berubah
            resetDestinationView();

            // Reset tanggal keberangkatan karena destination berubah / departure berubah
            resetDateView();
        } else if (requestCode == ConstantUtils.ACTIVITY_REQUEST_CODE_DESTINATION && resultCode == ConstantUtils.REQUEST_RESULT_SUCCESS) {
            String destinationLocation = "";
            if (data.getStringExtra("thoroughfare") == null && data.getStringExtra("locality") == null &&
                    data.getStringExtra("sub_admin") == null) {
                destinationLocation += String.valueOf(data.getDoubleExtra("latitude", 0)) + ", " +
                        String.valueOf(data.getDoubleExtra("longitude", 0));
            } else {
                if (data.getStringExtra("thoroughfare") != null) {
                    destinationLocation += data.getStringExtra("thoroughfare");
                }
                if (data.getStringExtra("locality") != null) {
                    destinationLocation += ", " + data.getStringExtra("locality");
                }
                if (data.getStringExtra("sub_admin") != null) {
                    destinationLocation += ", " + data.getStringExtra("sub_admin");
                }
            }
            setDestinationView(destinationLocation);

            Map<String, String> destinationData = new HashMap<>();
            destinationData.put("address", destinationLocation);
            destinationData.put("latitude", String.valueOf(data.getDoubleExtra("latitude", 0)));
            destinationData.put("longitude", String.valueOf(data.getDoubleExtra("longitude", 0)));
            destinationData.put("operatorTravelLocationIds", new Gson().toJson(data.getIntegerArrayListExtra("operatorTravelLocationIds")));

            mPresenter.setDestination(destinationData);

            // Reset tanggal keberangkatan karena destination berubah / departure berubah
            resetDateView();
        } else if (requestCode == ConstantUtils.ACTIVITY_REQUEST_CODE_PASSENGER && resultCode == ConstantUtils.REQUEST_RESULT_SUCCESS) {
            mPresenter.clearPassenger();
            if (data.getParcelableArrayListExtra("selectedPassengers") != null) {
                ArrayList<Penumpang> selectedPassengers = data.getParcelableArrayListExtra("selectedPassengers");
                if (selectedPassengers != null) {
                    Log.v("SelectedPassenger", "OnActResult");
                    for (int i = 0; i < selectedPassengers.size(); i++) {
                        Log.v("Passenger", selectedPassengers.get(i).toString());
                    }
                } else {
                    Log.v("SelectedPassenger", "OnActResult NUll");
                }

                mPresenter.setSelectedPassengers(selectedPassengers);
                if (mPresenter.getSelectedPassengers().size() > 0) {
                    setPassengerView(mPresenter.getSelectedPassengers());
                } else {
                    resetPassengerView();
                }
            } else {
                resetPassengerView();
            }
        } else if (requestCode == ConstantUtils.ACTIVITY_REQUEST_CODE_SCHEDULE) {
            if (resultCode == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                resetDepartureView();
                resetDestinationView();
                resetDateView();
                resetPassengerView();
                mPresenter.start();
                Intent intent = new Intent(activity, ReservationDetailActivity.class);
                startActivityForResult(intent, ConstantUtils.ACTIVITY_REQUEST_CODE_DETAIL_RESERVATION);
            }
        } else if (requestCode == ConstantUtils.ACTIVITY_REQUEST_CODE_DETAIL_RESERVATION) {

        }
    }

    @Override
    public void setDepartureView(String departureLocation) {
        tvDeparture.setText(departureLocation);
        tvDeparture.setTextColor(ContextCompat.getColor(activity, R.color.font_black_primary));
        llDeparture.setBackgroundColor(ContextCompat.getColor(activity, R.color.grey_50));
    }

    @Override
    public void setDestinationView(String destinationLocation) {
        tvDestination.setText(destinationLocation);
        tvDestination.setTextColor(ContextCompat.getColor(activity, R.color.font_black_primary));
        llDestination.setBackgroundColor(ContextCompat.getColor(activity, R.color.grey_50));
    }

    @Override
    public void setPassengerView(List<Penumpang> selectedPassengers) {
        tvPassenger.setText("");
        tvPassenger.setTextColor(ContextCompat.getColor(activity, R.color.font_black_primary));
        for (int i = 0; i < selectedPassengers.size(); i++) {
            tvPassenger.append(selectedPassengers.get(i).getNama());
            if (i < selectedPassengers.size() - 1) {
                tvPassenger.append(", ");
            }
        }
        llPassenger.setBackgroundColor(ContextCompat.getColor(activity, R.color.grey_50));
    }

    @Override
    public void setDateView(long date) {
        tvDateGo.setText(DateUtils.getStandardDayFormat(date));
        tvDateGo.setTextColor(ContextCompat.getColor(activity, R.color.font_black_primary));
        llDepartureDate.setBackgroundColor(ContextCompat.getColor(activity, R.color.grey_50));
    }

    private void resetDepartureView() {
        llDepartureDate.setBackgroundColor(ContextCompat.getColor(activity, R.color.red_50));
        tvDeparture.setText("Pilih Lokasi Keberangkatan");
        tvDeparture.setTextColor(ContextCompat.getColor(activity, R.color.font_black_disabled));
        mPresenter.clearDeparture();
    }

    private void resetDestinationView() {
        llDestination.setBackgroundColor(ContextCompat.getColor(activity, R.color.red_50));
        tvDestination.setText("Pilih Lokasi Tujuan");
        tvDestination.setTextColor(ContextCompat.getColor(activity, R.color.font_black_disabled));
        mPresenter.clearDestination();
    }

    private void resetDateView() {
        llDepartureDate.setBackgroundColor(ContextCompat.getColor(activity, R.color.red_50));
        tvDateGo.setText("Pilih Tanggal Keberangkatan");
        tvDateGo.setTextColor(ContextCompat.getColor(activity, R.color.font_black_disabled));
        mPresenter.clearDate();
    }

    private void resetPassengerView() {
        tvPassenger.setText("Tambahkan Penumpang");
        tvPassenger.setTextColor(ContextCompat.getColor(activity, R.color.font_black_disabled));
        llPassenger.setBackgroundColor(ContextCompat.getColor(activity, R.color.red_50));
        mPresenter.clearPassenger();
    }

    @Override
    public void setPresenter(@NonNull SearchContract.Presenter presenter) {
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

    @OnClick(R.id.llDeparture)
    public void llDeparture() {
        Intent intent = new Intent(activity, DepartureActivity.class);
        startActivityForResult(intent, ConstantUtils.ACTIVITY_REQUEST_CODE_DEPARTURE);
    }

    @OnClick(R.id.llDestination)
    public void llDestination() {
        if (mPresenter.isDepartureSet()) {
            Intent intent = new Intent(activity, DestinationActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("id_operator_travel", mPresenter.getSelectedOperatorTravelId());
            intent.putExtras(bundle);
            startActivityForResult(intent, ConstantUtils.ACTIVITY_REQUEST_CODE_DESTINATION);
        } else {
            showStatus(STATUS_ERROR, "Anda belum memilih lokasi keberangkatan");
        }
    }

    @OnClick(R.id.llDepartureDate)
    public void llDepartureDate() {
        if (mPresenter.isDestinationSet()) {
            final Calendar newCalendar = Calendar.getInstance();
            DatePickerDialog fromDatePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    Calendar selectedDate = Calendar.getInstance();
                    selectedDate.set(year, monthOfYear, dayOfMonth);
                    newCalendar.setTimeInMillis(selectedDate.getTimeInMillis());
                    mPresenter.setDate(selectedDate.getTimeInMillis());
                    setDateView(selectedDate.getTimeInMillis());
                }
            }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
            fromDatePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() + 86401000);
            fromDatePickerDialog.show();
        } else {
            showStatus(STATUS_ERROR, "Anda belum memilih lokasi tujuan");
        }
    }

    @OnCheckedChanged(R.id.swPulangPergi)
    public void swPulangPergi(boolean isChecked) {
        if (isChecked) {
            llReturnDate.setVisibility(View.VISIBLE);
        } else {
            llReturnDate.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.llPassenger)
    public void llPassenger() {
        if (mPresenter.isLoggedIn()) {
            if (mPresenter.isDateSet()) {
                Intent intent = new Intent(activity, PassengerActivity.class);
                intent.putParcelableArrayListExtra("selectedPassengers", mPresenter.getSelectedPassengers());
                startActivityForResult(intent, ConstantUtils.ACTIVITY_REQUEST_CODE_PASSENGER);
            } else {
                showStatus(STATUS_ERROR, "Anda belum memilih tanggal keberangkatan");
            }
        } else {
            redirectToLoginOrRegister();
        }
    }

    @OnClick(R.id.btSearchSchedule)
    public void btSearchSchedule() {
        if (!mPresenter.isDepartureSet()) {
            showStatus(STATUS_ERROR, "Anda belum memilih lokasi keberangkatan");
        } else if (!mPresenter.isDestinationSet()) {
            showStatus(STATUS_ERROR, "Anda belum memilih lokasi tujuan");
        } else if (!mPresenter.isDateSet()) {
            showStatus(STATUS_ERROR, "Anda belum memilih tanggal keberangkatan");
        } else if (!mPresenter.isPassengerSet()) {
            showStatus(STATUS_ERROR, "Anda belum menambahkan penumpang");
        } else if (!mPresenter.isLoggedIn()) {
            redirectToLoginOrRegister();
        } else {
            Intent intent = new Intent(activity, ScheduleActivity.class);
            startActivityForResult(intent, ConstantUtils.ACTIVITY_REQUEST_CODE_SCHEDULE);
        }
    }

    public interface FragmentListener {
        void redirectToLoginOrRegister();
    }
}
