package com.irfankhoirul.apps.tatravel.module.search;

import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;
import com.irfankhoirul.apps.tatravel.data.api.source.user.UserDataSourceComponent;
import com.irfankhoirul.apps.tatravel.module.login.LoginActivity;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(dependencies = UserDataSourceComponent.class, modules = SearchPresenterModule.class)
public interface SearchComponent {

    void inject(LoginActivity loginActivity);
}