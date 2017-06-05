package com.irfankhoirul.apps.tatravel.modules.departure;

import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.modules.DaggerModuleScoped;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(dependencies = AppComponent.class, modules = DeparturePresenterModule.class)
public interface DepartureComponent {

    void inject(DepartureActivity departureActivity);
}