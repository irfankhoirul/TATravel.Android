package com.irfankhoirul.apps.tatravel.data.source.remote.schedule;

import com.irfankhoirul.mvp_core.data.RequestResponseListener;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 5/9/2017.
 */

public interface ScheduleRepository {

    void getDepartureAvailability(RequestResponseListener listener, Map<String, String> param);

    void getDestinationAvailability(RequestResponseListener listener, Map<String, String> param);

    void searchSchedule(RequestResponseListener listener, int operatorTravelId, Map<String, String> param);

}
