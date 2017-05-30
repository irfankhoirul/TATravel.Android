package com.irfankhoirul.apps.tatravel.module.profile_editor;

import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.module.DaggerModuleScoped;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(dependencies = AppComponent.class, modules = EditProfilePresenterModule.class)
public interface EditProfileComponent {

    void inject(EditProfileActivity editProfileActivity);

}