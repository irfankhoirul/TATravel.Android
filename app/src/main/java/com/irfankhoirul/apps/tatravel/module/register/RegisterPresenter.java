package com.irfankhoirul.apps.tatravel.module.register;

import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.source.user.UserDataSource;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class RegisterPresenter implements RegisterContract.Presenter {

    private final RegisterContract.View view;
    private final UserDataSource userDataSource;

    @Inject
    public RegisterPresenter(UserDataSource userDataSource, RegisterContract.View view) {
        this.view = view;
        this.userDataSource = userDataSource;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {
        // Do Nothing; Tidak ada yg perlu dilakukan otomatis
    }

    @Override
    public void register(Map<String, String> param) {
        view.setLoadingDialog(true, "Sedang melakukan registrasi");
        userDataSource.registerWithPhoneNumber(new IRequestResponseListener() {
            @Override
            public void onSuccess(DataResult result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    view.showStatus(ConstantUtils.STATUS_SUCCESS, result.getMessage());
                    view.redirectToVerification();
                } else {
                    view.showStatus(ConstantUtils.STATUS_ERROR, result.getMessage());
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.setLoadingDialog(false, null);
                view.showStatus(ConstantUtils.STATUS_ERROR, "Gagal melakukan registrasi");
            }
        }, param);
    }
}
