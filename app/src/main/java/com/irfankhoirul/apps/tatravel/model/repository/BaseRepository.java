package com.irfankhoirul.apps.tatravel.model.repository;

import com.irfankhoirul.apps.tatravel.model.api.IEndPoint;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.irfankhoirul.apps.tatravel.util.ConstantUtil.BASE_API_URL;

/**
 * Merupakan super class dari setiap repository
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public class BaseRepository {

    protected Retrofit retrofit;
    protected IEndPoint endPoint;

    protected BaseRepository() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        endPoint = retrofit.create(IEndPoint.class);
    }
}
