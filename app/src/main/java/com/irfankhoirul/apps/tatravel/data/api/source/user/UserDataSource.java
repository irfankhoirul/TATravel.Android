package com.irfankhoirul.apps.tatravel.data.api.source.user;

import com.irfankhoirul.apps.tatravel.core.base.BaseRemoteDataSource;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.User;

import java.util.Map;

import retrofit2.Call;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class UserDataSource extends BaseRemoteDataSource {

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IUserUseCase.class);
    }

    public void registerWithPhoneNumber(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = ((IUserUseCase) endPoint).register(param);
        execute(call, listener);
    }

    public void verifyPhoneNumber(IRequestResponseListener<User> listener, Map<String, String> param) {
        Call<DataResult<User>> call = ((IUserUseCase) endPoint).verify(param);
        execute(call, listener);
    }

    public void login(IRequestResponseListener<User> listener, Map<String, String> param) {
        Call<DataResult<User>> call = ((IUserUseCase) endPoint).login(param);
        execute(call, listener);
    }

    public void logout(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = ((IUserUseCase) endPoint).logout(param);
        execute(call, listener);
    }

    public void updateFcmToken(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = ((IUserUseCase) endPoint).updateFcmToken(param);
        execute(call, listener);
    }

}
