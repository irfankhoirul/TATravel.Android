package com.irfankhoirul.apps.tatravel.data.source.remote.user;

import com.irfankhoirul.apps.tatravel.data.pojo.Kota;
import com.irfankhoirul.apps.tatravel.data.pojo.Provinsi;
import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.mvp_core.base.BaseRemoteRepository;
import com.irfankhoirul.mvp_core.data.DataResult;
import com.irfankhoirul.mvp_core.data.RequestResponseListener;

import java.util.Map;

import retrofit2.Call;

import static com.irfankhoirul.apps.tatravel.data.source.remote.EndPoints.BASE_API_URL;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class UserRepositoryImpl extends BaseRemoteRepository<UserEndPoints> implements UserRepository {

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
    public void register(RequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = endPoint.register(param);
        execute(call, listener);
    }

    @Override
    public void verify(RequestResponseListener<User> listener, Map<String, String> param) {
        Call<DataResult<User>> call = endPoint.verify(param);
        execute(call, listener);
    }

    @Override
    public void login(RequestResponseListener<User> listener, Map<String, String> param) {
        Call<DataResult<User>> call = endPoint.login(param);
        execute(call, listener);
    }

    @Override
    public void logout(RequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = endPoint.logout(param);
        execute(call, listener);
    }

    @Override
    public void updateFcmToken(RequestResponseListener listener, Map<String, String> param) {
        Call<DataResult> call = endPoint.updateFcmToken(param);
        execute(call, listener);
    }

    @Override
    public void getListCity(RequestResponseListener listener, int provinceId, Map<String, String> param) {
        Call<DataResult<Kota>> call = endPoint.listKota(provinceId, param);
        execute(call, listener);
    }

    @Override
    public void getListProvince(RequestResponseListener listener, Map<String, String> param) {
        Call<DataResult<Provinsi>> call = endPoint.listProvinsi(param);
        execute(call, listener);
    }

    @Override
    public void updateProfile(RequestResponseListener listener, int userId, Map<String, String> param) {
        Call<DataResult<User>> call = endPoint.updateProfile(userId, param);
        execute(call, listener);
    }

}
