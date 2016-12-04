package com.irfankhoirul.apps.tatravel.model.api;

import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.model.pojo.Lokasi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import static com.irfankhoirul.apps.tatravel.model.api.EndPointsUtils.GET_LOCATION;
import static com.irfankhoirul.apps.tatravel.model.api.EndPointsUtils.GET_SCHEDULE;

/**
 * Merupakan interface yang berisi method untuk melakukan query. Digunakan oleh retrofit.
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public interface IEndPoint {
    @FormUrlEncoded
    @POST(GET_SCHEDULE)
    Call<DataResult<JadwalPerjalanan>> search(@Field("date") String date);

    @POST(GET_LOCATION)
    Call<DataResult<Lokasi>> getLocation();
}
