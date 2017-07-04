package com.irfankhoirul.apps.tatravel.modules.reservation;

import com.irfankhoirul.mvp_core.base.BasePresenter;
import com.irfankhoirul.mvp_core.base.BaseView;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface ReservationContract {
    interface View extends BaseView<Presenter> {
        void showDetailReservation(Map<String, String> reservationData);

        void finishActivity();
    }

    interface Presenter extends BasePresenter {
        void makeReservation();

        boolean isTimeAvailable();
    }
}
