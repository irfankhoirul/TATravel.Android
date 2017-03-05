package com.irfankhoirul.apps.tatravel.presenter;

import android.util.Log;

import com.irfankhoirul.apps.tatravel.contract.SearchFragmentContract;
import com.irfankhoirul.apps.tatravel.model.data_manager.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.model.data_manager.SearchInteractor;
import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;

import java.util.List;

/**
 * Merupakan presenter dari SearchFragment
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public class SearchFragmentPresenter implements SearchFragmentContract.Presenter {

    private final SearchFragmentContract.View view;

    public SearchFragmentPresenter(SearchFragmentContract.View view) {
        this.view = view;
    }

    @Override
    public void getPromo() {
        //Todo : get promo data from server
        view.showPromo();
    }

    @Override
    public void searchJadwalPerjalanan() {
        SearchInteractor repository = new SearchInteractor();
        repository.getJadwalPerjalanan(new IRequestResponseListener<List<JadwalPerjalanan>>() {
            @Override
            public void onSuccess(List<JadwalPerjalanan> data) {
                view.showSearchResult(data);
            }

            @Override
            public void onFailure() {
                Log.v("Retrofit", "OnFailure");
            }
        });
    }

}
