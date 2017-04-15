package com.irfankhoirul.apps.tatravel.module.departure;

import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.Kota;
import com.irfankhoirul.apps.tatravel.data.source.SearchDataSource;

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
