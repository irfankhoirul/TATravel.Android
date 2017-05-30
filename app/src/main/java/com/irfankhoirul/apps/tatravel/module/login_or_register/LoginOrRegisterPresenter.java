package com.irfankhoirul.apps.tatravel.module.login_or_register;

import com.irfankhoirul.apps.tatravel.components.ConstantUtils;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class LoginOrRegisterPresenter implements LoginOrRegisterContract.Presenter {

    private final LoginOrRegisterContract.View view;

    @Inject
    LoginOrRegisterPresenter(LoginOrRegisterContract.View view) {
        this.view = view;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void handleActivityResult(int requestCode, int resultCode) {
        if (requestCode == ConstantUtils.INTENT_REQUEST_LOGIN_OR_REGISTER_TO_REGISTER) {
            if (resultCode == ConstantUtils.STATUS_SUCCESS) {
                view.notifyListenerRegisterSuccess();
            }
        } else if (requestCode == ConstantUtils.INTENT_REQUEST_LOGIN_OR_REGISTER_TO_LOGIN) {
            if (resultCode == ConstantUtils.STATUS_SUCCESS) {
                view.notifyListenerLoginSuccess();
            }
        }

    }

}
