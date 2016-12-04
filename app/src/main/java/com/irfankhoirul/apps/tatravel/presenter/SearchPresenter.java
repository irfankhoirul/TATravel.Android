package com.irfankhoirul.apps.tatravel.presenter;

import android.util.Log;

import com.irfankhoirul.apps.tatravel.contract.SearchContract;
import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.model.pojo.Lokasi;
import com.irfankhoirul.apps.tatravel.model.repository.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.model.repository.JadwalPerjalananRepository;

import java.util.List;

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
    public void searchJadwalPerjalanan() {
        JadwalPerjalananRepository repository = new JadwalPerjalananRepository();
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

    @Override
    public void getLocation() {
        JadwalPerjalananRepository repository = new JadwalPerjalananRepository();
        repository.getLocation(new IRequestResponseListener<List<Lokasi>>() {
            @Override
            public void onSuccess(List<Lokasi> data) {
                view.updateLocationSpinner(data);
            }

            @Override
            public void onFailure() {
                Log.v("Retrofit", "OnFailure");
            }
        });
    }

}
