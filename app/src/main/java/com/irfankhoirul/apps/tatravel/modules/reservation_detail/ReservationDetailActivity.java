package com.irfankhoirul.apps.tatravel.modules.reservation_detail;

import com.irfankhoirul.apps.tatravel.app.TAApplication;
import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;
import com.irfankhoirul.mvp_core.base.BaseFragmentHolderActivity;

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
        super.onBackPressed();
        if (Parcels.unwrap(getIntent().getParcelableExtra("reservation")) != null) {
            mPresenter.clearCart();
        }
    }
}
