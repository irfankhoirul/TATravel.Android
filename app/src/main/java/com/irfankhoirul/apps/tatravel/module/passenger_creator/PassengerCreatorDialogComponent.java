package com.irfankhoirul.apps.tatravel.module.passenger_creator;

import com.irfankhoirul.apps.tatravel.module.DaggerModuleScoped;
import com.irfankhoirul.apps.tatravel.module.passenger.PassengerFragment;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(modules = PassengerCreatorPresenterModule.class)
public interface PassengerCreatorDialogComponent {

    void inject(PassengerFragment passengerFragment);

}