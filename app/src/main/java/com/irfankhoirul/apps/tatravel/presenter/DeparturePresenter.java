package com.irfankhoirul.apps.tatravel.presenter;

import com.irfankhoirul.apps.tatravel.contract.DepartureContract;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class DeparturePresenter implements DepartureContract.Presenter {

    private final DepartureContract.View view;

    public DeparturePresenter(DepartureContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void getDepartureLocationList() {

    }

    @Override
    public void setupMap() {

    }
}