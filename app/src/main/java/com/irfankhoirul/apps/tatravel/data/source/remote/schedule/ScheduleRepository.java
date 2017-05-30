package com.irfankhoirul.apps.tatravel.data.source.remote.schedule;

import com.irfankhoirul.mvp_core.data.IRequestResponseListener;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 5/9/2017.
 */

public interface ScheduleRepository {

    void getDepartureAvailability(IRequestResponseListener listener, Map<String, String> param);

    void getDestinationAvailability(IRequestResponseListener listener, Map<String, String> param);

    void searchSchedule(IRequestResponseListener listener, int operatorTravelId, Map<String, String> param);

}
