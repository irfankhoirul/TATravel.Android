package com.irfankhoirul.apps.tatravel.module.register;

import com.irfankhoirul.apps.tatravel.AppComponent;
import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(dependencies = AppComponent.class, modules = RegisterPresenterModule.class)
public interface RegisterComponent {

    void inject(RegisterActivity registerActivity);
}