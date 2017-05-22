package com.irfankhoirul.apps.tatravel.module.schedule_detail;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;
import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public interface ScheduleDetailDialogContract {
    interface View extends IBaseView<Presenter> {

    }

    interface Presenter extends IBasePresenter {
        JadwalPerjalanan getSchedule();

        void setSchedule(JadwalPerjalanan schedule);
    }
}
