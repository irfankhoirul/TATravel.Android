package com.irfankhoirul.apps.tatravel.model.api.endpoint;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import static com.irfankhoirul.apps.tatravel.model.api.endpoint.EndPoints.UPDATE_FCM_TOKEN;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IUserDeviceEndPoints {

    @FormUrlEncoded
    @POST(UPDATE_FCM_TOKEN)
    Call<DataResult> updateFcmToken(
            @Field("token") String token,
            @Field("FCMToken") String FCMToken
    );

}
