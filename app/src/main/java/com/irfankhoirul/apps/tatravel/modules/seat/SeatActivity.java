package com.irfankhoirul.apps.tatravel.modules.seat;

import com.irfankhoirul.apps.tatravel.app.TAApplication;
import com.irfankhoirul.mvp_core.base.BaseFragmentHolderActivity;

import javax.inject.Inject;

public class SeatActivity extends BaseFragmentHolderActivity {

    @Inject
    SeatPresenter mPresenter;

    @Override
    protected void initializeFragment() {
        SeatFragment seatFragment = SeatFragment.newInstance(getIntent().getIntExtra("scheduleId", -1));
        setCurrentFragment(seatFragment, false);

        DaggerSeatComponent.builder()
                .seatPresenterModule(new SeatPresenterModule(seatFragment))
                .appComponent(((TAApplication) getApplication()).getAppComponent())
                .build().inject(this);
    }

}
