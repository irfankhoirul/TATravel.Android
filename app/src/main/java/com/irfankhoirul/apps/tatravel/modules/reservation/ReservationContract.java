package com.irfankhoirul.apps.tatravel.modules.reservation;

import com.irfankhoirul.mvp_core.base.IBasePresenter;
import com.irfankhoirul.mvp_core.base.IBaseView;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface ReservationContract {
    interface View extends IBaseView<Presenter> {
        void showDetailReservation(Map<String, String> reservationData);

        void finishActivity();
    }

    interface Presenter extends IBasePresenter {
        void makeReservation();

        boolean isTimeAvailable();
    }
}
