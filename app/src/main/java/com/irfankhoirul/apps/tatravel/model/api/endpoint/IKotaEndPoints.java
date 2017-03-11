package com.irfankhoirul.apps.tatravel.model.api.endpoint;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;
import com.irfankhoirul.apps.tatravel.model.pojo.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.LIST_KOTA;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IKotaEndPoints {

    @FormUrlEncoded
    @POST(LIST_KOTA)
    Call<DataResult<User>> listKota(
            @Field("token") String token,
            @Field("page") String page
    );

}
