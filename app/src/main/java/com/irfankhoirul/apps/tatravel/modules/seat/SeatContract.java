package com.irfankhoirul.apps.tatravel.modules.seat;

import com.irfankhoirul.apps.tatravel.data.pojo.KursiPerjalanan;
import com.irfankhoirul.apps.tatravel.data.source.locale.cart.CartRepository;
import com.irfankhoirul.mvp_core.base.BasePresenter;
import com.irfankhoirul.mvp_core.base.BaseView;

import java.util.List;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface SeatContract {
    interface View extends BaseView<Presenter> {
        void showSeats(List<KursiPerjalanan> seats);

        void redirectToReservationDetail();

        void finishActivity(int resultCode);

        void setup5Seats();

        void setup6Seats();

        void setup10Seats();

        void setup14Seats();

        void setup19Seats();
    }

    interface Presenter extends BasePresenter {
        void getCarSeats(int scheduleId);

        void bookSeat();

        CartRepository getCart();

        List<KursiPerjalanan> getSelectedSeats();

        boolean checkCountSelectedSeatMatch();

        void handleActivityResult(int requestCode, int resultCode);
    }
}
