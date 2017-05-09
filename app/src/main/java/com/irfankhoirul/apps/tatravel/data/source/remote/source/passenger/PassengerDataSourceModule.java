package com.irfankhoirul.apps.tatravel.data.source.remote.source.passenger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/16/2017.
 */

@Module
public class PassengerDataSourceModule {

    @Singleton
    @Provides
    PassengerDataSource providePassengerDataSource() {
        return new PassengerDataSource();
    }
}
