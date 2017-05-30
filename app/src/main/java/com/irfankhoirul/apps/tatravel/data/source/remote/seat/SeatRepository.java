package com.irfankhoirul.apps.tatravel.data.source.remote.seat;

import com.irfankhoirul.mvp_core.data.IRequestResponseListener;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 5/9/2017.
 */

public interface SeatRepository {

    void scheduleSeat(IRequestResponseListener listener, int scheduleId, Map<String, String> param);

    void bookSeat(IRequestResponseListener listener, Map<String, String> param);
}
