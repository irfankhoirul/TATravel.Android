package com.irfankhoirul.apps.tatravel.modules.passenger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class PassengerPresenterModule {

    private final PassengerContract.View mView;

    public PassengerPresenterModule(PassengerContract.View view) {
        mView = view;
    }

    @Provides
    PassengerContract.View providePassengerContractView() {
        return mView;
    }
}
