package com.irfankhoirul.apps.tatravel.module.reservation.history;

import com.irfankhoirul.apps.tatravel.core.activity.MainActivity;
import com.irfankhoirul.apps.tatravel.core.app.AppComponent;
import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.module.search.SearchPresenterModule;
import com.irfankhoirul.apps.tatravel.module.user.ProfilePresenterModule;
import com.irfankhoirul.apps.tatravel.module.user.login_or_register.LoginOrRegisterPresenterModule;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(dependencies = AppComponent.class,
        modules = {SearchPresenterModule.class,
                ProfilePresenterModule.class,
                LoginOrRegisterPresenterModule.class,
                ReservationHistoryPresenterModule.class})
public interface ReservationHistoryComponent {

    void inject(MainActivity mainActivity);

    SessionRepository session();

}