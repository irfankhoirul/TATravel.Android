package com.irfankhoirul.apps.tatravel.module.register;

import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.module.DaggerModuleScoped;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(dependencies = AppComponent.class, modules = RegisterPresenterModule.class)
public interface RegisterComponent {

    void inject(RegisterActivity registerActivity);
}