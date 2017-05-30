package com.irfankhoirul.apps.tatravel.module.passenger;

import com.irfankhoirul.apps.tatravel.components.ConstantUtils;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.passenger.PassengerRepository;
import com.irfankhoirul.mvp_core.data.DataResult;
import com.irfankhoirul.mvp_core.data.IRequestResponseListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public class PassengerPresenter implements PassengerContract.Presenter {

    private final PassengerContract.View view;
    private final PassengerRepository passengerRepository;
    private final SessionRepository sessionRepository;
    private List<Penumpang> selectedPassengers = new ArrayList<>();
    private List<Penumpang> passengers = new ArrayList<>();

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
        passengers.clear();
        Map<String, String> params = new HashMap<>();
        params.put("token", sessionRepository.getSessionData().getUserToken().getToken());
        listPassenger(params);
    }

    @Override
    public void createPassenger(final Map<String, String> param) {
        param.put("token", sessionRepository.getSessionData().getUserToken().getToken());
        view.setLoadingDialog(true, "Menyimpan data penumpang...");
        passengerRepository.createPassenger(new IRequestResponseListener<Penumpang>() {
            @Override
            public void onSuccess(DataResult<Penumpang> result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    view.showDataExist();
                    passengers.add(result.getData());
                    view.addPassengerItem();
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
    public void updatePassenger(final int position, final Penumpang passenger, Map<String, String> param) {
        param.put("token", sessionRepository.getSessionData().getUserToken().getToken());
        view.setLoadingDialog(true, "Menyimpan data penumpang...");
        passengerRepository.updatePassenger(new IRequestResponseListener() {
            @Override
            public void onSuccess(DataResult result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    Penumpang tmpPassenger = passengers.get(position);
                    for (int i = 0; i < selectedPassengers.size(); i++) {
                        if (selectedPassengers.get(i).getId() == tmpPassenger.getId()) {
                            selectedPassengers.set(i, passenger);
                        }
                    }
                    passengers.set(position, passenger);
                    view.updatePassengerItem(position);
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
        }, sessionRepository.getSessionData().getId(), passenger.getId(), param);
    }

    @Override
    public void deletePassenger(int idPenumpang, final int position, final List<Penumpang> passengers) {
        Map<String, String> param = new HashMap<>();
        param.put("token", sessionRepository.getSessionData().getUserToken().getToken());
        view.setLoadingDialog(true, "Menyimpan data penumpang...");
        passengerRepository.deletePassenger(new IRequestResponseListener() {
            @Override
            public void onSuccess(DataResult result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    Penumpang tmpPassenger = passengers.get(position);
                    for (int i = 0; i < selectedPassengers.size(); i++) {
                        if (selectedPassengers.get(i).getId() == tmpPassenger.getId()) {
                            selectedPassengers.remove(i);
                        }
                    }
                    passengers.remove(position);
                    view.removePassengerItem(position);
                    if (passengers.size() == 0) {
                        view.showDataNotExist();
                    }
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
    public void listPassenger(final Map<String, String> params) {
        if (params.get("page") == null) {
            params.put("page", String.valueOf(1));
        } else {
            int page = Integer.parseInt(params.get("page"));
            params.put("page", String.valueOf(++page));
        }

        if (Integer.parseInt(params.get("page")) == 1) {
            view.setLoadingDialog(true, "Memuat data...");
        }
        passengerRepository.listPassenger(new IRequestResponseListener<Penumpang>() {
            @Override
            public void onSuccess(DataResult<Penumpang> result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    if (result.getDatas() != null && result.getDatas().size() > 0) {
                        view.showDataExist();
                        for (int i = 0; i < result.getDatas().size(); i++) {
                            for (int j = 0; j < selectedPassengers.size(); j++) {
                                if (result.getDatas().get(i).getId() == selectedPassengers.get(j).getId()) {
                                    result.getDatas().get(i).setSelected(true);
                                }
                            }
                        }
                        view.updatePassengerList(result.getDatas(), result.getDataPage(), params);
                    } else {
                        view.showDataNotExist();
                    }
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
        }, sessionRepository.getSessionData().getId(), params);
    }

    @Override
    public void setSelectedPassenger(List<Penumpang> passengers) {
        selectedPassengers = passengers;
    }

    @Override
    public List<Penumpang> getSelectedPassengers() {
        return selectedPassengers;
    }

    @Override
    public void onPassengerItemClick(Penumpang passenger, boolean isSelected) {
        if (!selectedPassengers.contains(passenger)) {
            if (isSelected) {
                selectedPassengers.add(passenger);
            } else {
                for (int i = 0; i < selectedPassengers.size(); i++) {
                    if (selectedPassengers.get(i).getId() == passenger.getId()) {
                        selectedPassengers.remove(i);
                    }
                }
            }
        }
    }

    @Override
    public List<Penumpang> getPassenger() {
        return passengers;
    }
}
