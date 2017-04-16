package com.irfankhoirul.apps.tatravel.module.verification;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;
import com.irfankhoirul.apps.tatravel.data.pojo.User;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/8/2017.
 */

public interface VerifyContract {
    interface View extends IBaseView<Presenter> {
        void redirectToProfile(User user);
    }

    interface Presenter extends IBasePresenter {
        void verify(Map<String, String> param);
    }
}
