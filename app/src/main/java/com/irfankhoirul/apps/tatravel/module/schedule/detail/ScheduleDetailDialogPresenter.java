package com.irfankhoirul.apps.tatravel.module.schedule.detail;

import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.data.source.locale.cart.CartRepository;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class ScheduleDetailDialogPresenter implements ScheduleDetailDialogContract.Presenter {

    private final ScheduleDetailDialogContract.View view;

    private final CartRepository cartRepository;

    @Inject
    public ScheduleDetailDialogPresenter(CartRepository cartRepository, ScheduleDetailDialogContract.View view) {
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
    public void setSchedule(JadwalPerjalanan schedule) {
        cartRepository.setSchedule(schedule);
    }

}
