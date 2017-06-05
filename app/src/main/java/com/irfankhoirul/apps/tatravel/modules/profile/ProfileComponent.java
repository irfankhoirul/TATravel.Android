package com.irfankhoirul.apps.tatravel.modules.profile;

import com.irfankhoirul.apps.tatravel.activity.MainActivity;
import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.modules.DaggerModuleScoped;
import com.irfankhoirul.apps.tatravel.modules.login_or_register.LoginOrRegisterPresenterModule;
import com.irfankhoirul.apps.tatravel.modules.reservation_history.ReservationHistoryPresenterModule;
import com.irfankhoirul.apps.tatravel.modules.search.SearchPresenterModule;

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
public interface ProfileComponent {

    void inject(MainActivity mainActivity);

}