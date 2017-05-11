package com.irfankhoirul.apps.tatravel.module.passenger;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;
import com.irfankhoirul.apps.tatravel.core.data.DataPage;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;

import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface PassengerContract {
    interface View extends IBaseView<Presenter> {
        void updatePassengerList(List<Penumpang> passengers, DataPage dataPage, Map<String, String> params);

        void onCreatePassengerClick();

        void removePassengerItem(int position);

        void updatePassengerItem(int position, Penumpang passenger);

        void addPassengerItem(Penumpang passenger);
    }

    interface Presenter extends IBasePresenter {
        void createPassenger(Map<String, String> param);

        void updatePassenger(int position, Penumpang passenger, Map<String, String> param);

        void deletePassenger(int idPenumpang, int position);

        void listPassenger(Map<String, String> param);
    }
}
