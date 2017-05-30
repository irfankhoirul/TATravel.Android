package com.irfankhoirul.apps.tatravel.module.destination;

import com.irfankhoirul.apps.tatravel.app.TAApplication;
import com.irfankhoirul.mvp_core.base.BaseFragmentHolderActivity;

import javax.inject.Inject;

public class DestinationActivity extends BaseFragmentHolderActivity {

    @Inject
    DestinationPresenter mPresenter;

    @Override
    protected void initializeFragment() {
        DestinationFragment destinationFragment = DestinationFragment.newInstance(
                Integer.parseInt(getIntent().getStringExtra("id_operator_travel")));
        setCurrentFragment(destinationFragment, true);

        DaggerDestinationComponent.builder()
                .destinationPresenterModule(new DestinationPresenterModule(destinationFragment))
                .appComponent(((TAApplication) getApplication()).getAppComponent())
                .build().inject(this);
    }

}
