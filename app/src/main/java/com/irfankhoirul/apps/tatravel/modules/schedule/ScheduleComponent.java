package com.irfankhoirul.apps.tatravel.modules.schedule;

import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.modules.DaggerModuleScoped;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(dependencies = AppComponent.class, modules = SchedulePresenterModule.class)
public interface ScheduleComponent {

    void inject(ScheduleActivity scheduleActivity);

}