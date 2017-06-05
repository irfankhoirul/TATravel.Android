package com.irfankhoirul.apps.tatravel.modules.travel_choice;

import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;
import com.irfankhoirul.apps.tatravel.data.pojo.OperatorTravel;
import com.irfankhoirul.mvp_core.base.IBasePresenter;
import com.irfankhoirul.mvp_core.base.IBaseView;

import java.util.List;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public interface TravelChoiceDialogContract {
    interface View extends IBaseView<Presenter> {

    }

    interface Presenter extends IBasePresenter {
        List<OperatorTravel> prepareData(List<Lokasi> lokasiList);
    }
}
