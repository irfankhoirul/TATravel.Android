package com.irfankhoirul.apps.tatravel.module.login;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;
import com.irfankhoirul.apps.tatravel.data.pojo.User;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface LoginContract {
    interface View extends IBaseView<Presenter> {
        Map<String, String> setFcmTokenData(User user);

        void redirectToProfile();
    }

    interface Presenter extends IBasePresenter {
        void login(Map<String, String> params);

        void updateFcmToken(Map<String, String> param);
    }
}
