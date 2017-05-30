package com.irfankhoirul.apps.tatravel.module.profile_editor;

import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.mvp_core.base.IBasePresenter;
import com.irfankhoirul.mvp_core.base.IBaseView;

import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface EditProfileContract {
    interface View extends IBaseView<Presenter> {
        void showCurrentData(User user);

        void updateProvinceList(List<String> provinceNameList);

        void updateCityList(List<String> cityNameList);

        boolean isActive();

        void finishActivity();
    }

    interface Presenter extends IBasePresenter {
        void getCityList(String provinceName);

        void updateUser(Map<String, String> params);
    }
}
