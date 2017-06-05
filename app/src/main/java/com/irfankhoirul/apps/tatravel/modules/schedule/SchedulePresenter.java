package com.irfankhoirul.apps.tatravel.modules.schedule;

import android.util.Log;

import com.google.gson.Gson;
import com.irfankhoirul.apps.tatravel.components.ConstantUtils;
import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.data.source.locale.cart.CartRepository;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.schedule.ScheduleRepository;
import com.irfankhoirul.mvp_core.data.DataResult;
import com.irfankhoirul.mvp_core.data.IRequestResponseListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 4/2/2017.
 */

public class SchedulePresenter implements ScheduleContract.Presenter {

    private final ScheduleContract.View view;
    private final ScheduleRepository scheduleRepository;
    private final SessionRepository sessionRepository;
    private final CartRepository cartRepository;
    private List<JadwalPerjalanan> schedules = new ArrayList<>();

    @Inject
    public SchedulePresenter(SessionRepository sessionRepository,
                             CartRepository cartRepository,
                             ScheduleRepository scheduleRepository,
                             ScheduleContract.View view) {
        this.view = view;
        this.scheduleRepository = scheduleRepository;
        this.sessionRepository = sessionRepository;
        this.cartRepository = cartRepository;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {
        Map<String, String> params = new HashMap<>();
        params.put("idDepartureLocations", cartRepository.getDeparture().get("operatorTravelLocationIds"));
        params.put("departureLatitude", cartRepository.getDeparture().get("latitude"));
        params.put("departureLongitude", cartRepository.getDeparture().get("longitude"));
        params.put("idDestinationLocations", cartRepository.getDestination().get("operatorTravelLocationIds"));
        params.put("destinationLatitude", cartRepository.getDestination().get("latitude"));
        params.put("destinationLongitude", cartRepository.getDestination().get("longitude"));
        List<Integer> idPassengers = new ArrayList<>();
        for (int i = 0; i < cartRepository.getPenumpang().size(); i++) {
            idPassengers.add(cartRepository.getPenumpang().get(i).getId());
        }
        params.put("idPassengers", new Gson().toJson(idPassengers));
        Date departureDate = new Date();
        departureDate.setTime(cartRepository.getTanggalKeberangkatan());
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        params.put("date", dt.format(departureDate));

        searchSchedules(params);
    }

    @Override
    public void searchSchedules(final Map<String, String> params) {
        if (params.get("page") == null) {
            params.put("page", String.valueOf(1));
        } else {
            int page = Integer.parseInt(params.get("page"));
            params.put("page", String.valueOf(++page));
        }

        if (Integer.parseInt(params.get("page")) == 1) {
            view.setLoadingDialog(true, "Mencari perjalanan...");
        }

        params.put("token", sessionRepository.getSessionData().getUserToken().getToken());
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Log.v(key, value);
        }
        scheduleRepository.searchSchedule(new IRequestResponseListener<JadwalPerjalanan>() {
            @Override
            public void onSuccess(DataResult<JadwalPerjalanan> result) {
                view.setLoadingDialog(false, null);
                if (result.getCode() == ConstantUtils.REQUEST_RESULT_SUCCESS) {
                    if (result.getDatas().size() > 0) {
                        view.updateScheduleList(result.getDatas(), result.getDataPage(), params);
                        view.showDataExist();
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
        }, Integer.parseInt(cartRepository.getDeparture().get("operatorTravelId")), params);
    }

    @Override
    public void handleOnActivityResult(int requestCode, int resultCode) {
        if (requestCode == ConstantUtils.ACTIVITY_REQUEST_CODE_SEAT) {
            view.finishActivity(resultCode);
        }
    }

    @Override
    public List<JadwalPerjalanan> getSchedules() {
        return schedules;
    }
}
