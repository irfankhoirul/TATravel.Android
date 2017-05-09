package com.irfankhoirul.apps.tatravel.module.departure;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;
import com.irfankhoirul.apps.tatravel.data.pojo.OperatorTravel;

import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 12/24/2016.
 */

public interface DepartureContract {

    interface View extends IBaseView<Presenter> {
        void updateMap(List<Lokasi> locations);

        void redirectToSearchFragment();
    }

    interface Presenter extends IBasePresenter {
        void checkLocationAvailability(Map<String, String> params);

        List<OperatorTravel> prepareOperatorTraveldata(List<Lokasi> lokasiList);
    }

}