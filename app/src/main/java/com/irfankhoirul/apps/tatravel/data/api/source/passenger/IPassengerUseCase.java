package com.irfankhoirul.apps.tatravel.data.api.source.passenger;

import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.data.api.EndPoints.CREATE_PENUMPANG;
import static com.irfankhoirul.apps.tatravel.data.api.EndPoints.DELETE_PENUMPANG;
import static com.irfankhoirul.apps.tatravel.data.api.EndPoints.LIST_PENUMPANG;
import static com.irfankhoirul.apps.tatravel.data.api.EndPoints.UPDATE_PENUMPANG;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IPassengerUseCase {

    /**
     * Param
     *
     * @param param - token
     *              - name
     */
    @FormUrlEncoded
    @POST(CREATE_PENUMPANG)
    Call<DataResult> createPenumpang(@Path("userId") String userId, @FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     *              - name
     */
    @FormUrlEncoded
    @POST(UPDATE_PENUMPANG)
    Call<DataResult> updatePenumpang(@Path("userId") String userId, @Path("id") String idPenumpang, @FieldMap Map<String, String> param);

    /**
     * Param
     * -
     */
    @FormUrlEncoded
    @POST(DELETE_PENUMPANG)
    Call<DataResult> deletePenumpang(@Path("userId") String userId, @Path("id") String idPenumpang);

    /**
     * Param
     *
     * @param param - token
     *              - name
     */
    @FormUrlEncoded
    @POST(LIST_PENUMPANG)
    Call<DataResult<Penumpang>> listPenumpang(@Path("userId") String userId, @FieldMap Map<String, String> param);

}
