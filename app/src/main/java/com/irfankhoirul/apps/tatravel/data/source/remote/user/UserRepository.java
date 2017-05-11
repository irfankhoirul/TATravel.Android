package com.irfankhoirul.apps.tatravel.data.source.remote.user;

import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.User;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 5/9/2017.
 */

public interface UserRepository {

    void registerWithPhoneNumber(IRequestResponseListener listener, Map<String, String> param);

    void verifyPhoneNumber(IRequestResponseListener<User> listener, Map<String, String> param);

    void login(IRequestResponseListener<User> listener, Map<String, String> param);

    void logout(IRequestResponseListener listener, Map<String, String> param);

    void updateFcmToken(IRequestResponseListener listener, Map<String, String> param);

}
