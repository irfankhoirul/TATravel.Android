package com.irfankhoirul.apps.tatravel.modules.profile;

import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.mvp_core.base.IBasePresenter;
import com.irfankhoirul.mvp_core.base.IBaseView;

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
