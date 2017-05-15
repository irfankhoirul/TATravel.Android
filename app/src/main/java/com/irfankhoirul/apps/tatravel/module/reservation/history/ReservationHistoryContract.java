package com.irfankhoirul.apps.tatravel.module.reservation.history;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;
import com.irfankhoirul.apps.tatravel.core.data.DataPage;
import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;

import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface ReservationHistoryContract {
    interface View extends IBaseView<Presenter> {
        void updateReservationList(List<Pemesanan> reservations, DataPage dataPage, Map<String, String> params);

        void resetReservationListData();

        void showDataExist();

        void showDataNotExist();

        void redirectToLoginOrRegister();

    }

    interface Presenter extends IBasePresenter {
        void listReservation(Map<String, String> params);
    }
}