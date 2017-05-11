package com.irfankhoirul.apps.tatravel.module.destination;

import com.irfankhoirul.apps.tatravel.core.app.AppComponent;
import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(dependencies = AppComponent.class, modules = DestinationPresenterModule.class)
public interface DestinationComponent {

    void inject(DestinationActivity destinationActivity);
}