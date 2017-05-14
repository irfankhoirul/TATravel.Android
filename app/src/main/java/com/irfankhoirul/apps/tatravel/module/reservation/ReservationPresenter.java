package com.irfankhoirul.apps.tatravel.module.reservation;

import android.util.Log;

import com.google.gson.Gson;
import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.components.util.CurrencyUtils;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.source.locale.cart.CartRepository;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.reservation.ReservationRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public class ReservationPresenter implements ReservationContract.Presenter {

    private final ReservationContract.View view;
    private final ReservationRepository reservationRepository;
    private final SessionRepository sessionRepository;
    private final CartRepository cartRepository;

    @Inject
    public ReservationPresenter(SessionRepository sessionRepository, CartRepository cartRepository,
                                ReservationRepository reservationRepository, ReservationContract.View view) {
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
        Map<String, String> reservationDetailData = new HashMap<>();
        reservationDetailData.put("departureLocation", cartRepository.getSchedule().getLokasiPemberangkatan().getNama() + ", " +
                cartRepository.getSchedule().getLokasiPemberangkatan().getKota().getNama());
        reservationDetailData.put("pickUpLocation", cartRepository.getDeparture().get("address"));
        reservationDetailData.put("pickUpCoordinate", cartRepository.getDeparture().get("latitude") +
                ", " + cartRepository.getDeparture().get("longitude"));
        reservationDetailData.put("departureTime", cartRepository.getSchedule().getWaktuKeberangkatan() + " " +
                cartRepository.getSchedule().getTimezone());
        reservationDetailData.put("destinationLocation", cartRepository.getSchedule().getLokasiTujuan().getNama() + ", " +
                cartRepository.getSchedule().getLokasiTujuan().getKota().getNama());
        reservationDetailData.put("takeLocation", cartRepository.getDestination().get("address"));
        reservationDetailData.put("takeCoordinate", cartRepository.getDestination().get("latitude") +
                ", " + cartRepository.getDestination().get("longitude"));
        reservationDetailData.put("arrivalTime", cartRepository.getSchedule().getWaktuKedatangan() + " " +
                cartRepository.getSchedule().getTimezone());
        reservationDetailData.put("operatorTravel", cartRepository.getSchedule().getOperatorTravel().getNama());
        reservationDetailData.put("passengerCount", String.valueOf(cartRepository.getPenumpang().size()));
        String passengerNames = "";
        for (int i = 0; i < cartRepository.getPenumpang().size(); i++) {
            passengerNames += cartRepository.getPenumpang().get(i).getNama();
            if (i < cartRepository.getPenumpang().size() - 1) {
                passengerNames += ", ";
            }
        }
        reservationDetailData.put("passengerNames", passengerNames);
        String seatNumbers = "";
        for (int i = 0; i < cartRepository.getSeat().size(); i++) {
            seatNumbers += cartRepository.getSeat().get(i).getKursiMobil().getNomor();
            if (i < cartRepository.getSeat().size() - 1) {
                seatNumbers += ", ";
            }
        }
        reservationDetailData.put("seatNumbers", seatNumbers);
        reservationDetailData.put("travelPrice", CurrencyUtils.formatRupiah(cartRepository.getSchedule().getHarga()));
        int pickUpDistance = (int) Math.ceil(cartRepository.getSchedule().getJarakPenjemputan());
        int pickUpPrice = cartRepository.getSchedule().getBiayaLokasiKhusus() * pickUpDistance;
        reservationDetailData.put("pickUpPrice", CurrencyUtils.formatRupiah(pickUpPrice));

        int takeDistance = (int) Math.ceil(cartRepository.getSchedule().getJarakPengantaran());
        int takePrice = cartRepository.getSchedule().getBiayaLokasiKhusus() * takeDistance;
        reservationDetailData.put("takePrice", CurrencyUtils.formatRupiah(takePrice));
        reservationDetailData.put("totalPrice", CurrencyUtils.formatRupiah(pickUpPrice + takePrice +
                (cartRepository.getPenumpang().size() * cartRepository.getSchedule().getHarga())));
        reservationDetailData.put("buyerName", sessionRepository.getSessionData().getNama());
        reservationDetailData.put("buyerPhoneNumber", sessionRepository.getSessionData().getNomorHandphone());
        reservationDetailData.put("buyerEmail", sessionRepository.getSessionData().getEmail());

        view.showDetailReservation(reservationDetailData);
    }

    @Override
    public void makeReservation() {
        view.setLoadingDialog(true, "Mencatatkan reservasi Anda...");

        Map<String, String> params = new HashMap<>();
        params.put("token", sessionRepository.getSessionData().getUserToken().getToken());
        params.put("idJadwalPerjalanan", String.valueOf(cartRepository.getSchedule().getId()));
        List<Integer> passengerIds = new ArrayList<>();
        for (int i = 0; i < cartRepository.getPenumpang().size(); i++) {
            passengerIds.add(cartRepository.getPenumpang().get(i).getId());
        }
        params.put("passengerIds", new Gson().toJson(passengerIds));
        List<Integer> seatIds = new ArrayList<>();
        for (int i = 0; i < cartRepository.getSeat().size(); i++) {
            seatIds.add(cartRepository.getSeat().get(i).getId());
        }
        params.put("seatIds", new Gson().toJson(seatIds));
        params.put("pickUpLat", cartRepository.getDeparture().get("latitude"));
        params.put("pickUpLon", cartRepository.getDeparture().get("longitude"));
        params.put("pickUpAddress", cartRepository.getDeparture().get("address"));
        params.put("takeLat", cartRepository.getDestination().get("latitude"));
        params.put("takeLon", cartRepository.getDestination().get("longitude"));
        params.put("takeAddress", cartRepository.getDestination().get("address"));

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Log.v(key, value);
        }
        reservationRepository.makeReservation(new IRequestResponseListener() {
            @Override
            public void onSuccess(DataResult result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    view.showStatus(ConstantUtils.STATUS_SUCCESS, result.getMessage());
                    // Redirect ke Detail Order Activity
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
}
