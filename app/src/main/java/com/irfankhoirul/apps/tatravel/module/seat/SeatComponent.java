package com.irfankhoirul.apps.tatravel.module.seat;

import com.irfankhoirul.apps.tatravel.core.app.AppComponent;
import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;
import com.irfankhoirul.apps.tatravel.data.source.locale.cart.CartRepository;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(dependencies = AppComponent.class, modules = SeatPresenterModule.class)
public interface SeatComponent {

    void inject(SeatActivity seatActivity);

    CartRepository cart();
}