package com.irfankhoirul.apps.tatravel.data.api.source.user;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/16/2017.
 */

@Module
public class UserDataSourceModule {

    @Singleton
    @Provides
    UserDataSource provideUserDataSource() {
        return new UserDataSource();
    }
}
