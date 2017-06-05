package com.irfankhoirul.apps.tatravel.modules.reservation_detail;

import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.modules.DaggerModuleScoped;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(dependencies = AppComponent.class, modules = ReservationDetailPresenterModule.class)
public interface ReservationDetailComponent {

    void inject(ReservationDetailActivity reservationDetailActivity);

}