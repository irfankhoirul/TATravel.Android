package com.irfankhoirul.apps.tatravel.module.user.editor;

import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.Kota;
import com.irfankhoirul.apps.tatravel.data.pojo.Provinsi;
import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.user.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public class EditProfilePresenter implements EditProfileContract.Presenter {

    private final EditProfileContract.View view;
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private List<Provinsi> provinceList = new ArrayList<>();

    @Inject
    public EditProfilePresenter(SessionRepository sessionRepository,
                                UserRepository userRepository,
                                EditProfileContract.View view) {
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
        view.setLoadingDialog(true, "Mengambil Data");
        view.showCurrentData(sessionRepository.getSessionData());
        getProvinceList();
        getCityList(sessionRepository.getSessionData().getIdProvinsi());
    }

    private void getProvinceList() {
        Map<String, String> param = new HashMap<>();
        param.put("token", sessionRepository.getSessionData().getUserToken().getToken());
        userRepository.getListProvince(new IRequestResponseListener<Provinsi>() {
            @Override
            public void onSuccess(DataResult<Provinsi> result) {
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    provinceList = result.getDatas();
                    List<String> provinceNameList = new ArrayList<>();
                    for (int i = 0; i < provinceList.size(); i++) {
                        provinceNameList.add(provinceList.get(i).getNama());
                    }
                    view.updateProvinceList(provinceNameList);
                } else {
                    view.showStatus(ConstantUtils.STATUS_ERROR, result.getMessage());
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showStatus(ConstantUtils.STATUS_ERROR, "Gagal mendapatkan list provinsi");
            }
        }, param);
    }

    private void getCityList(int provinceId) {
        if (provinceId != 0) {
            Map<String, String> param = new HashMap<>();
            param.put("token", sessionRepository.getSessionData().getUserToken().getToken());
            userRepository.getListCity(new IRequestResponseListener<Kota>() {
                @Override
                public void onSuccess(DataResult<Kota> result) {
                    if (view.isActive()) {
                        view.setLoadingDialog(false, null);
                        if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                            List<String> cityNameList = new ArrayList<>();
                            for (int i = 0; i < result.getDatas().size(); i++) {
                                cityNameList.add(result.getDatas().get(i).getNama());
                            }
                            view.updateCityList(cityNameList);
                        } else {
                            view.showStatus(ConstantUtils.STATUS_ERROR, result.getMessage());
                        }
                    }
                }

                @Override
                public void onFailure(Throwable throwable) {
                    view.setLoadingDialog(false, null);
                    view.showStatus(ConstantUtils.STATUS_ERROR, "Gagal mendapatkan list kota");
                }
            }, provinceId, param);
        } else {
            view.setLoadingDialog(false, null);
        }
    }

    @Override
    public void getCityList(String provinceName) {
        for (int i = 0; i < provinceList.size(); i++) {
            if (provinceList.get(i).getNama().equalsIgnoreCase(provinceName)) {
                getCityList(provinceList.get(i).getId());
            }
        }
    }

    @Override
    public void updateUser(Map<String, String> params) {
        view.setLoadingDialog(true, "Memperbarui profile...");
        params.put("token", sessionRepository.getSessionData().getUserToken().getToken());
        userRepository.updateProfile(new IRequestResponseListener<User>() {
            @Override
            public void onSuccess(DataResult<User> result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    sessionRepository.setSessionData(result.getData());
                    view.finishActivity();
                } else {
                    if (result.getDebugMessage().contains("u_phone")) {
                        view.showStatus(ConstantUtils.STATUS_ERROR, "Nomor Handphone yang anda masukkan sudah digunakan oleh akun lain");
                    } else if (result.getDebugMessage().contains("u_email")) {
                        view.showStatus(ConstantUtils.STATUS_ERROR, "Alamat Email yang anda masukkan sudah digunakan oleh akun lain");
                    } else {
                        view.showStatus(ConstantUtils.STATUS_ERROR, result.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.setLoadingDialog(false, null);
                view.showStatus(ConstantUtils.STATUS_ERROR, "Gagal memperbarui profile");
            }
        }, sessionRepository.getSessionData().getId(), params);
    }
}
