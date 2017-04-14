package com.irfankhoirul.apps.tatravel.model.api.endpoint;

import com.irfankhoirul.apps.tatravel.aaa.core.components.DataResult;
import com.irfankhoirul.apps.tatravel.model.pojo.KursiPerjalanan;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.aaa.core.components.EndPoints.DO_BOOK_SEAT;
import static com.irfankhoirul.apps.tatravel.aaa.core.components.EndPoints.LIST_SEAT;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IKursiPerjalananEndPoints {

    /**
     * Param
     *
     * @param param - token
     */
    @FormUrlEncoded
    @POST(LIST_SEAT)
    Call<DataResult<KursiPerjalanan>> listKursiPerjalanan(@Path("id") String id, @FieldMap Map<String, String> param);

    /**
     * Param
     *
     * @param param - token
     */
    @FormUrlEncoded
    @POST(DO_BOOK_SEAT)
    Call<DataResult> bookKursiPerjalanan(@Path("id") String id, @FieldMap Map<String, String> param);

}
