package com.irfankhoirul.apps.tatravel.modules.departure;

import com.irfankhoirul.apps.tatravel.app.TAApplication;
import com.irfankhoirul.mvp_core.base.BaseFragmentHolderActivity;

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
