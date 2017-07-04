package com.irfankhoirul.apps.tatravel.modules.verification;

import com.irfankhoirul.mvp_core.base.BasePresenter;
import com.irfankhoirul.mvp_core.base.BaseView;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/8/2017.
 */

public interface VerifyContract {
    interface View extends BaseView<Presenter> {
        void redirectToProfile();
    }

    interface Presenter extends BasePresenter {
        void verifyUser(Map<String, String> param);
    }
}
