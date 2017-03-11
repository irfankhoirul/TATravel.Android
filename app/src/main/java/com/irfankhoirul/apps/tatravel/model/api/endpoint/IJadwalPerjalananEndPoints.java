package com.irfankhoirul.apps.tatravel.model.api.endpoint;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;
import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.GET_DRIVER_SCHEDULE;
import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.GET_SCHEDULE;
import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.LIST_DRIVER_SCHEDULE;
import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.LIST_SCHEDULE;
import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.UPDATE_SCHEDULE_STATUS;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IJadwalPerjalananEndPoints {

    @FormUrlEncoded
    @POST(LIST_SCHEDULE)
    Call<DataResult<JadwalPerjalanan>> listJadwalPerjalanan(
            @Path("id") String id,
            @Field("token") String token,
            @Field("idDepartureLocation") String idDepartureLocation,
            @Field("idDestinationLocation") String idDestinationLocation,
            @Field("date") Long date,
            @Field("page") String page
    );

    @FormUrlEncoded
    @POST(GET_SCHEDULE)
    Call<DataResult<JadwalPerjalanan>> getJadwalPerjalanan(
            @Path("id") String id,
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST(LIST_DRIVER_SCHEDULE)
    Call<DataResult<JadwalPerjalanan>> listJadwalPerjalananSupir(
            @Field("token") String token,
            @Field("page") String page
    );

    @FormUrlEncoded
    @POST(GET_DRIVER_SCHEDULE)
    Call<DataResult<JadwalPerjalanan>> getJadwalPerjalananSupir(
            @Path("id") String id,
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST(UPDATE_SCHEDULE_STATUS)
    Call<DataResult> setStatusJadwalPerjalanan(
            @Path("id") String id,
            @Field("token") String token,
            @Field("status") String status
    );

}
