package com.irfankhoirul.apps.tatravel.module.passenger;

import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;
import com.irfankhoirul.apps.tatravel.data.source.remote.source.passenger.PassengerDataSourceComponent;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(dependencies = PassengerDataSourceComponent.class, modules = PassengerPresenterModule.class)
public interface PassengerComponent {

    void inject(PassengerActivity passengerActivity);
}