package com.irfankhoirul.apps.tatravel.module.verification;

import com.google.firebase.iid.FirebaseInstanceId;
import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.api.source.user.UserDataSource;
import com.irfankhoirul.apps.tatravel.data.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.data.pojo.User;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class VerifyPresenter implements VerifyContract.Presenter {

    private final VerifyContract.View view;
    private final UserDataSource userDataSource;
    private final SessionRepository sessionRepository;

    @Inject
    public VerifyPresenter(SessionRepository sessionRepository, UserDataSource userDataSource, VerifyContract.View view) {
        this.view = view;
        this.userDataSource = userDataSource;
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
    public void initializeSession(User user) {
        sessionRepository.initialize(user);
    }

    @Override
    public User getSessionData() {
        return sessionRepository.getSessionData();
    }

    @Override
    public void verify(Map<String, String> param) {
        view.setLoadingDialog(true, "Sedang melakukan verifikasi");
        userDataSource.verifyPhoneNumber(new IRequestResponseListener<User>() {
            @Override
            public void onSuccess(DataResult<User> result) {
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {

                    initializeSession(result.getData());
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
                view.showStatus(ConstantUtils.STATUS_ERROR, "Gagal melakukan verifikasi");
            }
        }, param);
    }

    @Override
    public void updateFcmToken(Map<String, String> param) {
        userDataSource.updateFcmToken(new IRequestResponseListener<User>() {
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
