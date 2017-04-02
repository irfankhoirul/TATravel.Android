package com.irfankhoirul.apps.tatravel.contract;

import com.irfankhoirul.apps.tatravel.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.model.pojo.Lokasi;

import java.util.List;

/**
 * Created by Irfan Khoirul on 12/24/2016.
 */

public interface DepartureFragmentContract {

    interface View {
        void setProgressDialog(boolean visibility, String title, String message);

        void showSnackBar(int type, String message, String action, android.view.View.OnClickListener listener);

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
