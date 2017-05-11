package com.irfankhoirul.apps.tatravel.module.destination;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;

import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 12/24/2016.
 */

public interface DestinationContract {

    interface View extends IBaseView<Presenter> {
        void updateMap(List<Lokasi> locations);

        void redirectToSearchFragment();
    }

    interface Presenter extends IBasePresenter {
        void checkLocationAvailability(Map<String, String> params);

        List<Integer> getTravelLocationIds();
    }

}
