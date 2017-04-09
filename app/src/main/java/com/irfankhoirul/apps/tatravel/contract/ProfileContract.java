package com.irfankhoirul.apps.tatravel.contract;

import com.irfankhoirul.apps.tatravel.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.base.IBaseView;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface ProfileContract {
    interface View extends IBaseView {
        void showProfile();

        void redirectToLoginOrRegister();
    }

    interface Presenter extends IBasePresenter {
        void logout(Map<String, String> param);
    }
}
