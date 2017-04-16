package com.irfankhoirul.apps.tatravel.module.user;

import com.irfankhoirul.apps.tatravel.MainActivity;
import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;
import com.irfankhoirul.apps.tatravel.data.source.user.UserDataSourceComponent;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(dependencies = UserDataSourceComponent.class, modules = ProfilePresenterModule.class)
public interface ProfileComponent {

    void inject(MainActivity mainActivity);
}