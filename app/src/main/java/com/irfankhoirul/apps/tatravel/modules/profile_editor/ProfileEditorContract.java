package com.irfankhoirul.apps.tatravel.modules.profile_editor;

import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.mvp_core.base.BasePresenter;
import com.irfankhoirul.mvp_core.base.BaseView;

import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public interface ProfileEditorContract {
    interface View extends BaseView<Presenter> {
        void showCurrentData(User user);

        void updateProvinceList(List<String> provinceNameList);

        void updateCityList(List<String> cityNameList);

        boolean isActive();

        void finishActivity();
    }

    interface Presenter extends BasePresenter {
        void getCityList(String provinceName);

        void updateUser(Map<String, String> params);
    }
}
