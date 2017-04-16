package com.irfankhoirul.apps.tatravel.module.departure;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;
import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;

import java.util.List;

/**
 * Created by Irfan Khoirul on 12/24/2016.
 */

public interface DepartureContract {

    interface View extends IBaseView<Presenter> {
        void setProgressDialog(boolean visibility, String title, String message);

        void showDialogCityDeparture();

        void showDialogDepartureLocation();

        void showSearchResult(List<JadwalPerjalanan> jadwalPerjalanan);

        void updateLocationSpinner(List<Lokasi> lokasi);
    }

    interface Presenter extends IBasePresenter {
        void getDepartureLocationList();

        void setupMap();
    }

}
