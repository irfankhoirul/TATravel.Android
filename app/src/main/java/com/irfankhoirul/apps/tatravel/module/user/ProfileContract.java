package com.irfankhoirul.apps.tatravel.module.user;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;
import com.irfankhoirul.apps.tatravel.data.pojo.User;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface ProfileContract {
    interface View extends IBaseView<Presenter> {
        void showProfile();

        void redirectToLoginOrRegister();
    }

    interface Presenter extends IBasePresenter {
        User getSessionData();

        void destroySession();

        void logout(Map<String, String> param);

        void handleActivityResult(int requestCode, int resultCode);
    }
}
