package com.irfankhoirul.apps.tatravel.model.api.endpoint;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;
import com.irfankhoirul.apps.tatravel.model.pojo.Pemesanan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.DO_RESERVATION;
import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.GET_RESERVATION;
import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.LIST_RESERVATION;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IPemesananEndPoints {

    @FormUrlEncoded
    @POST(DO_RESERVATION)
    Call<DataResult> reservasi(
            @Field("token") String token,
            @Field("idJadwalPerjalanan") String idJadwalPerjalanan
    );

    @FormUrlEncoded
    @POST(GET_RESERVATION)
    Call<DataResult<Pemesanan>> getReservasi(
            @Path("id") String id,
            @Field("token") String token,
            @Field("idJadwalPerjalanan") String idJadwalPerjalanan
    );

    @FormUrlEncoded
    @POST(LIST_RESERVATION)
    Call<DataResult<Pemesanan>> listReservasi(
            @Field("token") String token,
            @Field("status") String cityId,
            @Field("page") String page
    );

}
