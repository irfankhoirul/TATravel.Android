package com.irfankhoirul.apps.tatravel.module.departure;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class DeparturePresenterModule {

    private final DepartureContract.View mView;

    public DeparturePresenterModule(DepartureContract.View view) {
        mView = view;
    }

    @Provides
    DepartureContract.View provideDepartureContractView() {
        return mView;
    }
}
