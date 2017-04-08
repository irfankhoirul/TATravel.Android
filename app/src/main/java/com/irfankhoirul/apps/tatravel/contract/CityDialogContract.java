package com.irfankhoirul.apps.tatravel.contract;

import com.irfankhoirul.apps.tatravel.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.base.IBaseView;
import com.irfankhoirul.apps.tatravel.model.api.DataPage;
import com.irfankhoirul.apps.tatravel.model.pojo.Kota;

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
