package com.irfankhoirul.apps.tatravel.module.departure;

import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;
import com.irfankhoirul.apps.tatravel.data.api.source.jadwal_perjalanan.JadwalPerjalananDataSourceComponent;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(dependencies = JadwalPerjalananDataSourceComponent.class, modules = DeparturePresenterModule.class)
public interface DepartureComponent {

    void inject(DepartureActivity departureActivity);
}