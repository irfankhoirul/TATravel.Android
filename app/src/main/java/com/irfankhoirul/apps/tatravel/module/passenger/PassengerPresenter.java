package com.irfankhoirul.apps.tatravel.module.passenger;

import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.User;
import com.irfankhoirul.apps.tatravel.data.source.remote.source.passenger.PassengerDataSource;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public class PassengerPresenter implements PassengerContract.Presenter {

    private final PassengerContract.View view;
    private final PassengerDataSource passengerDataSource;

    @Inject
    public PassengerPresenter(PassengerDataSource passengerDataSource, PassengerContract.View view) {
        this.view = view;
        this.passengerDataSource = passengerDataSource;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void createPassenger(String userId, Map<String, String> param) {

    }

    @Override
    public void updatePassenger(String userId, String idPenumpang, Map<String, String> param) {

    }

    @Override
    public void deletePassenger(String userId, String idPenumpang) {

    }

    @Override
    public void listPassenger(String userId, Map<String, String> param) {
        view.setLoadingDialog(true, "Tunggu sebentar...");
        passengerDataSource.listPassenger(new IRequestResponseListener<User>() {
            @Override
            public void onSuccess(DataResult<User> result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {

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
        }, userId, param);
    }
}
