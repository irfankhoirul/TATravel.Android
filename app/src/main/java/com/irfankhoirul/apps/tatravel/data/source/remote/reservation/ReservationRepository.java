package com.irfankhoirul.apps.tatravel.data.source.remote.reservation;

import com.irfankhoirul.mvp_core.data.RequestResponseListener;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 5/9/2017.
 */

public interface ReservationRepository {

    void makeReservation(RequestResponseListener listener, Map<String, String> param);

    void reservationDetail(RequestResponseListener listener, int reservationId, Map<String, String> param);

    void reservationList(RequestResponseListener listener, Map<String, String> param);
}
