package com.irfankhoirul.apps.tatravel.modules.reservation;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class ReservationPresenterModule {

    private final ReservationContract.View mView;

    public ReservationPresenterModule(ReservationContract.View view) {
        mView = view;
    }

    @Provides
    ReservationContract.View provideReservationContractView() {
        return mView;
    }
}
