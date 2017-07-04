package com.irfankhoirul.apps.tatravel.modules.register;

import com.irfankhoirul.mvp_core.base.BasePresenter;
import com.irfankhoirul.mvp_core.base.BaseView;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface RegisterContract {
    interface View extends BaseView<Presenter> {
        void redirectToVerification(String phone, String email);

        void redirectToProfile();
    }

    interface Presenter extends BasePresenter {
        void register(Map<String, String> param);

        void handleSocialRegister(String email, String name, String firebaseInstanceId);
    }
}
