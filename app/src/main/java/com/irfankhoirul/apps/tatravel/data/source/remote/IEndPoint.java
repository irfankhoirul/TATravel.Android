package com.irfankhoirul.apps.tatravel.data.source.remote;

import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.data.pojo.Kota;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Merupakan interface yang berisi method untuk melakukan query. Digunakan oleh retrofit.
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public interface IEndPoint {
    /* OLD */

    @FormUrlEncoded
    @POST(EndPoints.GET_SCHEDULE_OLD)
    Call<DataResult<JadwalPerjalanan>> search(@Field("date") String date);

    @FormUrlEncoded
    @POST(EndPoints.GET_SCHEDULE_OLD)
    Observable<DataResult<JadwalPerjalanan>> searchRx(@Field("date") String date);

    @FormUrlEncoded
    @POST(EndPoints.GET_LOCATION_OLD)
    Call<DataResult<Lokasi>> getTravelAgentLocationList(@Field("page") int page, @Field("limit") int limit, @Field("cityId") int cityId);

    @FormUrlEncoded
    @POST(EndPoints.GET_CITY_OLD)
    Call<DataResult<Kota>> getCityList(@Field("page") int page, @Field("limit") int limit);
}
