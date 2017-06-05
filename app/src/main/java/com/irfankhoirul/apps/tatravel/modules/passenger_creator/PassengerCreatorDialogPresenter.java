package com.irfankhoirul.apps.tatravel.modules.passenger_creator;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class PassengerCreatorDialogPresenter implements PassengerCreatorDialogContract.Presenter {

    private final PassengerCreatorDialogContract.View view;

    @Inject
    public PassengerCreatorDialogPresenter(PassengerCreatorDialogContract.View view) {
        this.view = view;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

}
