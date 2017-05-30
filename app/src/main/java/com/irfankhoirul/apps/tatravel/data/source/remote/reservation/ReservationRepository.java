package com.irfankhoirul.apps.tatravel.data.source.remote.reservation;

import com.irfankhoirul.mvp_core.data.IRequestResponseListener;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 5/9/2017.
 */

public interface ReservationRepository {

    void makeReservation(IRequestResponseListener listener, Map<String, String> param);

    void reservationDetail(IRequestResponseListener listener, int reservationId, Map<String, String> param);

    void reservationList(IRequestResponseListener listener, Map<String, String> param);
}
