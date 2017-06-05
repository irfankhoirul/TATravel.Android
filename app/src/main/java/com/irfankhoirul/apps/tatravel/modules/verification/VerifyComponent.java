package com.irfankhoirul.apps.tatravel.modules.verification;

import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.modules.DaggerModuleScoped;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(dependencies = AppComponent.class, modules = VerifyPresenterModule.class)
public interface VerifyComponent {

    void inject(VerifyActivity verifyActivity);
}