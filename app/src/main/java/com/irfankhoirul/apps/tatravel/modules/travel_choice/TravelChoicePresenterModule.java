package com.irfankhoirul.apps.tatravel.modules.travel_choice;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class TravelChoicePresenterModule {

    private final TravelChoiceContract.View mView;

    public TravelChoicePresenterModule(TravelChoiceContract.View view) {
        mView = view;
    }

    @Provides
    TravelChoiceContract.View provideTravelChoiceDialogContractView() {
        return mView;
    }
}
