package com.irfankhoirul.apps.tatravel.module.departure.travel_choice;

import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;
import com.irfankhoirul.apps.tatravel.module.departure.DepartureFragment;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(modules = TravelChoicePresenterModule.class)
public interface TravelChoiceComponent {

    void inject(DepartureFragment departureFragment);

}