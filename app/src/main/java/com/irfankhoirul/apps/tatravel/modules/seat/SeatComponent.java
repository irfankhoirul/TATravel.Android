package com.irfankhoirul.apps.tatravel.modules.seat;

import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.modules.DaggerModuleScoped;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(dependencies = AppComponent.class, modules = SeatPresenterModule.class)
public interface SeatComponent {

    void inject(SeatActivity seatActivity);

}