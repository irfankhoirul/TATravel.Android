package com.irfankhoirul.apps.tatravel.model.api.endpoint;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import static com.irfankhoirul.apps.tatravel.model.api.endpoint.EndPoints.UPDATE_FCM_TOKEN;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IUserDeviceEndPoints {

    /**
     * Param
     *
     * @param param - token
     *              - FCMToken
     */
    @FormUrlEncoded
    @POST(UPDATE_FCM_TOKEN)
    Call<DataResult> updateFcmToken(@FieldMap Map<String, String> param);

}
