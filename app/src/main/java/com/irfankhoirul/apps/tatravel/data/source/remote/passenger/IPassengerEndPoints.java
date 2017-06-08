package com.irfankhoirul.apps.tatravel.data.source.remote.passenger;

import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;
import com.irfankhoirul.mvp_core.data.DataResult;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.CREATE_PENUMPANG;
import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.DELETE_PENUMPANG;
import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.LIST_PENUMPANG;
import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.UPDATE_PENUMPANG;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IPassengerEndPoints {

    /**
     * Param
     *
     * @param param - token
     *              - name
     */
    @FormUrlEncoded
    @POST(CREATE_PENUMPANG)
    Call<DataResult<Penumpang>> createPenumpang(@Path("userId") int userId, @FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     *              - name
     */
    @FormUrlEncoded
    @POST(UPDATE_PENUMPANG)
    Call<DataResult<Penumpang>> updatePenumpang(@Path("userId") int userId, @Path("id") int idPenumpang, @FieldMap Map<String, String> param);

    /**
     * Param
     * - token
     */
    @FormUrlEncoded
    @POST(DELETE_PENUMPANG)
    Call<DataResult> deletePenumpang(@Path("userId") int userId, @Path("id") int idPenumpang, @FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     *              - name
     */
    @FormUrlEncoded
    @POST(LIST_PENUMPANG)
    Call<DataResult<Penumpang>> listPenumpang(@Path("userId") int userId, @FieldMap Map<String, String> param);

}
