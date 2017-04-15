package com.irfankhoirul.apps.tatravel.data.endpoints;

import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.data.EndPoints.LIST_TERMINAL;

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
