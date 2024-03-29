package com.irfankhoirul.apps.tatravel.modules.reservation_history;

import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;
import com.irfankhoirul.mvp_core.base.BasePresenter;
import com.irfankhoirul.mvp_core.base.BaseView;
import com.irfankhoirul.mvp_core.data.DataPage;

import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface ReservationHistoryContract {
    interface View extends BaseView<Presenter> {
        void updateReservationList(List<Pemesanan> reservations, DataPage dataPage, Map<String, String> params);

        void showDataExist();

        void showDataNotExist();

        void redirectToLoginOrRegister();

    }

    interface Presenter extends BasePresenter {
        void listReservation(Map<String, String> params);

        List<Pemesanan> getReservations();
    }
}
