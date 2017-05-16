package com.irfankhoirul.apps.tatravel.module.register;

import com.google.firebase.iid.FirebaseInstanceId;
import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.user.UserRepository;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class RegisterPresenter implements RegisterContract.Presenter {

    private final RegisterContract.View view;
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    @Inject
    public RegisterPresenter(UserRepository userRepository,
                             SessionRepository sessionRepository,
                             RegisterContract.View view) {
        this.view = view;
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
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
    public void register(final Map<String, String> param) {
        view.setLoadingDialog(true, "Sedang melakukan registrasi");
        userRepository.register(new IRequestResponseListener() {
            @Override
            public void onSuccess(DataResult result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    view.showStatus(ConstantUtils.STATUS_SUCCESS, result.getMessage());
                    if (param.get("socialMedia") != null) {
                        Map<String, String> loginParam = new HashMap<>();
                        loginParam.put("deviceSecretId", param.get("deviceSecretId"));
                        loginParam.put("email", param.get("email"));
                        loginParam.put("password", param.get("password"));
                        loginSocialMedia(loginParam);
                    } else {
                        view.redirectToVerification(param.get("phone"), param.get("email"));
                    }
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

    private void loginSocialMedia(Map<String, String> param) {
        userRepository.login(new IRequestResponseListener<User>() {
            @Override
            public void onSuccess(DataResult<User> result) {
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    sessionRepository.initialize(result.getData());

                    Map<String, String> params = new HashMap<>();
                    params.put("token", sessionRepository.getSessionData().getUserToken().getToken());
                    params.put("FCMToken", FirebaseInstanceId.getInstance().getToken());

                    updateFcmToken(params);
                    view.showStatus(ConstantUtils.STATUS_SUCCESS, result.getMessage());
                } else {
                    view.setLoadingDialog(false, null);
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

    private void updateFcmToken(Map<String, String> param) {
        userRepository.updateFcmToken(new IRequestResponseListener<User>() {
            @Override
            public void onSuccess(DataResult<User> result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    view.redirectToProfile();
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
