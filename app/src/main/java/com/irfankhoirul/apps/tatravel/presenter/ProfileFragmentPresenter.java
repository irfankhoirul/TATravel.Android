package com.irfankhoirul.apps.tatravel.presenter;

import com.irfankhoirul.apps.tatravel.contract.ProfileContract;

/**
 * Created by Irfan Khoirul on 3/11/2017.
 */

public class ProfileFragmentPresenter implements ProfileContract.Presenter {

    private final ProfileContract.View view;

    public ProfileFragmentPresenter(ProfileContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        // Do Nothing; Tidak ada yg perlu dilakukan otomatis
        view.showProfile();
    }

}
