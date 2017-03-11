package com.irfankhoirul.apps.tatravel.model.api.endpoint;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;
import com.irfankhoirul.apps.tatravel.model.pojo.Penumpang;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.CREATE_PENUMPANG;
import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.DELETE_PENUMPANG;
import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.LIST_PENUMPANG;
import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.UPDATE_PENUMPANG;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IPenumpangEndPoints {

    @FormUrlEncoded
    @POST(CREATE_PENUMPANG)
    Call<DataResult> createPenumpang(
            @Path("userId") String userId,
            @Field("token") String token,
            @Field("name") String name
    );

    @FormUrlEncoded
    @POST(UPDATE_PENUMPANG)
    Call<DataResult> updatePenumpang(
            @Path("userId") String userId,
            @Path("id") String idPenumpang,
            @Field("token") String token,
            @Field("name") String name
    );

    @FormUrlEncoded
    @POST(DELETE_PENUMPANG)
    Call<DataResult> deletePenumpang(
            @Path("userId") String userId,
            @Path("id") String idPenumpang
    );

    @FormUrlEncoded
    @POST(LIST_PENUMPANG)
    Call<DataResult<Penumpang>> listPenumpang(
            @Path("userId") String userId,
            @Field("token") String token,
            @Field("page") String name
    );

}
