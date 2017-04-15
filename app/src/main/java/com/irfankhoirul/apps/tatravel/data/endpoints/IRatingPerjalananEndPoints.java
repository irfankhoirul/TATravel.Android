package com.irfankhoirul.apps.tatravel.data.endpoints;

import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.data.EndPoints.CREATE_RATING_OPERATOR_TRAVEL;
import static com.irfankhoirul.apps.tatravel.data.EndPoints.DELETE_RATING_OPERATOR_TRAVEL;
import static com.irfankhoirul.apps.tatravel.data.EndPoints.UPDATE_RATING_OPERATOR_TRAVEL;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IRatingPerjalananEndPoints {

    /**
     * Param
     *
     * @param param - token
     *              - cityId
     *              - page
     */
    @FormUrlEncoded
    @POST(CREATE_RATING_OPERATOR_TRAVEL)
    Call<DataResult<Lokasi>> setRatingOperatorTravel(@FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     *              - cityId
     *              - page
     */
    @FormUrlEncoded
    @POST(UPDATE_RATING_OPERATOR_TRAVEL)
    Call<DataResult<Lokasi>> updateRatingOperatorTravel(@Path("id") String id, @FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     */
    @FormUrlEncoded
    @POST(DELETE_RATING_OPERATOR_TRAVEL)
    Call<DataResult<Lokasi>> deleteRatingOperatorTravel(@Path("id") String id, @FieldMap Map<String, String> param);
}
