package com.irfankhoirul.apps.tatravel.presenter;

import com.irfankhoirul.apps.tatravel.contract.DepartureFragmentContract;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class DepartureFragmentPresenter implements DepartureFragmentContract.Presenter {

    private final DepartureFragmentContract.View view;

    public DepartureFragmentPresenter(DepartureFragmentContract.View view) {
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
