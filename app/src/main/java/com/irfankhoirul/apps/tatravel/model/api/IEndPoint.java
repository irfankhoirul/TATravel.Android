package com.irfankhoirul.apps.tatravel.model.api;

import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;

import retrofit2.Call;
import retrofit2.http.POST;

import static com.irfankhoirul.apps.tatravel.model.api.EndPointsUtils.API_TRAVEL_SCHEDULE_SEARCH;

/**
 * Merupakan interface yang berisi method untuk melakukan query. Digunakan oleh retrofit.
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public interface IEndPoint {
    @POST(API_TRAVEL_SCHEDULE_SEARCH)
    Call<DataResult<JadwalPerjalanan>> search();
}
