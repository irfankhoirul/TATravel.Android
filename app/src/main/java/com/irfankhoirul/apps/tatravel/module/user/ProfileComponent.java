package com.irfankhoirul.apps.tatravel.module.user;

import com.irfankhoirul.apps.tatravel.core.activity.MainActivity;
import com.irfankhoirul.apps.tatravel.core.app.AppComponent;
import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(dependencies = AppComponent.class, modules = ProfilePresenterModule.class)
public interface ProfileComponent {

    void inject(MainActivity mainActivity);
}