package com.irfankhoirul.apps.tatravel.model.api.endpoint;

import com.irfankhoirul.apps.tatravel.aaa.core.components.DataResult;
import com.irfankhoirul.apps.tatravel.model.pojo.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import static com.irfankhoirul.apps.tatravel.aaa.core.components.EndPoints.LIST_KOTA;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface IKotaEndPoints {

    /**
     * Param
     *
     * @param param - token
     *              - page
     */
    @FormUrlEncoded
    @POST(LIST_KOTA)
    Call<DataResult<User>> listKota(@FieldMap Map<String, String> param);

}
