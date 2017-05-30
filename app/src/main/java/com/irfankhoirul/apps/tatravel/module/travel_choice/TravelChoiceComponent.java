package com.irfankhoirul.apps.tatravel.module.travel_choice;

import com.irfankhoirul.apps.tatravel.module.DaggerModuleScoped;
import com.irfankhoirul.apps.tatravel.module.departure.DepartureFragment;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(modules = TravelChoicePresenterModule.class)
public interface TravelChoiceComponent {

    void inject(DepartureFragment departureFragment);

}