package com.irfankhoirul.apps.tatravel.modules.passenger_creator;

import com.irfankhoirul.apps.tatravel.modules.DaggerModuleScoped;
import com.irfankhoirul.apps.tatravel.modules.passenger.PassengerFragment;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(modules = PassengerCreatorPresenterModule.class)
public interface PassengerCreatorDialogComponent {

    void inject(PassengerFragment passengerFragment);

}