package com.irfankhoirul.apps.tatravel.module.departure;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;
import com.irfankhoirul.apps.tatravel.core.data.DataPage;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;

import java.util.List;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public interface TravelLocationDialogContract {
    interface View extends IBaseView {
        void updateTravelLocationList(DataPage dataPageManager, List<Lokasi> data);

        void setProgressBarVisibility(boolean visible);
    }

    interface Presenter extends IBasePresenter {
        void getTravelLocationData(int page, int idKota);
    }
}
