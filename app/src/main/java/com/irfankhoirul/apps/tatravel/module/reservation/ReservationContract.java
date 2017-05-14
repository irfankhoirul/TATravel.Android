package com.irfankhoirul.apps.tatravel.module.reservation;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface ReservationContract {
    interface View extends IBaseView<Presenter> {
        void showDetailReservation(Map<String, String> reservationData);
    }

    interface Presenter extends IBasePresenter {
        void makeReservation();
    }
}
