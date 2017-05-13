package com.irfankhoirul.apps.tatravel.module.seat;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class SeatPresenterModule {

    private final SeatContract.View mView;

    public SeatPresenterModule(SeatContract.View view) {
        mView = view;
    }

    @Provides
    SeatContract.View provideSeatContractView() {
        return mView;
    }
}
