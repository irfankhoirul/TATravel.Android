package com.irfankhoirul.apps.tatravel.presenter;

import android.util.Log;

import com.irfankhoirul.apps.tatravel.aaa.core.components.DataResult;
import com.irfankhoirul.apps.tatravel.contract.SearchContract;
import com.irfankhoirul.apps.tatravel.model.data.remote.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.model.data.remote.SearchDataSource;
import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;

/**
 * Merupakan presenter dari SearchFragment
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public class SearchPresenter implements SearchContract.Presenter {

    private final SearchContract.View view;

    public SearchPresenter(SearchContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void getPromo() {
        //Todo : get promo data from server
        view.showPromo();
    }

    @Override
    public void searchJadwalPerjalanan() {
        SearchDataSource repository = new SearchDataSource();
        repository.getJadwalPerjalanan(new IRequestResponseListener<JadwalPerjalanan>() {
            @Override
            public void onSuccess(DataResult<JadwalPerjalanan> data) {
                view.showSearchResult(data.getDatas());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e("ERROR", throwable.getMessage());
            }
        });
    }
}
