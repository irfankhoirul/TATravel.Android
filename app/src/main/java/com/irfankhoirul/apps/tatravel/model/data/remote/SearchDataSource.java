package com.irfankhoirul.apps.tatravel.model.data.remote;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;
import com.irfankhoirul.apps.tatravel.model.api.IEndPoint;
import com.irfankhoirul.apps.tatravel.model.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.model.pojo.Kota;
import com.irfankhoirul.apps.tatravel.model.pojo.Lokasi;
import com.irfankhoirul.apps.tatravel.util.ConstantUtils;

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

public class SearchDataSource extends BaseRemoteDataSource {

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IEndPoint.class);
    }

    public void getJadwalPerjalanan(final IRequestResponseListener<JadwalPerjalanan> listener) {
        Call<DataResult<JadwalPerjalanan>> call = ((IEndPoint) endPoint).search("2016-12-02");
        call.enqueue(new Callback<DataResult<JadwalPerjalanan>>() {
            @Override
            public void onResponse(Call<DataResult<JadwalPerjalanan>> call, Response<DataResult<JadwalPerjalanan>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<DataResult<JadwalPerjalanan>> call, Throwable t) {
                listener.onFailure(t);
            }
        });
    }

    public void getLocation(final IRequestResponseListener<Lokasi> listener, int page, int idKota) {
        Call<DataResult<Lokasi>> call = ((IEndPoint) endPoint).getTravelAgentLocationList(page, ConstantUtils.PAGINATION_LIMIT, idKota);
        call.enqueue(new Callback<DataResult<Lokasi>>() {
            @Override
            public void onResponse(Call<DataResult<Lokasi>> call, Response<DataResult<Lokasi>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<DataResult<Lokasi>> call, Throwable t) {
                listener.onFailure(t);
            }
        });
    }

    public void getCity(final IRequestResponseListener<Kota> listener, int page) {
        Call<DataResult<Kota>> call = ((IEndPoint) endPoint).getCityList(page, ConstantUtils.PAGINATION_LIMIT);
        call.enqueue(new Callback<DataResult<Kota>>() {
            @Override
            public void onResponse(Call<DataResult<Kota>> call, Response<DataResult<Kota>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<DataResult<Kota>> call, Throwable t) {
                listener.onFailure(t);
            }
        });
    }

}
