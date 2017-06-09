package com.irfankhoirul.apps.tatravel.modules.schedule_detail;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class ScheduleDetailPresenterModule {

    private final ScheduleDetailContract.View mView;

    public ScheduleDetailPresenterModule(ScheduleDetailContract.View view) {
        mView = view;
    }

    @Provides
    ScheduleDetailContract.View provideTravelChoiceDialogContractView() {
        return mView;
    }
}
