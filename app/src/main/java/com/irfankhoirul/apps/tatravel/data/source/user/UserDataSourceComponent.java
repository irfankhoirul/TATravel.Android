package com.irfankhoirul.apps.tatravel.data.source.user;

import com.irfankhoirul.apps.tatravel.TAApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/16/2017.
 */

@Singleton
@Component(modules = {UserDataSourceModule.class, TAApplicationModule.class})
public interface UserDataSourceComponent {

    UserDataSource getUserRepository();
}