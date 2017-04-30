package com.irfankhoirul.apps.tatravel.module.departure;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;

/**
 * Created by Irfan Khoirul on 12/24/2016.
 */

public interface DepartureContract {

    interface View extends IBaseView<Presenter> {
        void redirectToSearchFragment();
    }

    interface Presenter extends IBasePresenter {
        void checkLocationAvailability();
    }

}
