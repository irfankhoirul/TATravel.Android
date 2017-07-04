package com.irfankhoirul.apps.tatravel.modules.destination;

import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;
import com.irfankhoirul.mvp_core.base.BasePresenter;
import com.irfankhoirul.mvp_core.base.BaseView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 12/24/2016.
 */

public interface DestinationContract {

    interface View extends BaseView<Presenter> {
        void updateMap(List<Lokasi> locations);
    }

    interface Presenter extends BasePresenter {
        void checkLocationAvailability(Map<String, String> params);

        ArrayList<Integer> getTravelLocationIds();

        boolean isGotLocation();

        void setGotLocation(boolean gotLocation);
    }

}
