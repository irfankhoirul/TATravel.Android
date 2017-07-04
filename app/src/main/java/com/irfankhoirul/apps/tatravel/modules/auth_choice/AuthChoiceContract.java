package com.irfankhoirul.apps.tatravel.modules.auth_choice;

import com.irfankhoirul.mvp_core.base.BasePresenter;
import com.irfankhoirul.mvp_core.base.BaseView;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface AuthChoiceContract {
    interface View extends BaseView<Presenter> {
        void notifyListenerLoginSuccess();

        void notifyListenerRegisterSuccess();
    }

    interface Presenter extends BasePresenter {
        void handleActivityResult(int requestCode, int resultCode);
    }
}
