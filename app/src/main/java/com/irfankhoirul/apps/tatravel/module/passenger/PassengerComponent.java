package com.irfankhoirul.apps.tatravel.module.passenger;

import com.irfankhoirul.apps.tatravel.core.app.AppComponent;
import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(dependencies = AppComponent.class, modules = PassengerPresenterModule.class)
public interface PassengerComponent {

    void inject(PassengerActivity passengerActivity);

    SessionRepository session();
}