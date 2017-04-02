package com.irfankhoirul.apps.tatravel.contract;

import com.irfankhoirul.apps.tatravel.base.IBasePresenter;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public interface RegisterContract {
    interface View {
        void showStatus(int type, String message);

        void redirectToProfile();
    }

    interface Presenter extends IBasePresenter {
        void register(Map<String, String> param);
    }
}
