package com.irfankhoirul.apps.tatravel.module.reservation_detail;

import com.irfankhoirul.apps.tatravel.core.app.AppComponent;
import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(dependencies = AppComponent.class, modules = ReservationDetailPresenterModule.class)
public interface ReservationDetailComponent {

    void inject(ReservationDetailActivity reservationDetailActivity);

    SessionRepository session();

}