package com.irfankhoirul.apps.tatravel.module.schedule;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */

@Module
public class SchedulePresenterModule {

    private final ScheduleContract.View mView;

    public SchedulePresenterModule(ScheduleContract.View view) {
        mView = view;
    }

    @Provides
    ScheduleContract.View provideScheduleContractView() {
        return mView;
    }
}
