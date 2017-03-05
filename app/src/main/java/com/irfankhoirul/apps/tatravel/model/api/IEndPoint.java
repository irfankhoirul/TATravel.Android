package com.irfankhoirul.apps.tatravel.model.api;

import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.model.pojo.Kota;
import com.irfankhoirul.apps.tatravel.model.pojo.Lokasi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.GET_CITY_OLD;
import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.GET_LOCATION_OLD;
import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.GET_SCHEDULE_OLD;

/**
 * Merupakan interface yang berisi method untuk melakukan query. Digunakan oleh retrofit.
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public interface IEndPoint {
    @FormUrlEncoded
    @POST(GET_SCHEDULE_OLD)
    Call<DataResult<JadwalPerjalanan>> search(@Field("date") String date);

    @FormUrlEncoded
    @POST(GET_SCHEDULE_OLD)
    Observable<DataResult<JadwalPerjalanan>> searchRx(@Field("date") String date);

    @FormUrlEncoded
    @POST(GET_LOCATION_OLD)
    Call<DataResult<Lokasi>> getTravelAgentLocationList(@Field("page") int page, @Field("limit") int limit, @Field("cityId") int cityId);

    @FormUrlEncoded
    @POST(GET_CITY_OLD)
    Call<DataResult<Kota>> getCityList(@Field("page") int page, @Field("limit") int limit);
}
