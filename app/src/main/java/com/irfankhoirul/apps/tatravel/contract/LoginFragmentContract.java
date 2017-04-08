package com.irfankhoirul.apps.tatravel.contract;

import com.irfankhoirul.apps.tatravel.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.base.IBaseView;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface LoginFragmentContract {
    interface View extends IBaseView {

    }

    interface Presenter extends IBasePresenter {
        void login();
    }
}
