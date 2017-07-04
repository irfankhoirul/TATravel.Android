package com.irfankhoirul.apps.tatravel.data.source.remote.seat;

import com.irfankhoirul.mvp_core.data.RequestResponseListener;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 5/9/2017.
 */

public interface SeatRepository {

    void scheduleSeat(RequestResponseListener listener, int scheduleId, Map<String, String> param);

    void bookSeat(RequestResponseListener listener, Map<String, String> param);
}
