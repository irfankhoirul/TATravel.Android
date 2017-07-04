package com.irfankhoirul.apps.tatravel.modules.travel_choice;

import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;
import com.irfankhoirul.apps.tatravel.data.pojo.OperatorTravel;
import com.irfankhoirul.mvp_core.base.BasePresenter;
import com.irfankhoirul.mvp_core.base.BaseView;

import java.util.List;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public interface TravelChoiceContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        List<OperatorTravel> prepareData(List<Lokasi> lokasiList);
    }
}
