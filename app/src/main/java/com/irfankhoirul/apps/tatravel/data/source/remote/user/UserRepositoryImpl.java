package com.irfankhoirul.apps.tatravel.data.source.remote.user;

import com.irfankhoirul.apps.tatravel.data.pojo.Kota;
import com.irfankhoirul.apps.tatravel.data.pojo.Provinsi;
import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.mvp_core.base.BaseRemoteRepository;
import com.irfankhoirul.mvp_core.data.DataResult;
import com.irfankhoirul.mvp_core.data.IRequestResponseListener;

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
        endPoint = retrofit.create(UserEndPoints.class);
    }

    @Override
    public boolean enableLogging() {
        return true;
    }

    @Override
    public void register(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = ((UserEndPoints) endPoint).register(param);
        execute(call, listener);
    }

    @Override
    public void verify(IRequestResponseListener<User> listener, Map<String, String> param) {
        Call<DataResult<User>> call = ((UserEndPoints) endPoint).verify(param);
        execute(call, listener);
    }

    @Override
    public void login(IRequestResponseListener<User> listener, Map<String, String> param) {
        Call<DataResult<User>> call = ((UserEndPoints) endPoint).login(param);
        execute(call, listener);
    }

    @Override
    public void logout(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = ((UserEndPoints) endPoint).logout(param);
        execute(call, listener);
    }

    @Override
    public void updateFcmToken(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = ((UserEndPoints) endPoint).updateFcmToken(param);
        execute(call, listener);
    }

    @Override
    public void getListCity(IRequestResponseListener listener, int provinceId, Map<String, String> param) {
        Call<DataResult<Kota>> call = ((UserEndPoints) endPoint).listKota(provinceId, param);
        execute(call, listener);
    }

    @Override
    public void getListProvince(IRequestResponseListener listener, Map<String, String> param) {
        Call<DataResult<Provinsi>> call = ((UserEndPoints) endPoint).listProvinsi(param);
        execute(call, listener);
    }

    @Override
    public void updateProfile(IRequestResponseListener listener, int userId, Map<String, String> param) {
        Call<DataResult<User>> call = ((UserEndPoints) endPoint).updateProfile(userId, param);
        execute(call, listener);
    }

}
