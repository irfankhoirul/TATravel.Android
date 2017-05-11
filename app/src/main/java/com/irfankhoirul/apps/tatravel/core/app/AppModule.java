package com.irfankhoirul.apps.tatravel.core.app;

import android.content.Context;

import com.irfankhoirul.apps.tatravel.data.source.locale.cart.Cart;
import com.irfankhoirul.apps.tatravel.data.source.locale.cart.CartRepository;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.Session;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.passenger.PassengerRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.passenger.PassengerRepositoryImpl;
import com.irfankhoirul.apps.tatravel.data.source.remote.schedule.ScheduleRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.schedule.ScheduleRepositoryImpl;
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
    private TAApplication taApplication;

    AppModule(TAApplication taApplication, Context context) {
        mContext = context;
        this.taApplication = taApplication;
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
}
