package com.irfankhoirul.apps.tatravel.presenter;

import com.irfankhoirul.apps.tatravel.aaa.core.components.DataResult;
import com.irfankhoirul.apps.tatravel.contract.CityDialogContract;
import com.irfankhoirul.apps.tatravel.model.data.remote.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.model.data.remote.SearchDataSource;
import com.irfankhoirul.apps.tatravel.model.pojo.Kota;

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
        view.setProgressBarVisibility(true);
        loadingData = true;
        SearchDataSource repository = new SearchDataSource();
        repository.getCity(new IRequestResponseListener<Kota>() {
            @Override
            public void onSuccess(DataResult<Kota> data) {
                view.setProgressBarVisibility(false);
                loadingData = false;
                if (data != null) {
                    view.updateCityList(data.getDataPageManager(), data.getDatas());
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.setProgressBarVisibility(false);
                loadingData = false;
            }
        }, page);
    }
}
