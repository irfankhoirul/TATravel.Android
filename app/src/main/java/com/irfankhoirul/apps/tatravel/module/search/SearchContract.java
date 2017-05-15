package com.irfankhoirul.apps.tatravel.module.search;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;

import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 11/15/2016.
 */

public interface SearchContract {

    /**
     * Merupakan interface yang menghubungkan SearchFragment dan SearchPresenter
     *
     * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
     * @version 1.0 (13 November 2016)
     * @since 1.0
     */
    interface View extends IBaseView<Presenter> {
        void showPromo();

        void setDepartureView(String departureLocation);

        void setDestinationView(String destinationLocation);

        void setPassengerView(List<Penumpang> selectedPassengers);

        void setDateView(long date);
    }

    interface Presenter extends IBasePresenter {
        void getPromo();

        boolean isLoggedIn();

        boolean isDepartureSet();

        void setDeparture(Map<String, String> departureDate);

        boolean isDestinationSet();

        void setDestination(Map<String, String> destinationData);

        void clearDestination();

        boolean isDateSet();

        void setDate(long date);

        void clearDate();

        boolean isPassengerSet();

        void setPassenger(List<Penumpang> passengers);

        void clearPassenger();

        String getSelectedOperatorTravelId();

    }

}
