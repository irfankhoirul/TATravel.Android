package com.irfankhoirul.apps.tatravel.data.api.source.user;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/16/2017.
 */

@Singleton
@Component(modules = {UserDataSourceModule.class})
public interface UserDataSourceComponent {

    UserDataSource getUserDataSource();
}