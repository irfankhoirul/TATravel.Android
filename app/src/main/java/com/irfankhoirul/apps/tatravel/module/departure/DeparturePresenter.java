package com.irfankhoirul.apps.tatravel.module.departure;

import com.irfankhoirul.apps.tatravel.data.api.source.jadwal_perjalanan.JadwalPerjalananDataSource;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class DeparturePresenter implements DepartureContract.Presenter {

    private final DepartureContract.View view;
    private final JadwalPerjalananDataSource jadwalPerjalananDataSource;

    @Inject
    public DeparturePresenter(JadwalPerjalananDataSource jadwalPerjalananDataSource, DepartureContract.View view) {
        this.view = view;
        this.jadwalPerjalananDataSource = jadwalPerjalananDataSource;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void checkLocationAvailability() {

    }
}
