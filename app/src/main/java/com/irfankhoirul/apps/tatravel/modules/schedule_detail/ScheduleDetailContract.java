package com.irfankhoirul.apps.tatravel.modules.schedule_detail;

import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;
import com.irfankhoirul.mvp_core.base.IBasePresenter;
import com.irfankhoirul.mvp_core.base.IBaseView;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public interface ScheduleDetailContract {
    interface View extends IBaseView<Presenter> {

    }

    interface Presenter extends IBasePresenter {
        JadwalPerjalanan getSchedule();

        void setSchedule(JadwalPerjalanan schedule);
    }
}
