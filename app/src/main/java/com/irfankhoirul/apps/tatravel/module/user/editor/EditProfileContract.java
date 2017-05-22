package com.irfankhoirul.apps.tatravel.module.user.editor;

import com.irfankhoirul.apps.tatravel.core.base.IBasePresenter;
import com.irfankhoirul.apps.tatravel.core.base.IBaseView;
import com.irfankhoirul.apps.tatravel.data.pojo.User;

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
