package com.irfankhoirul.apps.tatravel.data.source.remote.user;

import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.mvp_core.data.IRequestResponseListener;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 5/9/2017.
 */

public interface UserRepository {

    void register(IRequestResponseListener listener, Map<String, String> param);

    void verify(IRequestResponseListener<User> listener, Map<String, String> param);

    void login(IRequestResponseListener<User> listener, Map<String, String> param);

    void logout(IRequestResponseListener listener, Map<String, String> param);

    void updateFcmToken(IRequestResponseListener listener, Map<String, String> param);

    void getListCity(IRequestResponseListener listener, int provinceId, Map<String, String> param);

    void getListProvince(IRequestResponseListener listener, Map<String, String> param);

    void updateProfile(IRequestResponseListener listener, int provinceId, Map<String, String> param);
}
