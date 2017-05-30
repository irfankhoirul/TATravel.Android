package com.irfankhoirul.apps.tatravel.module.reservation_detail;

import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.module.DaggerModuleScoped;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(dependencies = AppComponent.class, modules = ReservationDetailPresenterModule.class)
public interface ReservationDetailComponent {

    void inject(ReservationDetailActivity reservationDetailActivity);

}