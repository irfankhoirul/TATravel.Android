package com.irfankhoirul.apps.tatravel.model.repository;

import android.util.Log;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;
import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.model.pojo.Lokasi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Merupakan repository yang menghandle data JadwalPerjalanan
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public class JadwalPerjalananRepository extends BaseRepository {

    public void getJadwalPerjalanan(final IRequestResponseListener<List<JadwalPerjalanan>> listener) {
        Call<DataResult<JadwalPerjalanan>> call = endPoint.search("2016-12-02");
        call.enqueue(new Callback<DataResult<JadwalPerjalanan>>() {
            @Override
            public void onResponse(Call<DataResult<JadwalPerjalanan>> call, Response<DataResult<JadwalPerjalanan>> response) {
                listener.onSuccess(response.body().getDatas());
            }

            @Override
            public void onFailure(Call<DataResult<JadwalPerjalanan>> call, Throwable t) {
                Log.v("Retrofit", "onFailure -> " + t.getMessage());
                listener.onFailure();
            }
        });
    }

    public void getLocation(final IRequestResponseListener<List<Lokasi>> listener) {
        Call<DataResult<Lokasi>> call = endPoint.getLocation();
        call.enqueue(new Callback<DataResult<Lokasi>>() {
            @Override
            public void onResponse(Call<DataResult<Lokasi>> call, Response<DataResult<Lokasi>> response) {
                listener.onSuccess(response.body().getDatas());
            }

            @Override
            public void onFailure(Call<DataResult<Lokasi>> call, Throwable t) {
                listener.onFailure();
            }
        });
    }

}
