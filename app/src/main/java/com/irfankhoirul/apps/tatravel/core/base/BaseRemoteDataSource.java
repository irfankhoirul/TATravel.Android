package com.irfankhoirul.apps.tatravel.core.base;

import android.util.Log;

import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils.BASE_API_URL;

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
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        setEndPoint();
    }

    public abstract void setEndPoint();

    @SuppressWarnings("unchecked")
    protected void execute(Call call, final IRequestResponseListener<T> listener) {
        Log.v("RequestUrl", call.request().url().toString());
        call.enqueue(new Callback<DataResult<T>>() {
            @Override
            public void onResponse(Call<DataResult<T>> call, Response<DataResult<T>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<DataResult<T>> call, Throwable t) {
                Log.v("Error", t.getMessage());
                listener.onFailure(t);
            }
        });
    }

}
