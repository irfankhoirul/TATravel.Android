package com.irfankhoirul.apps.tatravel.module.reservation_detail;

import com.irfankhoirul.apps.tatravel.data.source.locale.cart.CartRepository;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.reservation.ReservationRepository;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public class ReservationDetailPresenter implements ReservationDetailContract.Presenter {

    private final ReservationDetailContract.View view;
    private final ReservationRepository reservationRepository;
    private final SessionRepository sessionRepository;
    private final CartRepository cartRepository;

    @Inject
    public ReservationDetailPresenter(SessionRepository sessionRepository,
                                      CartRepository cartRepository,
                                      ReservationRepository reservationRepository,
                                      ReservationDetailContract.View view) {
        this.view = view;
        this.reservationRepository = reservationRepository;
        this.sessionRepository = sessionRepository;
        this.cartRepository = cartRepository;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void getLastReservationDetail() {
        view.showReservationDetail(cartRepository.getLastReservation());
    }

    @Override
    public void clearCart() {
        cartRepository.clearCart();
    }
}
