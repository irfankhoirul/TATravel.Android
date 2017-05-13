package com.irfankhoirul.apps.tatravel.module.schedule;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;
import com.irfankhoirul.apps.tatravel.core.data.DataPage;
import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;

import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface ScheduleContract {
    interface View extends IBaseView<Presenter> {
        void updateScheduleList(List<JadwalPerjalanan> passengers, DataPage dataPage, Map<String, String> params);

        void showDataNotExist();

        void showDataExist();
    }

    interface Presenter extends IBasePresenter {
        void searchSchedules(Map<String, String> params);
    }
}