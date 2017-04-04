package com.irfankhoirul.apps.tatravel.model.api.endpoint;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;
import com.irfankhoirul.apps.tatravel.model.pojo.Pemesanan;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.model.api.endpoint.EndPoints.DO_RESERVATION;
import static com.irfankhoirul.apps.tatravel.model.api.endpoint.EndPoints.GET_RESERVATION;
import static com.irfankhoirul.apps.tatravel.model.api.endpoint.EndPoints.LIST_RESERVATION;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IPemesananEndPoints {

    /**
     * Param
     *
     * @param param - token
     *              - idJadwalPerjalanan
     */
    @FormUrlEncoded
    @POST(DO_RESERVATION)
    Call<DataResult> reservasi(@FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     *              - idJadwalPerjalanan
     */
    @FormUrlEncoded
    @POST(GET_RESERVATION)
    Call<DataResult<Pemesanan>> getReservasi(@Path("id") String id, @FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     *              - cityId
     *              - page
     */
    @FormUrlEncoded
    @POST(LIST_RESERVATION)
    Call<DataResult<Pemesanan>> listReservasi(@FieldMap Map<String, String> param);

}
