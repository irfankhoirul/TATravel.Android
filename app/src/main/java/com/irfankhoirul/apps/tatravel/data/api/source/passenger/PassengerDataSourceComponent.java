package com.irfankhoirul.apps.tatravel.data.api.source.passenger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/16/2017.
 */

@Singleton
@Component(modules = {PassengerDataSourceModule.class})
public interface PassengerDataSourceComponent {

    PassengerDataSource getPassengerDataSource();
}