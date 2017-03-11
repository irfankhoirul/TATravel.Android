package com.irfankhoirul.apps.tatravel.model.api.endpoint;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;
import com.irfankhoirul.apps.tatravel.model.pojo.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.DO_LOGIN;
import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.DO_LOGIN_DRIVER;
import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.DO_REGISTER;
import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.DO_VERIFY;
import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.GET_PROFILE;
import static com.irfankhoirul.apps.tatravel.model.api.EndPoints.UPDATE_PROFILE;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IUserEndPoints {

    @FormUrlEncoded
    @POST(DO_REGISTER)
    Call<DataResult> register(
            @Field("name") String name,
            @Field("phone") String phone,
            @Field("email") String email,
            @Field("password") String password,
            @Field("deviceSecretId") String deviceSecretId
    );

    @FormUrlEncoded
    @POST(DO_VERIFY)
    Call<DataResult> verify(
            @Field("registrationCode") String registrationCode,
            @Field("phone") String phone
    );

    @FormUrlEncoded
    @POST(DO_LOGIN)
    Call<DataResult<User>> login(
            @Field("deviceSecretId") String registrationCode,
            @Field("phone") String phone,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST(DO_LOGIN_DRIVER)
    Call<DataResult<User>> loginDriver(
            @Field("deviceSecretId") String deviceSecretId,
            @Field("phone") String phone,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST(GET_PROFILE)
    Call<DataResult<User>> getProfile(
            @Path("id") String id,
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST(UPDATE_PROFILE)
    Call<DataResult<User>> updateProfile(
            @Path("id") String id,
            @Field("token") String token,
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("alamat") String alamat,
            @Field("cityid") String cityid,
            @Field("provinceId") String provinceId
    );

}
