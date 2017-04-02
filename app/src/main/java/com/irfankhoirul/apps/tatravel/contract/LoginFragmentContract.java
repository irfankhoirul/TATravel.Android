package com.irfankhoirul.apps.tatravel.contract;

import com.irfankhoirul.apps.tatravel.base.IBasePresenter;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface LoginFragmentContract {
    interface View {

    }

    interface Presenter extends IBasePresenter {
        void login();
    }
}
