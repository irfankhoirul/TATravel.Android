package com.irfankhoirul.apps.tatravel.module.reservation_detail;

import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;
import com.irfankhoirul.mvp_core.base.IBasePresenter;
import com.irfankhoirul.mvp_core.base.IBaseView;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface ReservationDetailContract {
    interface View extends IBaseView<Presenter> {
        void showReservationDetail(Pemesanan reservation);
    }

    interface Presenter extends IBasePresenter {
        void getLastReservationDetail();

        void clearCart();
    }
}
