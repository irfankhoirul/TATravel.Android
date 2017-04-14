package com.irfankhoirul.apps.tatravel.model.api.endpoint;

import com.irfankhoirul.apps.tatravel.aaa.core.components.DataResult;
import com.irfankhoirul.apps.tatravel.model.pojo.Lokasi;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.aaa.core.components.EndPoints.LIST_TERMINAL;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface ILokasiEndPoints {

    /**
     * Param
     *
     * @param param - token
     *              - cityId
     *              - page
     */
    @FormUrlEncoded
    @POST(LIST_TERMINAL)
    Call<DataResult<Lokasi>> listTerminal(@Path("id") String id, @FieldMap Map<String, String> param);

}
