package com.irfankhoirul.apps.tatravel.module.search;

import com.irfankhoirul.apps.tatravel.data.source.locale.cart.CartRepository;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;
import com.irfankhoirul.apps.tatravel.data.source.remote.schedule.ScheduleRepository;

import javax.inject.Inject;

/**
 * Merupakan presenter dari SearchFragment
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @version 1.0 (13 November 2016)
 * @since 1.0
 */

public class SearchPresenter implements SearchContract.Presenter {

    private final SearchContract.View view;
    private final ScheduleRepository scheduleRepository;
    private final SessionRepository sessionRepository;
    private final CartRepository cartRepository;

    @Inject
    public SearchPresenter(SessionRepository sessionRepository, CartRepository cartRepository,
                           ScheduleRepository scheduleRepository, SearchContract.View view) {
        this.view = view;
        this.sessionRepository = sessionRepository;
        this.scheduleRepository = scheduleRepository;
        this.cartRepository = cartRepository;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public CartRepository getCart() {
        return cartRepository;
    }

    @Override
    public void getPromo() {
        //Todo : get promo data from server
        view.showPromo();
    }

}
