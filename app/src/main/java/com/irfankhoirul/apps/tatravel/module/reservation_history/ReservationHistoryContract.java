package com.irfankhoirul.apps.tatravel.module.reservation_history;

import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;
import com.irfankhoirul.mvp_core.base.IBasePresenter;
import com.irfankhoirul.mvp_core.base.IBaseView;
import com.irfankhoirul.mvp_core.data.DataPage;

import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface ReservationHistoryContract {
    interface View extends IBaseView<Presenter> {
        void updateReservationList(List<Pemesanan> reservations, DataPage dataPage, Map<String, String> params);

        void showDataExist();

        void showDataNotExist();

        void redirectToLoginOrRegister();

    }

    interface Presenter extends IBasePresenter {
        void listReservation(Map<String, String> params);

        List<Pemesanan> getReservations();
    }
}
