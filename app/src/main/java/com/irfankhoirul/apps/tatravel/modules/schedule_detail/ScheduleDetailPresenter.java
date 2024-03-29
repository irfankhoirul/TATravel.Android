package com.irfankhoirul.apps.tatravel.modules.schedule_detail;

import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.data.source.locale.cart.CartRepository;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class ScheduleDetailPresenter implements ScheduleDetailContract.Presenter {

    private final ScheduleDetailContract.View view;
    private final CartRepository cartRepository;
    private JadwalPerjalanan schedule;

    @Inject
    public ScheduleDetailPresenter(CartRepository cartRepository, ScheduleDetailContract.View view) {
        this.view = view;
        this.cartRepository = cartRepository;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public JadwalPerjalanan getSchedule() {
        return schedule;
    }

    @Override
    public void setSchedule(JadwalPerjalanan schedule) {
        this.schedule = schedule;
        cartRepository.setSchedule(schedule);
    }

}
