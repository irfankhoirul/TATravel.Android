package com.irfankhoirul.apps.tatravel.presenter;

import android.util.Log;

import com.irfankhoirul.apps.tatravel.contract.CityDialogContract;
import com.irfankhoirul.apps.tatravel.model.api.DataPage;
import com.irfankhoirul.apps.tatravel.model.data.remote.IRequestResponseWithPaginationListener;
import com.irfankhoirul.apps.tatravel.model.data.remote.SearchInteractor;
import com.irfankhoirul.apps.tatravel.model.pojo.Kota;

import java.util.List;

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
        Log.v("LoadingData", "START");
        view.setProgressBarVisibility(true);
        loadingData = true;
        SearchInteractor repository = new SearchInteractor();
        repository.getCity(new IRequestResponseWithPaginationListener<List<Kota>>() {
            @Override
            public void onSuccess(DataPage dataPageManager, List<Kota> data) {
                Log.v("LoadingData", "DONE");
                view.setProgressBarVisibility(false);
                loadingData = false;
                if (data != null) {
                    view.updateCityList(dataPageManager, data);
                }
            }

            @Override
            public void onFailure() {
                Log.v("LoadingData", "FAILED");
                view.setProgressBarVisibility(false);
                loadingData = false;
            }
        }, page);
    }
}
