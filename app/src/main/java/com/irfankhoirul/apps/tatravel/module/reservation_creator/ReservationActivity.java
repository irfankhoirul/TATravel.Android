package com.irfankhoirul.apps.tatravel.module.reservation_creator;

import com.irfankhoirul.apps.tatravel.app.TAApplication;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragmentHolderActivity;

import javax.inject.Inject;

public class ReservationActivity extends BaseFragmentHolderActivity {

    @Inject
    ReservationPresenter mPresenter;

    private ReservationFragment reservationFragment;

    @Override
    protected void initializeFragment() {
        reservationFragment = new ReservationFragment();
        setCurrentFragment(reservationFragment, false);

        DaggerReservationComponent.builder()
                .reservationPresenterModule(new ReservationPresenterModule(reservationFragment))
                .appComponent(((TAApplication) getApplication()).getAppComponent())
                .build().inject(this);
    }

}
