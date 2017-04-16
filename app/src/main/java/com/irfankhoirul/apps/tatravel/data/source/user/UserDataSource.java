package com.irfankhoirul.apps.tatravel.data.source.user;

import com.irfankhoirul.apps.tatravel.core.base.BaseRemoteDataSource;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.endpoints.IUserEndPoints;
import com.irfankhoirul.apps.tatravel.data.pojo.User;

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
