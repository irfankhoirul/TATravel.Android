package com.irfankhoirul.apps.tatravel.module.search;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;
import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.data.source.locale.cart.CartRepository;

import java.util.List;

/**
 * Created by Irfan Khoirul on 11/15/2016.
 */

public interface SearchContract {

    /**
     * Merupakan interface yang menghubungkan SearchFragment dan SearchPresenter
     *
     * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
     * @version 1.0 (13 November 2016)
     * @since 1.0
     */
    interface View extends IBaseView<Presenter> {
        void showPromo();

        void showSearchResult(List<JadwalPerjalanan> jadwalPerjalanan);

    }

    interface Presenter extends IBasePresenter {
        CartRepository getCart();

        void getPromo();

        void searchJadwalPerjalanan();
    }

}
