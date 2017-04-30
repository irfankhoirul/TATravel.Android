package com.irfankhoirul.apps.tatravel.module.search;

import android.util.Log;

import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.api.source.SearchDataSource;
import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;


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
