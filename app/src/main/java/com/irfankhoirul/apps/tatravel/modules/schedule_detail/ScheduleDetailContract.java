package com.irfankhoirul.apps.tatravel.modules.schedule_detail;

import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;
import com.irfankhoirul.mvp_core.base.BasePresenter;
import com.irfankhoirul.mvp_core.base.BaseView;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public interface ScheduleDetailContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        JadwalPerjalanan getSchedule();

        void setSchedule(JadwalPerjalanan schedule);
    }
}
