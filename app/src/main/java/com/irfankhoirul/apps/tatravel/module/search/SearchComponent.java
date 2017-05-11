package com.irfankhoirul.apps.tatravel.module.search;

import com.irfankhoirul.apps.tatravel.core.activity.MainActivity;
import com.irfankhoirul.apps.tatravel.core.app.AppComponent;
import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;
import com.irfankhoirul.apps.tatravel.data.source.locale.cart.CartRepository;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.module.user.ProfilePresenterModule;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(dependencies = AppComponent.class, modules = {SearchPresenterModule.class, ProfilePresenterModule.class})
public interface SearchComponent {

    void inject(MainActivity searchFragment);

    SessionRepository session();

    CartRepository cart();
}