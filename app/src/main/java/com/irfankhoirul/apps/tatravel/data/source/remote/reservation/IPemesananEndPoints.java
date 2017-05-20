package com.irfankhoirul.apps.tatravel.data.source.remote.reservation;

import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.DO_RESERVATION;
import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.GET_RESERVATION;
import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.LIST_RESERVATION;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IPemesananEndPoints {

    /**
     * Param
     *
     * @param param - token
     *              - idJadwalPerjalanan
     *              - passengerIds
     *              - seatIds
     *              - pickUpLat
     *              - pickUpLon
     *              - takeLat
     *              - takeLon
     */
    @FormUrlEncoded
    @POST(DO_RESERVATION)
    Call<DataResult<Pemesanan>> reservasi(@FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     *              - idJadwalPerjalanan
     */
    @FormUrlEncoded
    @POST(GET_RESERVATION)
    Call<DataResult<Pemesanan>> getReservasi(@Path("id") int id, @FieldMap Map<String, String> param);

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
