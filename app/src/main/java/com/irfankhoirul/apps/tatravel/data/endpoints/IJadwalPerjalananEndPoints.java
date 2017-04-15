package com.irfankhoirul.apps.tatravel.data.endpoints;

import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.data.EndPoints.GET_DRIVER_SCHEDULE;
import static com.irfankhoirul.apps.tatravel.data.EndPoints.GET_SCHEDULE;
import static com.irfankhoirul.apps.tatravel.data.EndPoints.LIST_DRIVER_SCHEDULE;
import static com.irfankhoirul.apps.tatravel.data.EndPoints.LIST_SCHEDULE;
import static com.irfankhoirul.apps.tatravel.data.EndPoints.UPDATE_SCHEDULE_STATUS;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IJadwalPerjalananEndPoints {

    /**
     * Param
     *
     * @param param - token
     *              - idDepartureLocation
     *              - idDestinationLocation
     *              - date
     *              - page
     */
    @FormUrlEncoded
    @POST(LIST_SCHEDULE)
    Call<DataResult<JadwalPerjalanan>> listJadwalPerjalanan(@Path("id") String id, @FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     */
    @FormUrlEncoded
    @POST(GET_SCHEDULE)
    Call<DataResult<JadwalPerjalanan>> getJadwalPerjalanan(@Path("id") String id, @FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     *              - page
     */
    @FormUrlEncoded
    @POST(LIST_DRIVER_SCHEDULE)
    Call<DataResult<JadwalPerjalanan>> listJadwalPerjalananSupir(@FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     */
    @FormUrlEncoded
    @POST(GET_DRIVER_SCHEDULE)
    Call<DataResult<JadwalPerjalanan>> getJadwalPerjalananSupir(@Path("id") String id, @FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     *              - status
     */
    @FormUrlEncoded
    @POST(UPDATE_SCHEDULE_STATUS)
    Call<DataResult> setStatusJadwalPerjalanan(@Path("id") String id, @FieldMap Map<String, String> param);

}
