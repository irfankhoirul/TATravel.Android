package com.irfankhoirul.apps.tatravel.module.user.editor;

import com.irfankhoirul.apps.tatravel.core.app.AppComponent;
import com.irfankhoirul.apps.tatravel.core.components.FragmentScoped;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@FragmentScoped
@Component(dependencies = AppComponent.class, modules = EditProfilePresenterModule.class)
public interface EditProfileComponent {

    void inject(EditProfileActivity editProfileActivity);

    SessionRepository session();
}