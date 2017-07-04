package com.irfankhoirul.apps.tatravel.modules.login;

import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.mvp_core.base.BasePresenter;
import com.irfankhoirul.mvp_core.base.BaseView;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void redirectToProfile();
    }

    interface Presenter extends BasePresenter {
        void initializeSession(User user);

        void login(Map<String, String> params);

        void updateFcmToken(Map<String, String> param);

        void handleSocialLogin(String email, String firebaseInstanceId);
    }
}
