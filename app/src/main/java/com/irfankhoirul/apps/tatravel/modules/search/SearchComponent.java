package com.irfankhoirul.apps.tatravel.modules.search;

import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.modules.DaggerModuleScoped;
import com.irfankhoirul.apps.tatravel.modules.MainActivity;
import com.irfankhoirul.apps.tatravel.modules.auth_choice.AuthChoicePresenterModule;
import com.irfankhoirul.apps.tatravel.modules.profile.ProfilePresenterModule;
import com.irfankhoirul.apps.tatravel.modules.reservation_history.ReservationHistoryPresenterModule;

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
public interface SearchComponent {

    void inject(MainActivity searchFragment);

}