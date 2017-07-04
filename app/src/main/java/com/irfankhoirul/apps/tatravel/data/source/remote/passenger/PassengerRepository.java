package com.irfankhoirul.apps.tatravel.data.source.remote.passenger;

import com.irfankhoirul.mvp_core.data.RequestResponseListener;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 5/9/2017.
 */

public interface PassengerRepository {

    void createPassenger(RequestResponseListener listener, int userId, Map<String, String> param);

    void updatePassenger(RequestResponseListener listener, int userId, int passengerId, Map<String, String> param);

    void deletePassenger(RequestResponseListener listener, int userId, int passengerId, Map<String, String> param);

    void listPassenger(RequestResponseListener listener, int userId, Map<String, String> param);

}
