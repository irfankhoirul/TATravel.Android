package com.irfankhoirul.apps.tatravel.module.verification;

import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.module.DaggerModuleScoped;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(dependencies = AppComponent.class, modules = VerifyPresenterModule.class)
public interface VerifyComponent {

    void inject(VerifyActivity verifyActivity);
}