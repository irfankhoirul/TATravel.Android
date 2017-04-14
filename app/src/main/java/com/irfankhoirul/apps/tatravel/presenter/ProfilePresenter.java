package com.irfankhoirul.apps.tatravel.presenter;

import com.irfankhoirul.apps.tatravel.aaa.core.components.DataResult;
import com.irfankhoirul.apps.tatravel.aaa.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.contract.ProfileContract;
import com.irfankhoirul.apps.tatravel.model.data.remote.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.model.data.remote.UserDataSource;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class ProfilePresenter implements ProfileContract.Presenter {

    private final ProfileContract.View view;

    public ProfilePresenter(ProfileContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        // Do Nothing; Tidak ada yg perlu dilakukan otomatis
        view.showProfile();
    }

    @Override
    public void logout(Map<String, String> param) {
        view.setLoadingDialog(true, "Logout");
        UserDataSource dataSource = new UserDataSource();
        dataSource.logout(new IRequestResponseListener() {
            @Override
            public void onSuccess(DataResult result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    view.showStatus(ConstantUtils.STATUS_SUCCESS, result.getMessage());
                    view.redirectToLoginOrRegister();
                } else {
                    view.showStatus(ConstantUtils.STATUS_ERROR, result.getMessage());
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.setLoadingDialog(false, null);
                view.showStatus(ConstantUtils.STATUS_ERROR, "Gagal logout");
            }
        }, param);
    }
}
