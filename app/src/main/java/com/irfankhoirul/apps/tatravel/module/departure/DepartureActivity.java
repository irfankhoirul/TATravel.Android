package com.irfankhoirul.apps.tatravel.module.departure;

import com.irfankhoirul.apps.tatravel.app.TAApplication;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragmentHolderActivity;

import javax.inject.Inject;

public class DepartureActivity extends BaseFragmentHolderActivity {

    @Inject
    DeparturePresenter mPresenter;

    @Override
    protected void initializeFragment() {
        DepartureFragment departureFragment = new DepartureFragment();
        setCurrentFragment(departureFragment, true);

        DaggerDepartureComponent.builder()
                .departurePresenterModule(new DeparturePresenterModule(departureFragment))
                .appComponent(((TAApplication) getApplication()).getAppComponent())
                .build().inject(this);
    }

}
