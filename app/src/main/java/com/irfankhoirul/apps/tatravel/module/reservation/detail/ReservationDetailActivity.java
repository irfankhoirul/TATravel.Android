package com.irfankhoirul.apps.tatravel.module.reservation.detail;

import com.irfankhoirul.apps.tatravel.core.app.TAApplication;
import com.irfankhoirul.apps.tatravel.core.base.BaseFragmentHolderActivity;
import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;

import org.parceler.Parcels;

import javax.inject.Inject;

public class ReservationDetailActivity extends BaseFragmentHolderActivity {

    @Inject
    ReservationDetailPresenter mPresenter;

    private ReservationDetailFragment reservationDetailFragment;

    @Override
    protected void initializeFragment() {
        reservationDetailFragment = ReservationDetailFragment.newInstance((Pemesanan) Parcels.unwrap(getIntent().getParcelableExtra("reservation")));
        setCurrentFragment(reservationDetailFragment, false);

        DaggerReservationDetailComponent.builder()
                .reservationDetailPresenterModule(new ReservationDetailPresenterModule(reservationDetailFragment))
                .appComponent(((TAApplication) getApplication()).getAppComponent())
                .build().inject(this);
    }

    @Override
    public void onBackPressed() {
        mPresenter.clearCart();
        super.onBackPressed();
    }
}
