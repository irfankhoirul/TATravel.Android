package com.irfankhoirul.apps.tatravel.data.source.remote.passenger;

import com.irfankhoirul.mvp_core.data.IRequestResponseListener;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 5/9/2017.
 */

public interface PassengerRepository {

    void createPassenger(IRequestResponseListener listener, int userId, Map<String, String> param);

    void updatePassenger(IRequestResponseListener listener, int userId, int passengerId, Map<String, String> param);

    void deletePassenger(IRequestResponseListener listener, int userId, int passengerId, Map<String, String> param);

    void listPassenger(IRequestResponseListener listener, int userId, Map<String, String> param);

}
