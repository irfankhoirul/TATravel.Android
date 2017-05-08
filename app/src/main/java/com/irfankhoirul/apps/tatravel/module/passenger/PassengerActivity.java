package com.irfankhoirul.apps.tatravel.module.passenger;

import com.irfankhoirul.apps.tatravel.core.base.BaseFragmentHolderActivity;
import com.irfankhoirul.apps.tatravel.data.api.source.passenger.DaggerPassengerDataSourceComponent;

import javax.inject.Inject;

public class PassengerActivity extends BaseFragmentHolderActivity {

    @Inject
    PassengerPresenter mPresenter;

    @Override
    protected void initializeFragment() {
        PassengerFragment passengerFragment = new PassengerFragment();
        setCurrentFragment(passengerFragment, false);

        DaggerPassengerComponent.builder()
                .passengerPresenterModule(new PassengerPresenterModule(passengerFragment))
                .passengerDataSourceComponent(DaggerPassengerDataSourceComponent.builder().build())
                .build().inject(this);
    }

}
