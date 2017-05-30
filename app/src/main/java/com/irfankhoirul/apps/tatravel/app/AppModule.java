package com.irfankhoirul.apps.tatravel.app;

import android.content.Context;

import com.basgeekball.awesomevalidation.ValidationStyle;
import com.irfankhoirul.apps.tatravel.components.FormValidation;
import com.irfankhoirul.apps.tatravel.data.source.locale.cart.Cart;
import com.irfankhoirul.apps.tatravel.data.source.locale.cart.CartRepository;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.Session;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.passenger.PassengerRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.passenger.PassengerRepositoryImpl;
import com.irfankhoirul.apps.tatravel.data.source.remote.reservation.ReservationRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.reservation.ReservationRepositoryImpl;
import com.irfankhoirul.apps.tatravel.data.source.remote.schedule.ScheduleRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.schedule.ScheduleRepositoryImpl;
import com.irfankhoirul.apps.tatravel.data.source.remote.seat.SeatRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.seat.SeatRepositoryImpl;
import com.irfankhoirul.apps.tatravel.data.source.remote.user.UserRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.user.UserRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Khoirul on 5/8/2017.
 */

@Module
public final class AppModule {

    private final Context mContext;

    AppModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

    @Singleton
    @Provides
    SessionRepository provideSessionRepository(Context context) {
        return new Session(context);
    }

    @Singleton
    @Provides
    CartRepository provideCartRepository(Context context) {
        return new Cart(context);
    }

    @Singleton
    @Provides
    UserRepository provideUserRepository() {
        return new UserRepositoryImpl();
    }

    @Singleton
    @Provides
    ScheduleRepository provideScheduleRepository() {
        return new ScheduleRepositoryImpl();
    }

    @Singleton
    @Provides
    PassengerRepository providePassengerRepository() {
        return new PassengerRepositoryImpl();
    }

    @Singleton
    @Provides
    SeatRepository provideSeatRepository() {
        return new SeatRepositoryImpl();
    }

    @Singleton
    @Provides
    ReservationRepository provideReservationRepository() {
        return new ReservationRepositoryImpl();
    }

    @Singleton
    @Provides
    FormValidation provideValidation() {
        return new FormValidation(ValidationStyle.TEXT_INPUT_LAYOUT);
    }
}
