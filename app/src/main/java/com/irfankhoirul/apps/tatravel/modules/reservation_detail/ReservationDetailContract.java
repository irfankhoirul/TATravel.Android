package com.irfankhoirul.apps.tatravel.modules.reservation_detail;

import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;
import com.irfankhoirul.mvp_core.base.BasePresenter;
import com.irfankhoirul.mvp_core.base.BaseView;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface ReservationDetailContract {
    interface View extends BaseView<Presenter> {
        void showReservationDetail(Pemesanan reservation);
    }

    interface Presenter extends BasePresenter {
        void getLastReservationDetail();

        void clearCart();
    }
}
