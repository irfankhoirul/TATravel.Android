package com.irfankhoirul.apps.tatravel.modules.auth_choice;

import com.irfankhoirul.mvp_core.base.IBasePresenter;
import com.irfankhoirul.mvp_core.base.IBaseView;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface AuthChoiceContract {
    interface View extends IBaseView<Presenter> {
        void notifyListenerLoginSuccess();

        void notifyListenerRegisterSuccess();
    }

    interface Presenter extends IBasePresenter {
        void handleActivityResult(int requestCode, int resultCode);
    }
}
