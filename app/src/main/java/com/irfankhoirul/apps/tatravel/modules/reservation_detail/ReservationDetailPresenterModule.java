package com.irfankhoirul.apps.tatravel.modules.reservation_detail;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class ReservationDetailPresenterModule {

    private final ReservationDetailContract.View mView;

    public ReservationDetailPresenterModule(ReservationDetailContract.View view) {
        mView = view;
    }

    @Provides
    ReservationDetailContract.View provideReservationDetailContractView() {
        return mView;
    }
}
