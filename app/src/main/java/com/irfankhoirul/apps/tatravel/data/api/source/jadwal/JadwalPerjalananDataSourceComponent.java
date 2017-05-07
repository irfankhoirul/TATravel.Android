package com.irfankhoirul.apps.tatravel.data.api.source.jadwal;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/16/2017.
 */

@Singleton
@Component(modules = {JadwalPerjalananDataSourceModule.class})
public interface JadwalPerjalananDataSourceComponent {

    JadwalPerjalananDataSource getJadwalPerjalananDataSource();
}