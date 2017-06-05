package com.irfankhoirul.apps.tatravel.modules.travel_choice;

import com.irfankhoirul.apps.tatravel.modules.DaggerModuleScoped;
import com.irfankhoirul.apps.tatravel.modules.departure.DepartureFragment;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(modules = TravelChoicePresenterModule.class)
public interface TravelChoiceComponent {

    void inject(DepartureFragment departureFragment);

}