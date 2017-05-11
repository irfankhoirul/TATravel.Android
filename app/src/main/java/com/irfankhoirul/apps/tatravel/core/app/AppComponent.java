package com.irfankhoirul.apps.tatravel.core.app;

import com.irfankhoirul.apps.tatravel.data.source.locale.cart.CartRepository;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.passenger.PassengerRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.schedule.ScheduleRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.user.UserRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 5/9/2017.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(TAApplication taApplication);

    SessionRepository session();

    CartRepository cart();

    UserRepository userRepository();

    ScheduleRepository scheduleRepository();

    PassengerRepository passengerRepository();
}