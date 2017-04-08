package com.irfankhoirul.apps.tatravel.contract;

import com.irfankhoirul.apps.tatravel.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.base.IBaseView;
import com.irfankhoirul.apps.tatravel.model.pojo.User;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/8/2017.
 */

public interface VerifyContract {
    interface View extends IBaseView {
        void redirectToProfile(User user);
    }

    interface Presenter extends IBasePresenter {
        void verify(Map<String, String> param);
    }
}
