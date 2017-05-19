package com.irfankhoirul.apps.tatravel.module.destination;

import com.irfankhoirul.apps.tatravel.core.components.util.ConstantUtils;
import com.irfankhoirul.apps.tatravel.core.data.DataResult;
import com.irfankhoirul.apps.tatravel.core.data.IRequestResponseListener;
import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;
import com.irfankhoirul.apps.tatravel.data.source.remote.schedule.ScheduleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class DestinationPresenter implements DestinationContract.Presenter {

    private final DestinationContract.View view;
    private final ScheduleRepository scheduleRepository;
    private List<Integer> operatorTravelLocationIds = new ArrayList<>();
    private boolean gotLocation = false;

    @Inject
    public DestinationPresenter(ScheduleRepository scheduleRepository, DestinationContract.View view) {
        this.view = view;
        this.scheduleRepository = scheduleRepository;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    public DestinationContract.View getView() {
        return view;
    }

    @Override
    public void start() {

    }

    @Override
    public void checkLocationAvailability(Map<String, String> params) {
        view.setLoadingDialog(true, "Mencari Operator Travel...");
        scheduleRepository.getDestinationAvailability(new IRequestResponseListener<Lokasi>() {
            @Override
            public void onSuccess(DataResult<Lokasi> result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    view.updateMap(result.getDatas());
                    for (int i = 0; i < result.getDatas().size(); i++) {
                        operatorTravelLocationIds.add(result.getDatas().get(i).getId());
                    }
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
    public List<Integer> getTravelLocationIds() {
        return operatorTravelLocationIds;
    }

    @Override
    public boolean isGotLocation() {
        return gotLocation;
    }

    @Override
    public void setGotLocation(boolean gotLocation) {
        this.gotLocation = gotLocation;
    }

}
