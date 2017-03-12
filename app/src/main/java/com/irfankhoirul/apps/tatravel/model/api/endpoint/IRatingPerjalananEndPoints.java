package com.irfankhoirul.apps.tatravel.model.api.endpoint;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;
import com.irfankhoirul.apps.tatravel.model.pojo.Lokasi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.model.api.endpoint.EndPoints.CREATE_RATING_OPERATOR_TRAVEL;
import static com.irfankhoirul.apps.tatravel.model.api.endpoint.EndPoints.DELETE_RATING_OPERATOR_TRAVEL;
import static com.irfankhoirul.apps.tatravel.model.api.endpoint.EndPoints.UPDATE_RATING_OPERATOR_TRAVEL;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IRatingPerjalananEndPoints {

    @FormUrlEncoded
    @POST(CREATE_RATING_OPERATOR_TRAVEL)
    Call<DataResult<Lokasi>> setRatingOperatorTravel(
            @Field("token") String token,
            @Field("idJadwalPerjalanan") String cityId,
            @Field("rating") String page
    );

    @FormUrlEncoded
    @POST(UPDATE_RATING_OPERATOR_TRAVEL)
    Call<DataResult<Lokasi>> updateRatingOperatorTravel(
            @Path("id") String id,
            @Field("token") String token,
            @Field("idJadwalPerjalanan") String cityId,
            @Field("rating") String page
    );

    @FormUrlEncoded
    @POST(DELETE_RATING_OPERATOR_TRAVEL)
    Call<DataResult<Lokasi>> deleteRatingOperatorTravel(
            @Path("id") String id,
            @Field("token") String token
    );
}
