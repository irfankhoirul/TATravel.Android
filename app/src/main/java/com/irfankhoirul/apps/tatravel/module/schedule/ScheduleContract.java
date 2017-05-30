package com.irfankhoirul.apps.tatravel.module.schedule;

import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;
import com.irfankhoirul.mvp_core.base.IBasePresenter;
import com.irfankhoirul.mvp_core.base.IBaseView;
import com.irfankhoirul.mvp_core.data.DataPage;

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

        void finishActivity(int resultCode);
    }

    interface Presenter extends IBasePresenter {
        void searchSchedules(Map<String, String> params);

        void handleOnActivityResult(int requestCode, int resultCode);

        List<JadwalPerjalanan> getSchedules();
    }
}
