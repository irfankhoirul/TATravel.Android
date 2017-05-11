package com.irfankhoirul.apps.tatravel.module.passenger.creator;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class PassengerCreatorPresenterModule {

    private final PassengerCreatorDialogContract.View mView;

    public PassengerCreatorPresenterModule(PassengerCreatorDialogContract.View view) {
        mView = view;
    }

    @Provides
    PassengerCreatorDialogContract.View provideTravelChoiceDialogContractView() {
        return mView;
    }
}
