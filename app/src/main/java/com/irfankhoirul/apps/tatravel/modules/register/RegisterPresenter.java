package com.irfankhoirul.apps.tatravel.modules.register;

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
        userRepository.register(new RequestResponseListener() {
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

    @Override
    public void handleSocialRegister(String email, String name, String firebaseInstanceId) {
        if (email == null || name == null) {
            view.showStatus(ConstantUtils.STATUS_ERROR, "Registrasi Gagal");
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
            params.put("name", name);
            params.put("email", email);
            params.put("password", hashedPassword3);
            params.put("deviceSecretId", firebaseInstanceId);
            params.put("socialMedia", "TRUE");
            register(params);
        }
    }

    private void loginSocialMedia(Map<String, String> param) {
        userRepository.login(new RequestResponseListener<User>() {
            @Override
            public void onSuccess(DataResult<User> result) {
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    sessionRepository.initialize(result.getData());

                    Map<String, String> params = new HashMap<>();
                    params.put("token", sessionRepository.getSessionData().getUserToken().getToken());
                    params.put("FCMToken", FirebaseInstanceId.getInstance().getToken());

                    updateFcmToken(params);
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
}
