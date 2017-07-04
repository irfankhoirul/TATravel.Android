package com.irfankhoirul.apps.tatravel.modules.departure;

import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;
import com.irfankhoirul.apps.tatravel.data.pojo.OperatorTravel;
import com.irfankhoirul.mvp_core.base.BasePresenter;
import com.irfankhoirul.mvp_core.base.BaseView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 12/24/2016.
 */

public interface DepartureContract {

    interface View extends BaseView<Presenter> {
        void updateMap(ArrayList<Lokasi> locations);
    }

    interface Presenter extends BasePresenter {
        void checkLocationAvailability(Map<String, String> params);

        List<OperatorTravel> prepareOperatorTraveldata(List<Lokasi> lokasiList);

        boolean isGotLocation();

        void setGotLocation(boolean gotLocation);

        ArrayList<Lokasi> getLocationList();

        void setLocationList(ArrayList<Lokasi> locationList);
    }

}
