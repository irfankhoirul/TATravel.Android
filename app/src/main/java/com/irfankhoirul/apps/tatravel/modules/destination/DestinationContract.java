package com.irfankhoirul.apps.tatravel.modules.destination;

import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;
import com.irfankhoirul.mvp_core.base.IBasePresenter;
import com.irfankhoirul.mvp_core.base.IBaseView;

import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 12/24/2016.
 */

public interface DestinationContract {

    interface View extends IBaseView<Presenter> {
        void updateMap(List<Lokasi> locations);
    }

    interface Presenter extends IBasePresenter {
        void checkLocationAvailability(Map<String, String> params);

        List<Integer> getTravelLocationIds();

        boolean isGotLocation();

        void setGotLocation(boolean gotLocation);
    }

}
