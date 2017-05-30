package com.irfankhoirul.apps.tatravel.module.schedule;

import com.irfankhoirul.apps.tatravel.app.TAApplication;
import com.irfankhoirul.mvp_core.base.BaseFragmentHolderActivity;

import javax.inject.Inject;

public class ScheduleActivity extends BaseFragmentHolderActivity {

    @Inject
    SchedulePresenter mPresenter;

    @Override
    protected void initializeFragment() {
        ScheduleFragment scheduleFragment = new ScheduleFragment();
        setCurrentFragment(scheduleFragment, false);

        DaggerScheduleComponent.builder()
                .schedulePresenterModule(new SchedulePresenterModule(scheduleFragment))
                .appComponent(((TAApplication) getApplication()).getAppComponent())
                .build().inject(this);

    }

}
