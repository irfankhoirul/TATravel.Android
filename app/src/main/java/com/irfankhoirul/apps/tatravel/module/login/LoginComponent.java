package com.irfankhoirul.apps.tatravel.module.login;

import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.module.DaggerModuleScoped;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(dependencies = AppComponent.class, modules = LoginPresenterModule.class)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}