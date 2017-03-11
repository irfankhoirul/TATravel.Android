package com.irfankhoirul.apps.tatravel.presenter;

import android.util.Log;

import com.irfankhoirul.apps.tatravel.contract.TravelLocationDialogContract;
import com.irfankhoirul.apps.tatravel.model.api.DataPage;
import com.irfankhoirul.apps.tatravel.model.data.remote.IRequestResponseWithPaginationListener;
import com.irfankhoirul.apps.tatravel.model.data.remote.SearchInteractor;
import com.irfankhoirul.apps.tatravel.model.pojo.Lokasi;

import java.util.List;

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
        Log.v("LoadingData", "START");
        view.setProgressBarVisibility(true);
        loadingData = true;
        SearchInteractor repository = new SearchInteractor();
        repository.getLocation(new IRequestResponseWithPaginationListener<List<Lokasi>>() {
            @Override
            public void onSuccess(DataPage dataPageManager, List<Lokasi> data) {
                Log.v("LoadingData", "DONE");
                view.setProgressBarVisibility(false);
                loadingData = false;
                if (data != null) {
                    view.updateTravelLocationList(dataPageManager, data);
                }
            }

            @Override
            public void onFailure() {
                Log.v("LoadingData", "FAILED");
                view.setProgressBarVisibility(false);
                loadingData = false;
            }
        }, page, idKota);
    }

}
