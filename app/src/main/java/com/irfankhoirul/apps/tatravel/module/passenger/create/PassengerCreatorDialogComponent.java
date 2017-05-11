package com.irfankhoirul.apps.tatravel.module.passenger.create;

import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;
import com.irfankhoirul.apps.tatravel.module.passenger.PassengerFragment;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(modules = PassengerCreatorPresenterModule.class)
public interface PassengerCreatorDialogComponent {

    void inject(PassengerFragment passengerFragment);

}