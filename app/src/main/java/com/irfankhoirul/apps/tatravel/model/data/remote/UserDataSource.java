package com.irfankhoirul.apps.tatravel.model.data.remote;

import com.irfankhoirul.apps.tatravel.model.api.DataResult;
import com.irfankhoirul.apps.tatravel.model.api.endpoint.IUserEndPoints;
import com.irfankhoirul.apps.tatravel.model.pojo.User;

import java.util.Map;

import retrofit2.Call;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class UserDataSource extends BaseRemoteDataSource {

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IUserEndPoints.class);
    }

    public void registerWithPhoneNumber(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = ((IUserEndPoints) endPoint).register(param);
        execute(call, listener);
    }

    public void verifyPhoneNumber(IRequestResponseListener<User> listener, Map<String, String> param) {
        Call<DataResult<User>> call = ((IUserEndPoints) endPoint).verify(param);
        execute(call, listener);
    }

    public void login(IRequestResponseListener<User> listener, Map<String, String> param) {
        Call<DataResult<User>> call = ((IUserEndPoints) endPoint).login(param);
        execute(call, listener);
    }

    public void logout(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = ((IUserEndPoints) endPoint).logout(param);
        execute(call, listener);
    }

}
