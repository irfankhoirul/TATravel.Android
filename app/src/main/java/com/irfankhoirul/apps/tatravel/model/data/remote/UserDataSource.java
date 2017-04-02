package com.irfankhoirul.apps.tatravel.model.data.remote;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;
import com.irfankhoirul.apps.tatravel.model.api.endpoint.IUserEndPoints;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class UserDataSource extends BaseRemoteDataSource {

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IUserEndPoints.class);
    }

    @SuppressWarnings("unchecked")
    public void registerWithPhoneNumber(final IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = ((IUserEndPoints) endPoint).register(param);
        call.enqueue(new Callback<DataResult>() {
            @Override
            public void onResponse(Call<DataResult> call, Response<DataResult> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<DataResult> call, Throwable t) {
                listener.onFailure(t);
            }
        });
    }

}
