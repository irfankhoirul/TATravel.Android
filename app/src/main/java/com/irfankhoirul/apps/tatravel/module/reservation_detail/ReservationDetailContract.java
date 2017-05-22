package com.irfankhoirul.apps.tatravel.module.reservation_detail;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;
import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;

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
