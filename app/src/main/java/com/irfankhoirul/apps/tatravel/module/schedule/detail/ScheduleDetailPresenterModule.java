package com.irfankhoirul.apps.tatravel.module.schedule.detail;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class ScheduleDetailPresenterModule {

    private final ScheduleDetailDialogContract.View mView;

    public ScheduleDetailPresenterModule(ScheduleDetailDialogContract.View view) {
        mView = view;
    }

    @Provides
    ScheduleDetailDialogContract.View provideTravelChoiceDialogContractView() {
        return mView;
    }
}
