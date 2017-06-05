package com.irfankhoirul.apps.tatravel.modules.profile_editor;

import com.irfankhoirul.apps.tatravel.app.AppComponent;
import com.irfankhoirul.apps.tatravel.modules.DaggerModuleScoped;

import dagger.Component;

/**
 * Created by Irfan Khoirul on 4/15/2017.
 */
@DaggerModuleScoped
@Component(dependencies = AppComponent.class, modules = EditProfilePresenterModule.class)
public interface EditProfileComponent {

    void inject(EditProfileActivity editProfileActivity);

}