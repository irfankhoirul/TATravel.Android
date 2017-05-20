package com.irfankhoirul.apps.tatravel.module.schedule;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.irfankhoirul.apps.tatravel.R;
import com.irfankhoirul.apps.tatravel.core.app.TAApplication;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragment;
import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.components.util.DisplayMetricUtils;
import com.irfankhoirul.apps.tatravel.core.data.DataPage;
import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.module.schedule.detail.DaggerScheduleDetailComponent;
import com.irfankhoirul.apps.tatravel.module.schedule.detail.ScheduleDetailDialog;
import com.irfankhoirul.apps.tatravel.module.schedule.detail.ScheduleDetailDialogPresenter;
import com.irfankhoirul.apps.tatravel.module.schedule.detail.ScheduleDetailPresenterModule;
import com.irfankhoirul.apps.tatravel.module.seat.SeatActivity;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */

public class ScheduleFragment extends BaseFragment<ScheduleActivity, ScheduleContract.Presenter>
        implements ScheduleContract.View, ScheduleDetailDialog.DialogListener {

    @BindView(R.id.rlContainer)
    RelativeLayout rlContainer;
    @BindView(R.id.rvSchedule)
    RecyclerView rvSchedule;
    @BindView(R.id.llEmptyMessage)
    LinearLayout llEmptyMessage;

    @Inject
    ScheduleDetailDialogPresenter scheduleDetailDialogPresenter;

    private ScheduleAdapter scheduleAdapter;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    protected void setTitle() {
        title = "Pilih Jadwal Perjalanan";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_schedule, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);

        scheduleAdapter = new ScheduleAdapter(mPresenter.getSchedules(), new ScheduleAdapter.OnSpecificItemClick() {
            @Override
            public void onItemClick(JadwalPerjalanan schedule) {
                if (schedule.getQuota() > 0) {
                    // Show dialog detail & konfirmasi
                    ScheduleDetailDialog scheduleDetailDialog = ScheduleDetailDialog.newInstance(schedule);
                    scheduleDetailDialog.setListener(ScheduleFragment.this);
                    scheduleDetailDialog.show(getFragmentManager(), "passengerCreatorDialog");

                    DaggerScheduleDetailComponent.builder()
                            .appComponent(((TAApplication) activity.getApplication()).getAppComponent())
                            .scheduleDetailPresenterModule(new ScheduleDetailPresenterModule(scheduleDetailDialog))
                            .build().inject(ScheduleFragment.this);
                } else {
                    showStatus(ConstantUtils.STATUS_ERROR, "Tidak ada kursi tersisa!");
                }
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
        rvSchedule.setLayoutManager(layoutManager);
        rvSchedule.setItemAnimator(new DefaultItemAnimator());
        rvSchedule.setAdapter(scheduleAdapter);

        return fragmentView;
    }

    @Override
    public void onResume() {
        mPresenter.getSchedules().clear();
        super.onResume();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter.handleOnActivityResult(requestCode, resultCode);
    }

    @Override
    public void setPresenter(ScheduleContract.Presenter presenter) {
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
    public void updateScheduleList(List<JadwalPerjalanan> schedules, final DataPage dataPage, final Map<String, String> params) {
        mPresenter.getSchedules().addAll(schedules);
        scheduleAdapter.notifyDataSetChanged();

        int rvScheduleMaxHeight = rlContainer.getHeight();
        int rvPassengerHeight = rvSchedule.getHeight();
        if (rvPassengerHeight < rvScheduleMaxHeight && dataPage.getCurrentPage() < dataPage.getTotalPage()
                && schedules.size() < ConstantUtils.PAGINATION_LIMIT * 2 && dataPage.getNextPage() != -1) {
            mPresenter.searchSchedules(params);
        }

        rvSchedule.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (DisplayMetricUtils.isMaxScrollReached(rvSchedule) && dataPage.getNextPage() != -1) {
                    if (dataPage.getCurrentPage() < dataPage.getTotalPage() && !isLoading()) {
                        Log.v("RequestPage", String.valueOf(dataPage.getNextPage()));
                        Log.v("CurrentPage", String.valueOf(dataPage.getCurrentPage()));
                        mPresenter.searchSchedules(params);
                    }
                }
            }
        });
    }

    @Override
    public void showDataNotExist() {
        rvSchedule.setVisibility(View.GONE);
        llEmptyMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void showDataExist() {
        llEmptyMessage.setVisibility(View.GONE);
        rvSchedule.setVisibility(View.VISIBLE);
    }

    @Override
    public void finishActivity(int resultCode) {
        activity.setResult(resultCode);
        activity.finish();
    }

    @Override
    public void onNext(JadwalPerjalanan schedule) {
        // Intent ke activity seat
        Intent intent = new Intent(activity, SeatActivity.class);
        intent.putExtra("scheduleId", schedule.getId());
        startActivityForResult(intent, ConstantUtils.ACTIVITY_REQUEST_CODE_SEAT);
    }
}
