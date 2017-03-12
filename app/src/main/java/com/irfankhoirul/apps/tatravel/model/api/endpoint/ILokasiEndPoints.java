package com.irfankhoirul.apps.tatravel.model.api.endpoint;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;
import com.irfankhoirul.apps.tatravel.model.pojo.Lokasi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.irfankhoirul.apps.tatravel.model.api.endpoint.EndPoints.LIST_TERMINAL;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface ILokasiEndPoints {

    @FormUrlEncoded
    @POST(LIST_TERMINAL)
    Call<DataResult<Lokasi>> listTerminal(
            @Path("id") String id,
            @Field("token") String token,
            @Field("cityId") String cityId,
            @Field("page") String page
    );

}
