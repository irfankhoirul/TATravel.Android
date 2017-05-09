package com.irfankhoirul.apps.tatravel.data.source.remote.source.jadwal;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 4/16/2017.
 */

@Module
public class JadwalPerjalananDataSourceModule {

    @Singleton
    @Provides
    JadwalPerjalananDataSource provideJadwalPerjalananDataSource() {
        return new JadwalPerjalananDataSource();
    }
}
