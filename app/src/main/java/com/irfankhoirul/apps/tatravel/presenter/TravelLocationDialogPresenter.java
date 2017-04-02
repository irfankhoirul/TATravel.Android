package com.irfankhoirul.apps.tatravel.presenter;

import com.irfankhoirul.apps.tatravel.contract.TravelLocationDialogContract;
import com.irfankhoirul.apps.tatravel.model.api.DataResult;
import com.irfankhoirul.apps.tatravel.model.data.remote.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.model.data.remote.SearchDataSource;
import com.irfankhoirul.apps.tatravel.model.pojo.Lokasi;

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
        view.setProgressBarVisibility(true);
        loadingData = true;
        SearchDataSource repository = new SearchDataSource();
        repository.getLocation(new IRequestResponseListener<Lokasi>() {
            @Override
            public void onSuccess(DataResult<Lokasi> data) {
                view.setProgressBarVisibility(false);
                loadingData = false;
                if (data != null) {
                    view.updateTravelLocationList(data.getDataPageManager(), data.getDatas());
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.setProgressBarVisibility(false);
                loadingData = false;
            }
        }, page, idKota);
    }

}
