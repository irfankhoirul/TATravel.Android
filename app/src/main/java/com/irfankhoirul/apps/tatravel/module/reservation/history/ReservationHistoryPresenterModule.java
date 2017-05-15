package com.irfankhoirul.apps.tatravel.module.reservation.history;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class ReservationHistoryPresenterModule {

    private final ReservationHistoryContract.View mView;

    public ReservationHistoryPresenterModule(ReservationHistoryContract.View view) {
        mView = view;
    }

    @Provides
    ReservationHistoryContract.View provideReservationHistoryContractView() {
        return mView;
    }
}