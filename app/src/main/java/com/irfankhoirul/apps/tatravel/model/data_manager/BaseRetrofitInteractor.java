package com.irfankhoirul.apps.tatravel.model.data_manager;

import com.irfankhoirul.apps.tatravel.model.api.IEndPoint;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.irfankhoirul.apps.tatravel.util.ConstantUtils.BASE_API_URL;

/**
 * Interactor merupakan bagian dari data layer yang berfungsi untuk fetching data
 * (database, cache, web service, dsb).
 * BaseRetrofitInteractor merupakan super class dari interactor yang digunakan untuk
 * fetching data dari web service menggunakan library Retrofit
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public class BaseRetrofitInteractor {

    protected Retrofit retrofit;
    protected IEndPoint endPoint;

    protected BaseRetrofitInteractor() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        endPoint = retrofit.create(IEndPoint.class);
    }
}
