package com.irfankhoirul.apps.tatravel.data.source.remote.user;

import com.irfankhoirul.apps.tatravel.data.pojo.Kota;
import com.irfankhoirul.apps.tatravel.data.pojo.Provinsi;
import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.mvp_core.data.DataResult;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.DO_LOGIN;
import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.DO_LOGIN_DRIVER;
import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.DO_LOGOUT;
import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.DO_REGISTER;
import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.DO_VERIFY;
import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.GET_PROFILE;
import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.LIST_KOTA;
import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.LIST_PROVINSI;
import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.UPDATE_FCM_TOKEN;
import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.UPDATE_PROFILE;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface UserEndPoints {

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
     *              - email
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
     *              - email
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
     *              - email
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
    Call<DataResult<User>> updateProfile(@Path("id") int id, @FieldMap Map<String, String> param);

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

    /**
     * Param
     *
     * @param param - token
     */
    @FormUrlEncoded
    @POST(LIST_KOTA)
    Call<DataResult<Kota>> listKota(@Path("id") int id, @FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     */
    @FormUrlEncoded
    @POST(LIST_PROVINSI)
    Call<DataResult<Provinsi>> listProvinsi(@FieldMap Map<String, String> param);
}
