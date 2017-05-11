package com.irfankhoirul.apps.tatravel.module.departure;

import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;
import com.irfankhoirul.apps.tatravel.data.pojo.OperatorTravel;
import com.irfankhoirul.apps.tatravel.data.source.remote.schedule.ScheduleRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class DeparturePresenter implements DepartureContract.Presenter {

    private final DepartureContract.View view;
    private final ScheduleRepository scheduleRepository;

    @Inject
    public DeparturePresenter(ScheduleRepository scheduleRepository, DepartureContract.View view) {
        this.view = view;
        this.scheduleRepository = scheduleRepository;
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
        scheduleRepository.getDepartureAvailability(new IRequestResponseListener<Lokasi>() {
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

    @Override
    public List<OperatorTravel> prepareOperatorTraveldata(List<Lokasi> lokasiList) {
        List<OperatorTravel> availableOperatorTravel = new ArrayList<>();

        for (int i = 0; i < lokasiList.size(); i++) {
            if (availableOperatorTravel.size() == 0) {
                availableOperatorTravel.add(lokasiList.get(i).getOperatorTravel());
            } else {
                int counter = 0;
                for (int j = 0; j < availableOperatorTravel.size(); j++) {
                    if (availableOperatorTravel.get(j).getId() == lokasiList.get(i).getOperatorTravel().getId()) {
                        counter++;
                    }
                }
                if (counter == 0) {
                    availableOperatorTravel.add(lokasiList.get(i).getOperatorTravel());
                }
            }

        }

        for (int i = 0; i < availableOperatorTravel.size(); i++) {
            double tmpDistanceMax = 0;
            double tmpDistanceMin = 0;
            for (int j = 0; j < lokasiList.size(); j++) {
                if (availableOperatorTravel.get(i).getId() == lokasiList.get(j).getOperatorTravel().getId()) {
                    if (tmpDistanceMax == 0) {
                        tmpDistanceMax = Double.parseDouble(lokasiList.get(j).getDistance());
                    } else if (tmpDistanceMax < Double.parseDouble(lokasiList.get(j).getDistance())) {
                        tmpDistanceMax = Double.parseDouble(lokasiList.get(j).getDistance());
                    }

                    if (tmpDistanceMin == 0) {
                        tmpDistanceMin = Double.parseDouble(lokasiList.get(j).getDistance());
                    } else if (tmpDistanceMin > Double.parseDouble(lokasiList.get(j).getDistance())) {
                        tmpDistanceMin = Double.parseDouble(lokasiList.get(j).getDistance());
                    }
                }
            }
            Map<String, String> distance = new HashMap<>();
            if (tmpDistanceMax == tmpDistanceMin) {
                distance.put("distance", String.format("%.2f", tmpDistanceMax));
                availableOperatorTravel.get(i).setKeterangan(distance);
            } else {
                distance.put("distance", String.format("%.2f", tmpDistanceMin) + " - " + String.format("%.2f", tmpDistanceMax));
                availableOperatorTravel.get(i).setKeterangan(distance);
            }
        }

        return availableOperatorTravel;

    }


}
