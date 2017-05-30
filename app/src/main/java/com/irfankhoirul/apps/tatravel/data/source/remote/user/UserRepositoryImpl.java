package com.irfankhoirul.apps.tatravel.data.source.remote.user;

import com.irfankhoirul.apps.tatravel.core.base.BaseRemoteRepository;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.Kota;
import com.irfankhoirul.apps.tatravel.data.pojo.Provinsi;
import com.irfankhoirul.apps.tatravel.data.pojo.User;

import java.util.Map;

import retrofit2.Call;

import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.BASE_API_URL;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class UserRepositoryImpl extends BaseRemoteRepository implements UserRepository {

    @Override
    public String setBaseUrl() {
        return BASE_API_URL;
    }

    @Override
    public void setEndPoint() {
        endPoint = retrofit.create(IUserEndPoints.class);
    }

    @Override
    public boolean enableLogging() {
        return true;
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

    @Override
    public void getListCity(IRequestResponseListener listener, int provinceId, Map<String, String> param) {
        Call<DataResult<Kota>> call = ((IUserEndPoints) endPoint).listKota(provinceId, param);
        execute(call, listener);
    }

    @Override
    public void getListProvince(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult<Provinsi>> call = ((IUserEndPoints) endPoint).listProvinsi(param);
        execute(call, listener);
    }

    @Override
    public void updateProfile(IRequestResponseListener listener, int userId, Map<String, String> param) {
        Call<DataResult<User>> call = ((IUserEndPoints) endPoint).updateProfile(userId, param);
        execute(call, listener);
    }

}
