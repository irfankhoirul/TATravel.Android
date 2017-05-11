package com.irfankhoirul.apps.tatravel.module.departure;

import com.irfankhoirul.apps.tatravel.core.app.AppComponent;
import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(dependencies = AppComponent.class, modules = DeparturePresenterModule.class)
public interface DepartureComponent {

    void inject(DepartureActivity departureActivity);
}