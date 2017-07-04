package com.irfankhoirul.apps.tatravel.modules.login;

import com.google.common.hash.Hashing;
import com.google.firebase.iid.FirebaseInstanceId;
import com.irfankhoirul.apps.tatravel.components.ConstantUtils;
import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.user.UserRepository;
import com.irfankhoirul.mvp_core.data.DataResult;
import com.irfankhoirul.mvp_core.data.RequestResponseListener;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View view;
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    @Inject
    public LoginPresenter(SessionRepository sessionRepository,
                          UserRepository userRepository,
                          LoginContract.View view) {
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

    }

    @Override
    public void initializeSession(User user) {
        sessionRepository.initialize(user);
    }

    @Override
    public void login(Map<String, String> param) {
        view.setLoadingDialog(true, "Login");
        userRepository.login(new RequestResponseListener<User>() {
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
                view.showStatus(ConstantUtils.STATUS_ERROR, "Login gagal");
            }
        }, param);
    }

    @Override
    public void updateFcmToken(Map<String, String> param) {
        userRepository.updateFcmToken(new RequestResponseListener<User>() {
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

    @Override
    public void handleSocialLogin(String email, String firebaseInstanceId) {
        if (email == null) {
            view.showStatus(ConstantUtils.STATUS_ERROR, "Login Gagal");
        } else {
            String hashedPassword1 = Hashing.md5()
                    .hashString(email, Charset.forName("UTF-8"))
                    .toString();
            String hashedPassword2 = Hashing.sha1()
                    .hashString(hashedPassword1, Charset.forName("UTF-8"))
                    .toString();
            String hashedPassword3 = Hashing.sha256()
                    .hashString(hashedPassword2, Charset.forName("UTF-8"))
                    .toString();

            Map<String, String> params = new HashMap<>();
            params.put("email", email);
            params.put("password", hashedPassword3);
            params.put("deviceSecretId", firebaseInstanceId);
            params.put("socialMedia", "TRUE");
            login(params);
        }
    }

}
