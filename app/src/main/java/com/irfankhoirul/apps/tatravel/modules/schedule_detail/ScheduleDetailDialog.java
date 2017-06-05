package com.irfankhoirul.apps.tatravel.modules.schedule_detail;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.components.CurrencyUtils;
import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.modules.schedule.ScheduleActivity;
import com.irfankhoirul.mvp_core.base.BaseDialog;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class ScheduleDetailDialog extends BaseDialog<ScheduleActivity, ScheduleDetailDialogContract.Presenter>
        implements ScheduleDetailDialogContract.View {

    @BindView(R.id.tvDepartureLocation)
    TextView tvDepartureLocation;
    @BindView(R.id.tvDepartureTime)
    TextView tvDepartureTime;
    @BindView(R.id.tvDestinationLocation)
    TextView tvDestinationLocation;
    @BindView(R.id.tvDestinationTime)
    TextView tvDestinationTime;
    @BindView(R.id.tvTravelPrice)
    TextView tvTravelPrice;
    @BindView(R.id.tvPickUpPrice)
    TextView tvPickUpPrice;
    @BindView(R.id.tvTakePrice)
    TextView tvTakePrice;
    @BindView(R.id.tvTotalPrice)
    TextView tvTotalPrice;
    @BindView(R.id.btCancel)
    Button btCancel;
    @BindView(R.id.btNext)
    Button btNext;

    private DialogListener listener;

    public ScheduleDetailDialog() {
        // Empty constructor required for DialogFragment
    }

    public static ScheduleDetailDialog newInstance(JadwalPerjalanan schedule) {
        ScheduleDetailDialog scheduleDetailDialog = new ScheduleDetailDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelable("schedule", Parcels.wrap(schedule));
        scheduleDetailDialog.setArguments(bundle);

        return scheduleDetailDialog;
    }

    public void setListener(DialogListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.dialog_schedule_detail, container);
        unbinder = ButterKnife.bind(this, fragmentView);

        mPresenter.setSchedule((JadwalPerjalanan) Parcels.unwrap(getArguments().getParcelable("schedule")));
        showScheduleDetail(mPresenter.getSchedule());

        return fragmentView;
    }

    private void showScheduleDetail(JadwalPerjalanan schedule) {
        tvDepartureLocation.setText(schedule.getLokasiPemberangkatan().getNama() + ", " + schedule.getLokasiPemberangkatan().getKota().getNama());
        tvDepartureTime.setText(schedule.getWaktuKeberangkatan() + " " + schedule.getTimezone());
        tvDestinationLocation.setText(schedule.getLokasiTujuan().getNama() + ", " + schedule.getLokasiTujuan().getKota().getNama());
        tvDestinationTime.setText(schedule.getWaktuKedatangan() + " " + schedule.getTimezone());

        tvTravelPrice.setText(CurrencyUtils.formatRupiah(schedule.getHarga()));

        int pickUpDistance = (int) Math.ceil(schedule.getJarakPenjemputan());
        int pickUpPrice = schedule.getBiayaLokasiKhusus() * pickUpDistance;
        tvPickUpPrice.setText(CurrencyUtils.formatRupiah(pickUpPrice) + " (" + pickUpDistance + " x " +
                CurrencyUtils.formatRupiah(schedule.getBiayaLokasiKhusus()) + ")");

        int takeDistance = (int) Math.ceil(schedule.getJarakPengantaran());
        int takePrice = schedule.getBiayaLokasiKhusus() * takeDistance;
        tvTakePrice.setText(CurrencyUtils.formatRupiah(takePrice) + " (" + takeDistance + " x " +
                CurrencyUtils.formatRupiah(schedule.getBiayaLokasiKhusus()) + ")");

        tvTotalPrice.setText(CurrencyUtils.formatRupiah(schedule.getHarga() + pickUpPrice + takePrice));
    }

    @OnClick(R.id.btCancel)
    public void btCancel() {
        ScheduleDetailDialog.this.dismiss();
    }

    @OnClick(R.id.btNext)
    public void btNext() {
        listener.onNext(mPresenter.getSchedule());
        ScheduleDetailDialog.this.dismiss();
    }

    @Override
    public void onResume() {
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = LinearLayout.LayoutParams.MATCH_PARENT;
        params.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);

        super.onResume();

        mPresenter.start();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    @Override
    public void setPresenter(ScheduleDetailDialogContract.Presenter presenter) {
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

    public interface DialogListener {
        void onNext(JadwalPerjalanan schedule);
    }
}
