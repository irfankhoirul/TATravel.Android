package com.irfankhoirul.apps.tatravel.module.reservation_creator;

import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.module.DaggerModuleScoped;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(dependencies = AppComponent.class, modules = ReservationPresenterModule.class)
public interface ReservationComponent {

    void inject(ReservationActivity reservationActivity);

}