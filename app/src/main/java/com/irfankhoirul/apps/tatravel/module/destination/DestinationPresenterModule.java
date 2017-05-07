package com.irfankhoirul.apps.tatravel.module.destination;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class DestinationPresenterModule {

    private final DestinationContract.View mView;

    public DestinationPresenterModule(DestinationContract.View view) {
        mView = view;
    }

    @Provides
    DestinationContract.View provideLoginContractView() {
        return mView;
    }
}
