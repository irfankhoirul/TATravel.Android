package com.irfankhoirul.apps.tatravel.modules.passenger;

import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;
import com.irfankhoirul.mvp_core.base.BasePresenter;
import com.irfankhoirul.mvp_core.base.BaseView;
import com.irfankhoirul.mvp_core.data.DataPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface PassengerContract {
    interface View extends BaseView<Presenter> {
        void updatePassengerList(List<Penumpang> passengers, DataPage dataPage, Map<String, String> params);

        void onCreatePassengerClick();

        void removePassengerItem(int position);

        void updatePassengerItem(int position);

        void addPassengerItem();

        void showDataNotExist();

        void showDataExist();

        void showPassengerCreatorDialog(String title, Penumpang passenger, int position);
    }

    interface Presenter extends BasePresenter {
        void createPassenger(Map<String, String> param);

        void updatePassenger(int position, Penumpang passenger, Map<String, String> param);

        void deletePassenger(int idPenumpang, int position, List<Penumpang> passengers);

        void listPassenger(Map<String, String> param);

        void setSelectedPassenger(ArrayList<Penumpang> passengers);

        ArrayList<Penumpang> getSelectedPassengers();

        void onPassengerItemClick(Penumpang passenger, boolean isSelected);

        List<Penumpang> getPassenger();
    }
}
