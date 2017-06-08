package com.irfankhoirul.apps.tatravel.modules.profile;

import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.modules.DaggerModuleScoped;
import com.irfankhoirul.apps.tatravel.modules.MainActivity;
import com.irfankhoirul.apps.tatravel.modules.auth_choice.AuthChoicePresenterModule;
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
                AuthChoicePresenterModule.class,
                ReservationHistoryPresenterModule.class})
public interface ProfileComponent {

    void inject(MainActivity mainActivity);

}