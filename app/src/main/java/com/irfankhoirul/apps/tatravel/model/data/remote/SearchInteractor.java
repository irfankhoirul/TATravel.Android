package com.irfankhoirul.apps.tatravel.model.data.remote;

import android.util.Log;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;
import com.irfankhoirul.apps.tatravel.model.api.IEndPoint;
import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.model.pojo.Kota;
import com.irfankhoirul.apps.tatravel.model.pojo.Lokasi;
import com.irfankhoirul.apps.tatravel.util.ConstantUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Merupakan interactor yang menghandle data JadwalPerjalanan
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public class SearchInteractor extends BaseRemoteDataSource {

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IEndPoint.class);
    }

    public void getJadwalPerjalanan(final IRequestResponseListener<List<JadwalPerjalanan>> listener) {
        Call<DataResult<JadwalPerjalanan>> call = ((IEndPoint) endPoint).search("2016-12-02");
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

    public void getLocation(final IRequestResponseWithPaginationListener<List<Lokasi>> listener, int page, int idKota) {
        Call<DataResult<Lokasi>> call = ((IEndPoint) endPoint).getTravelAgentLocationList(page, ConstantUtils.PAGINATION_LIMIT, idKota);
        call.enqueue(new Callback<DataResult<Lokasi>>() {
            @Override
            public void onResponse(Call<DataResult<Lokasi>> call, Response<DataResult<Lokasi>> response) {
                if (response.body() != null) {
                    Log.v("ResponseBodyNotNull", response.body().toString());
                    listener.onSuccess(response.body().getDataPageManager(), response.body().getDatas());
                } else {
                    Log.v("ResponseBodyNull", response.raw().toString());
                }
            }

            @Override
            public void onFailure(Call<DataResult<Lokasi>> call, Throwable t) {
                Log.v("FAILURE_MESSAGE", t.getMessage());
                listener.onFailure();
            }
        });
    }

    public void getCity(final IRequestResponseWithPaginationListener<List<Kota>> listener, int page) {
        Call<DataResult<Kota>> call = ((IEndPoint) endPoint).getCityList(page, ConstantUtils.PAGINATION_LIMIT);
        call.enqueue(new Callback<DataResult<Kota>>() {
            @Override
            public void onResponse(Call<DataResult<Kota>> call, Response<DataResult<Kota>> response) {
                if (response.body() != null) {
                    Log.v("ResponseBodyNotNull", response.body().toString());
                    listener.onSuccess(response.body().getDataPageManager(), response.body().getDatas());
                } else {
                    Log.v("ResponseBodyNull", response.raw().toString());
                }
            }

            @Override
            public void onFailure(Call<DataResult<Kota>> call, Throwable t) {
                Log.v("FAILURE_MESSAGE", t.getMessage());
                listener.onFailure();
            }
        });
    }

}
