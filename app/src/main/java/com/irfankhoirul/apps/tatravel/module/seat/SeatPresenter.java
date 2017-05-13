package com.irfankhoirul.apps.tatravel.module.seat;

import android.util.Log;

import com.google.gson.Gson;
import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.KursiPerjalanan;
import com.irfankhoirul.apps.tatravel.data.source.locale.cart.CartRepository;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.seat.SeatRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public class SeatPresenter implements SeatContract.Presenter {

    private final SeatContract.View view;
    private final SessionRepository sessionRepository;
    private final SeatRepository seatRepository;
    private final CartRepository cartRepository;

    @Inject
    public SeatPresenter(SessionRepository sessionRepository, CartRepository cartRepository,
                         SeatRepository seatRepository, SeatContract.View view) {
        this.view = view;
        this.sessionRepository = sessionRepository;
        this.seatRepository = seatRepository;
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
    public void getCarSeats(int scheduleId) {
        view.setLoadingDialog(true, "Mengecek ketersediaan kursi...");

        Map<String, String> params = new HashMap<>();
        params.put("token", sessionRepository.getSessionData().getUserToken().getToken());
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Log.v(key, value);
        }
        seatRepository.scheduleSeat(new IRequestResponseListener<KursiPerjalanan>() {
            @Override
            public void onSuccess(DataResult<KursiPerjalanan> result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    view.showSeats(result.getDatas());
                } else {
                    view.showStatus(ConstantUtils.STATUS_ERROR, result.getMessage());
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.setLoadingDialog(false, null);
                view.showStatus(ConstantUtils.STATUS_ERROR, "Terjadi kesalahan");
            }
        }, scheduleId, params);
    }

    @Override
    public void bookSeat(List<KursiPerjalanan> seats) {
        cartRepository.setSeat(seats);
        view.setLoadingDialog(true, "Membooking kursi...");

        List<Integer> seatIds = new ArrayList<>();
        for (int i = 0; i < seats.size(); i++) {
            seatIds.add(seats.get(i).getId());
        }

        Map<String, String> params = new HashMap<>();
        params.put("token", sessionRepository.getSessionData().getUserToken().getToken());
        params.put("seatIds", new Gson().toJson(seatIds));

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Log.v(key, value);
        }
        seatRepository.bookSeat(new IRequestResponseListener() {
            @Override
            public void onSuccess(DataResult result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    cartRepository.setSeatSetTime(System.currentTimeMillis());
                    view.redirectToReservationDetail();
                } else {
                    view.showStatus(ConstantUtils.STATUS_ERROR, result.getMessage());
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.setLoadingDialog(false, null);
                view.showStatus(ConstantUtils.STATUS_ERROR, "Terjadi kesalahan");
            }
        }, params);
    }

    @Override
    public CartRepository getCart() {
        return cartRepository;
    }
}
