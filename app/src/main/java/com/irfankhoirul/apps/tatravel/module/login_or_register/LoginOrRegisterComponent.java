package com.irfankhoirul.apps.tatravel.module.login_or_register;

import com.irfankhoirul.apps.tatravel.activity.MainActivity;
import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.module.DaggerModuleScoped;
import com.irfankhoirul.apps.tatravel.module.profile.ProfilePresenterModule;
import com.irfankhoirul.apps.tatravel.module.reservation_history.ReservationHistoryPresenterModule;
import com.irfankhoirul.apps.tatravel.module.search.SearchPresenterModule;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(dependencies = AppComponent.class,
        modules = {SearchPresenterModule.class,
                ProfilePresenterModule.class,
                LoginOrRegisterPresenterModule.class,
                ReservationHistoryPresenterModule.class})
public interface LoginOrRegisterComponent {

    void inject(MainActivity mainActivity);

}