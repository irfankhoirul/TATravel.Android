package com.irfankhoirul.apps.tatravel.data.source.remote.user;

import com.irfankhoirul.apps.tatravel.core.base.BaseRemoteDataSource;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.User;

import java.util.Map;

import retrofit2.Call;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class UserRepositoryImpl extends BaseRemoteDataSource implements UserRepository {

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IUserEndPoints.class);
    }

    @Override
    public void register(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = ((IUserEndPoints) endPoint).register(param);
        execute(call, listener);
    }

    @Override
    public void verify(IRequestResponseListener<User> listener, Map<String, String> param) {
        Call<DataResult<User>> call = ((IUserEndPoints) endPoint).verify(param);
        execute(call, listener);
    }

    @Override
    public void login(IRequestResponseListener<User> listener, Map<String, String> param) {
        Call<DataResult<User>> call = ((IUserEndPoints) endPoint).login(param);
        execute(call, listener);
    }

    @Override
    public void logout(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = ((IUserEndPoints) endPoint).logout(param);
        execute(call, listener);
    }

    @Override
    public void updateFcmToken(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = ((IUserEndPoints) endPoint).updateFcmToken(param);
        execute(call, listener);
    }

}
