package com.irfankhoirul.apps.tatravel.module.departure_old;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class TravelLocationDialogPresenter implements TravelLocationDialogContract.Presenter {

    private final TravelLocationDialogContract.View view;
    private boolean loadingData = false;

    public TravelLocationDialogPresenter(TravelLocationDialogContract.View view) {
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
    public void getTravelLocationData(int page, int idKota) {

    }

}
