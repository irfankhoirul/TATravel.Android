package com.irfankhoirul.apps.tatravel.module.user.login_or_register;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface LoginOrRegisterContract {
    interface View extends IBaseView<Presenter> {
        void notifyListenerLoginSuccess();

        void notifyListenerRegisterSuccess();
    }

    interface Presenter extends IBasePresenter {
        void handleActivityResult(int requestCode, int resultCode);
    }
}
