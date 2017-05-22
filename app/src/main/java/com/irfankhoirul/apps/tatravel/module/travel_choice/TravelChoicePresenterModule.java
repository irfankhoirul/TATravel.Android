package com.irfankhoirul.apps.tatravel.module.travel_choice;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class TravelChoicePresenterModule {

    private final TravelChoiceDialogContract.View mView;

    public TravelChoicePresenterModule(TravelChoiceDialogContract.View view) {
        mView = view;
    }

    @Provides
    TravelChoiceDialogContract.View provideTravelChoiceDialogContractView() {
        return mView;
    }
}
