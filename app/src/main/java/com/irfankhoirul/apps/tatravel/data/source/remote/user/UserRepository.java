package com.irfankhoirul.apps.tatravel.data.source.remote.user;

import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.mvp_core.data.RequestResponseListener;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 5/9/2017.
 */

public interface UserRepository {

    void register(RequestResponseListener listener, Map<String, String> param);

    void verify(RequestResponseListener<User> listener, Map<String, String> param);

    void login(RequestResponseListener<User> listener, Map<String, String> param);

    void logout(RequestResponseListener listener, Map<String, String> param);

    void updateFcmToken(RequestResponseListener listener, Map<String, String> param);

    void getListCity(RequestResponseListener listener, int provinceId, Map<String, String> param);

    void getListProvince(RequestResponseListener listener, Map<String, String> param);

    void updateProfile(RequestResponseListener listener, int userId, Map<String, String> param);
}
