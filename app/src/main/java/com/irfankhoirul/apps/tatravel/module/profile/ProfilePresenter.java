package com.irfankhoirul.apps.tatravel.module.profile;

import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.user.UserRepository;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class ProfilePresenter implements ProfileContract.Presenter {

    private final ProfileContract.View view;
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    @Inject
    ProfilePresenter(SessionRepository sessionRepository, UserRepository userRepository, ProfileContract.View view) {
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
        view.showProfile();
    }

    @Override
    public User getSessionData() {
        return sessionRepository.getSessionData();
    }

    @Override
    public void destroySession() {
        sessionRepository.destroy();
    }

    @Override
    public void logout(Map<String, String> param) {
        view.setLoadingDialog(true, "Logout");
        userRepository.logout(new IRequestResponseListener() {
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

    @Override
    public void handleActivityResult(int requestCode, int resultCode) {
        if (requestCode == ConstantUtils.ACTIVITY_REQUEST_CODE_EDIT_PROFILE && resultCode == ConstantUtils.REQUEST_RESULT_SUCCESS) {
            view.showProfile();
        }
    }
}