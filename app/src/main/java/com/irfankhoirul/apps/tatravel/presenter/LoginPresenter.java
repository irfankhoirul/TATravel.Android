package com.irfankhoirul.apps.tatravel.presenter;

import com.irfankhoirul.apps.tatravel.aaa.core.components.DataResult;
import com.irfankhoirul.apps.tatravel.aaa.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.contract.LoginContract;
import com.irfankhoirul.apps.tatravel.model.data.remote.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.model.data.remote.UserDataSource;
import com.irfankhoirul.apps.tatravel.model.pojo.User;

import java.util.Map;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void login(Map<String, String> param) {
        view.setLoadingDialog(true, "Login");
        UserDataSource dataSource = new UserDataSource();
        dataSource.login(new IRequestResponseListener<User>() {
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
                view.showStatus(ConstantUtils.STATUS_ERROR, "Login gagal");
            }
        }, param);
    }

}
