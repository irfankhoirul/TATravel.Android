package com.irfankhoirul.apps.tatravel.module.schedule_detail;

import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.module.DaggerModuleScoped;
import com.irfankhoirul.apps.tatravel.module.schedule.ScheduleFragment;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(dependencies = AppComponent.class, modules = ScheduleDetailPresenterModule.class)
public interface ScheduleDetailComponent {

    void inject(ScheduleFragment scheduleFragment);

}