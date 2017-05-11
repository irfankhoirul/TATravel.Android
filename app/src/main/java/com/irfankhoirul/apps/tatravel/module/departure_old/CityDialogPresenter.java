package com.irfankhoirul.apps.tatravel.module.departure_old;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class CityDialogPresenter implements CityDialogContract.Presenter {

    private final CityDialogContract.View view;
    private boolean loadingData = false;

    public CityDialogPresenter(CityDialogContract.View view) {
        this.view = view;
    }

    public boolean isLoadingData() {
        return loadingData;
    }

    public void setLoadingData(boolean loadingData) {
        this.loadingData = loadingData;
    }

    @Override
    public void start() {

    }

    @Override
    public void getCityData(int page) {

    }
}
