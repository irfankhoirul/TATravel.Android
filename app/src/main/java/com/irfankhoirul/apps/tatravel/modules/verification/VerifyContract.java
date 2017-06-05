package com.irfankhoirul.apps.tatravel.modules.verification;

import com.irfankhoirul.mvp_core.base.IBasePresenter;
import com.irfankhoirul.mvp_core.base.IBaseView;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/8/2017.
 */

public interface VerifyContract {
    interface View extends IBaseView<Presenter> {
        void redirectToProfile();
    }

    interface Presenter extends IBasePresenter {
        void verifyUser(Map<String, String> param);
    }
}
