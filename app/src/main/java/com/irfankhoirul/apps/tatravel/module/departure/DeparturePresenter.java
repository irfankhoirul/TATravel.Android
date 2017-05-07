package com.irfankhoirul.apps.tatravel.module.departure;

import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.api.source.jadwal.JadwalPerjalananDataSource;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class DeparturePresenter implements DepartureContract.Presenter {

    private final DepartureContract.View view;
    private final JadwalPerjalananDataSource jadwalPerjalananDataSource;

    @Inject
    public DeparturePresenter(JadwalPerjalananDataSource jadwalPerjalananDataSource, DepartureContract.View view) {
        this.view = view;
        this.jadwalPerjalananDataSource = jadwalPerjalananDataSource;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    public DepartureContract.View getView() {
        return view;
    }

    @Override
    public void start() {

    }

    @Override
    public void checkLocationAvailability(Map<String, String> params) {
        view.setLoadingDialog(true, "Mencari Operator Travel...");
        jadwalPerjalananDataSource.getDepartureAvailability(new IRequestResponseListener<Lokasi>() {
            @Override
            public void onSuccess(DataResult<Lokasi> result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    view.updateMap(result.getDatas());
                } else {
                    view.showStatus(ConstantUtils.STATUS_ERROR, result.getMessage());
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.setLoadingDialog(false, null);
                view.showStatus(ConstantUtils.STATUS_ERROR, "Terjadi Kesalahan");
            }
        }, params);
    }

}
