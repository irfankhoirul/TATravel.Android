package com.irfankhoirul.apps.tatravel.model.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.irfankhoirul.apps.tatravel.util.ConstantUtils.BASE_API_URL;

/**
 * Interactor merupakan bagian dari data layer yang berfungsi untuk fetching data
 * (database, cache, web service, dsb).
 * BaseRemoteDataSource merupakan super class dari interactor yang digunakan untuk
 * fetching data dari web service menggunakan library Retrofit
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public abstract class BaseRemoteDataSource<T> {

    protected Retrofit retrofit;
    protected T endPoint;

    protected BaseRemoteDataSource() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        setEndPoint();
    }

    public abstract void setEndPoint();
}
