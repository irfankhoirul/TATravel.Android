package com.irfankhoirul.apps.tatravel.model.api.endpoint;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;
import com.irfankhoirul.apps.tatravel.model.pojo.OperatorTravel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.model.api.endpoint.EndPoints.GET_OPERATOR_TRAVEL;
import static com.irfankhoirul.apps.tatravel.model.api.endpoint.EndPoints.LIST_OPERATOR_TRAVEL;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IOperatorTravelEndPoints {

    @FormUrlEncoded
    @POST(LIST_OPERATOR_TRAVEL)
    Call<DataResult<OperatorTravel>> listOperatorTravel(
            @Field("token") String token,
            @Field("cityId") String name,
            @Field("page") String email
    );

    @FormUrlEncoded
    @POST(GET_OPERATOR_TRAVEL)
    Call<DataResult<OperatorTravel>> getDetailOperatorTravel(
            @Path("id") String id,
            @Field("token") String token
    );

}
