package com.irfankhoirul.apps.tatravel.modules.register;

import com.irfankhoirul.mvp_core.base.IBasePresenter;
import com.irfankhoirul.mvp_core.base.IBaseView;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface RegisterContract {
    interface View extends IBaseView<Presenter> {
        void redirectToVerification(String phone, String email);

        void redirectToProfile();
    }

    interface Presenter extends IBasePresenter {
        void register(Map<String, String> param);

        void handleSocialRegister(String email, String name, String firebaseInstanceId);
    }
}