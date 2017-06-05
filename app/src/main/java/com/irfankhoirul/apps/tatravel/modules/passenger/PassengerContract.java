package com.irfankhoirul.apps.tatravel.modules.passenger;

import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;
import com.irfankhoirul.mvp_core.base.IBasePresenter;
import com.irfankhoirul.mvp_core.base.IBaseView;
import com.irfankhoirul.mvp_core.data.DataPage;

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

        void updatePassengerItem(int position);

        void addPassengerItem();

        void showDataNotExist();

        void showDataExist();
    }

    interface Presenter extends IBasePresenter {
        void createPassenger(Map<String, String> param);

        void updatePassenger(int position, Penumpang passenger, Map<String, String> param);

        void deletePassenger(int idPenumpang, int position, List<Penumpang> passengers);

        void listPassenger(Map<String, String> param);

        void setSelectedPassenger(List<Penumpang> passengers);

        List<Penumpang> getSelectedPassengers();

        void onPassengerItemClick(Penumpang passenger, boolean isSelected);

        List<Penumpang> getPassenger();
    }
}
