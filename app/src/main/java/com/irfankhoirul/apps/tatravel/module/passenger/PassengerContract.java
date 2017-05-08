package com.irfankhoirul.apps.tatravel.module.passenger;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface PassengerContract {
    interface View extends IBaseView<Presenter> {

    }

    interface Presenter extends IBasePresenter {
        void createPassenger(String userId, Map<String, String> param);

        void updatePassenger(String userId, String idPenumpang, Map<String, String> param);

        void deletePassenger(String userId, String idPenumpang);

        void listPassenger(String userId, Map<String, String> param);
    }
}
