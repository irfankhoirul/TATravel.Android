package com.irfankhoirul.apps.tatravel.module.schedule.detail;

import com.irfankhoirul.apps.tatravel.core.app.AppComponent;
import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;
import com.irfankhoirul.apps.tatravel.data.source.locale.cart.CartRepository;
import com.irfankhoirul.apps.tatravel.module.schedule.ScheduleFragment;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(dependencies = AppComponent.class, modules = ScheduleDetailPresenterModule.class)
public interface ScheduleDetailComponent {

    void inject(ScheduleFragment scheduleFragment);

    CartRepository cart();

}