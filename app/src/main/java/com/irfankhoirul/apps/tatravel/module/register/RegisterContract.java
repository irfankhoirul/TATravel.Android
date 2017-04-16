package com.irfankhoirul.apps.tatravel.module.register;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface RegisterContract {
    interface View extends IBaseView<Presenter> {
        void redirectToVerification();
    }

    interface Presenter extends IBasePresenter {
        void register(Map<String, String> param);
    }
}
