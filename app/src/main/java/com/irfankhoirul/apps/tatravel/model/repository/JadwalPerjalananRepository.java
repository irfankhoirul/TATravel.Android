package com.irfankhoirul.apps.tatravel.model.repository;

import android.util.Log;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;
import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;

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
        Call<DataResult<JadwalPerjalanan>> call = endPoint.search();
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

}
