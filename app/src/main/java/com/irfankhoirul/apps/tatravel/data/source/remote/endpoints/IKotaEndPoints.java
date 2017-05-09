package com.irfankhoirul.apps.tatravel.data.source.remote.endpoints;

import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.data.pojo.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.LIST_KOTA;

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
