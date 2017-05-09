package com.irfankhoirul.apps.tatravel.data.api.source.user;

import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.data.pojo.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.data.api.EndPoints.DO_LOGIN;
import static com.irfankhoirul.apps.tatravel.data.api.EndPoints.DO_LOGIN_DRIVER;
import static com.irfankhoirul.apps.tatravel.data.api.EndPoints.DO_LOGOUT;
import static com.irfankhoirul.apps.tatravel.data.api.EndPoints.DO_REGISTER;
import static com.irfankhoirul.apps.tatravel.data.api.EndPoints.DO_VERIFY;
import static com.irfankhoirul.apps.tatravel.data.api.EndPoints.GET_PROFILE;
import static com.irfankhoirul.apps.tatravel.data.api.EndPoints.UPDATE_FCM_TOKEN;
import static com.irfankhoirul.apps.tatravel.data.api.EndPoints.UPDATE_PROFILE;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IUserUseCase {

    /**
     * Param :
     *
     * @param param - name
     *              - phone
     *              - email
     *              - password
     *              - deviceSecretId
     */
    @FormUrlEncoded
    @POST(DO_REGISTER)
    Call<DataResult> register(@FieldMap Map<String, String> param);


    /**
     * Param
     *
     * @param param - registrationCode
     *              - phone
     *              - deviceSecretId
     */
    @FormUrlEncoded
    @POST(DO_VERIFY)
    Call<DataResult<User>> verify(@FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - deviceSecretId
     *              - phone
     *              - password
     */
    @FormUrlEncoded
    @POST(DO_LOGIN)
    Call<DataResult<User>> login(@FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - deviceSecretId
     *              - phone
     *              - password
     */
    @FormUrlEncoded
    @POST(DO_LOGIN_DRIVER)
    Call<DataResult<User>> loginDriver(@FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     */
    @FormUrlEncoded
    @POST(GET_PROFILE)
    Call<DataResult<User>> getProfile(@Path("id") String id, @FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     *              - name
     *              - email
     *              - password
     *              - alamat
     *              - cityid
     *              - provinceId
     */
    @FormUrlEncoded
    @POST(UPDATE_PROFILE)
    Call<DataResult<User>> updateProfile(@Path("id") String id, @FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     */
    @FormUrlEncoded
    @POST(DO_LOGOUT)
    Call<DataResult> logout(@FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     *              - FCMToken
     *              - secretCode
     */
    @FormUrlEncoded
    @POST(UPDATE_FCM_TOKEN)
    Call<DataResult> updateFcmToken(@FieldMap Map<String, String> param);

}