package com.irfankhoirul.apps.tatravel.module.verification;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;

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
