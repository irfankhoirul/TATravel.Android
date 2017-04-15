package com.irfankhoirul.apps.tatravel.module.departure;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;
import com.irfankhoirul.apps.tatravel.core.data.DataPage;
import com.irfankhoirul.apps.tatravel.data.pojo.Kota;

import java.util.List;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public interface CityDialogContract {
    interface View extends IBaseView {
        void updateCityList(DataPage dataPageManager, List<Kota> data);

        void setProgressBarVisibility(boolean visible);
    }

    interface Presenter extends IBasePresenter {
        void getCityData(int page);
    }
}
