package com.irfankhoirul.apps.tatravel.presenter;

import android.util.Log;

import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;
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

public class SearchPresenter {

    IView view;

    public SearchPresenter(IView view) {
        this.view = view;
    }

    public void search() {
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

    /**
     * Merupakan interface yang menghubungkan SearchFragment dan SearchPresenter
     *
     * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
     * @version 1.0 (13 November 2016)
     * @since 1.0
     */
    public interface IView {
        void showSearchResult(List<JadwalPerjalanan> jadwalPerjalanen);
    }
}
