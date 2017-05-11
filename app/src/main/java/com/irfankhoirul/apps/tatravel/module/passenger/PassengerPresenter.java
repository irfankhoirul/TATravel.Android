package com.irfankhoirul.apps.tatravel.module.passenger;

import android.util.Log;

import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.passenger.PassengerRepository;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public class PassengerPresenter implements PassengerContract.Presenter {

    private final PassengerContract.View view;
    private final PassengerRepository passengerRepository;
    private final SessionRepository sessionRepository;

    @Inject
    public PassengerPresenter(SessionRepository sessionRepository, PassengerRepository passengerRepository, PassengerContract.View view) {
        this.view = view;
        this.passengerRepository = passengerRepository;
        this.sessionRepository = sessionRepository;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {
        Map<String, String> params = new HashMap<>();
        params.put("token", sessionRepository.getSessionData().getUserToken().getToken());
        listPassenger(params);
    }

    @Override
    public void createPassenger(Map<String, String> param) {
        param.put("token", sessionRepository.getSessionData().getUserToken().getToken());
        view.setLoadingDialog(true, "Menyimpan data penumpang...");
        passengerRepository.createPassenger(new IRequestResponseListener() {
            @Override
            public void onSuccess(DataResult result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    Map<String, String> params = new HashMap<>();
                    params.put("token", sessionRepository.getSessionData().getUserToken().getToken());
                    listPassenger(params);

                    view.showStatus(ConstantUtils.STATUS_SUCCESS, result.getMessage());
                } else {
                    view.showStatus(ConstantUtils.STATUS_ERROR, result.getMessage());
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.setLoadingDialog(false, null);
                view.showStatus(ConstantUtils.STATUS_ERROR, "Terjadi kesalahan");
            }
        }, sessionRepository.getSessionData().getId(), param);
    }

    @Override
    public void updatePassenger(int idPenumpang, Map<String, String> param) {
        param.put("token", sessionRepository.getSessionData().getUserToken().getToken());
        view.setLoadingDialog(true, "Menyimpan data penumpang...");
        passengerRepository.updatePassenger(new IRequestResponseListener() {
            @Override
            public void onSuccess(DataResult result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    Map<String, String> params = new HashMap<>();
                    params.put("token", sessionRepository.getSessionData().getUserToken().getToken());
                    listPassenger(params);

                    view.showStatus(ConstantUtils.STATUS_SUCCESS, result.getMessage());
                } else {
                    view.showStatus(ConstantUtils.STATUS_ERROR, result.getMessage());
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.setLoadingDialog(false, null);
                view.showStatus(ConstantUtils.STATUS_ERROR, "Terjadi kesalahan");
            }
        }, sessionRepository.getSessionData().getId(), idPenumpang, param);
    }

    @Override
    public void deletePassenger(int idPenumpang) {
        Map<String, String> param = new HashMap<>();
        param.put("token", sessionRepository.getSessionData().getUserToken().getToken());
        view.setLoadingDialog(true, "Menyimpan data penumpang...");
        passengerRepository.deletePassenger(new IRequestResponseListener() {
            @Override
            public void onSuccess(DataResult result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    Map<String, String> params = new HashMap<>();
                    params.put("token", sessionRepository.getSessionData().getUserToken().getToken());
                    listPassenger(params);

                    view.showStatus(ConstantUtils.STATUS_SUCCESS, result.getMessage());
                } else {
                    view.showStatus(ConstantUtils.STATUS_ERROR, result.getMessage());
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.setLoadingDialog(false, null);
                view.showStatus(ConstantUtils.STATUS_ERROR, "Terjadi kesalahan");
            }
        }, sessionRepository.getSessionData().getId(), idPenumpang, param);
    }

    @Override
    public void listPassenger(final Map<String, String> param) {
        if (param.get("page") == null) {
            param.put("page", String.valueOf(1));
        } else {
            int page = Integer.parseInt(param.get("page"));
            param.put("page", String.valueOf(++page));
        }

        view.setLoadingDialog(true, "Tunggu sebentar...");
        passengerRepository.listPassenger(new IRequestResponseListener<Penumpang>() {
            @Override
            public void onSuccess(DataResult<Penumpang> result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    view.updatePassengerList(result.getDatas());
//                    if (result.getDataPage().getNextPage() != -1) {
                    Log.v("NextPage", String.valueOf(result.getDataPage().getNextPage()));
//                        listPassenger(param);
//                    }
                } else {
                    view.setLoadingDialog(false, null);
                    view.showStatus(ConstantUtils.STATUS_ERROR, result.getMessage());
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.setLoadingDialog(false, null);
                view.showStatus(ConstantUtils.STATUS_ERROR, "Terjadi kesalahan");
            }
        }, sessionRepository.getSessionData().getId(), param);
    }
}
