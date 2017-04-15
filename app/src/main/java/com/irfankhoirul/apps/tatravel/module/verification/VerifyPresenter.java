package com.irfankhoirul.apps.tatravel.module.verification;

import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.apps.tatravel.data.source.UserDataSource;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class VerifyPresenter implements VerifyContract.Presenter {

    private final VerifyContract.View view;

    public VerifyPresenter(VerifyContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        // Do Nothing; Tidak ada yg perlu dilakukan otomatis
    }

    @Override
    public void verify(Map<String, String> param) {
        view.setLoadingDialog(true, "Sedang melakukan verifikasi");
        UserDataSource dataSource = new UserDataSource();
        dataSource.verifyPhoneNumber(new IRequestResponseListener<User>() {
            @Override
            public void onSuccess(DataResult<User> result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    view.showStatus(ConstantUtils.STATUS_SUCCESS, result.getMessage());
                    view.redirectToProfile(result.getData());
                } else {
                    view.showStatus(ConstantUtils.STATUS_ERROR, result.getMessage());
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.setLoadingDialog(false, null);
                view.showStatus(ConstantUtils.STATUS_ERROR, "Gagal melakukan verifikasi");
            }
        }, param);
    }
}
