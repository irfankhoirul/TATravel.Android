package com.irfankhoirul.apps.tatravel.modules.search;

import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;
import com.irfankhoirul.apps.tatravel.data.source.locale.cart.CartRepository;
import com.irfankhoirul.apps.tatravel.data.source.locale.session.SessionRepository;

import java.util.ArrayList;
import java.util.Map;

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
    private final SessionRepository sessionRepository;
    private final CartRepository cartRepository;
    private ArrayList<Penumpang> selectedPassengers = new ArrayList<>();

    @Inject
    public SearchPresenter(SessionRepository sessionRepository,
                           CartRepository cartRepository,
                           SearchContract.View view) {
        this.view = view;
        this.sessionRepository = sessionRepository;
        this.cartRepository = cartRepository;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {
        if (isLoggedIn()) {
            if (cartRepository.getDeparture() != null) {
                view.setDepartureView(cartRepository.getDeparture().get("address"));
            }

            if (cartRepository.getDestination() != null) {
                view.setDestinationView(cartRepository.getDestination().get("address"));
            }

            if (cartRepository.getTanggalKeberangkatan() != 0) {
                view.setDateView(cartRepository.getTanggalKeberangkatan());
            }

            if (cartRepository.getPenumpang() != null && cartRepository.getPenumpang().size() > 0) {
                view.setPassengerView(cartRepository.getPenumpang());
                selectedPassengers = cartRepository.getPenumpang();
            }

        }
    }

    @Override
    public boolean isLoggedIn() {
        return sessionRepository.getSessionData() != null;
    }

    @Override
    public boolean isDepartureSet() {
        return cartRepository.getDeparture() != null;
    }

    @Override
    public void setDeparture(Map<String, String> departureData) {
        cartRepository.setDeparture(departureData);
    }

    @Override
    public void clearDeparture() {
        cartRepository.clearDeparture();
    }

    @Override
    public boolean isDestinationSet() {
        return cartRepository.getDestination() != null;
    }

    @Override
    public void setDestination(Map<String, String> destinationData) {
        cartRepository.setDestination(destinationData);
    }

    @Override
    public void clearDestination() {
        cartRepository.clearDestination();
    }

    @Override
    public boolean isDateSet() {
        return cartRepository.getTanggalKeberangkatan() != 0;
    }

    @Override
    public void setDate(long date) {
        cartRepository.setTanggalKeberangkatan(date);
    }

    @Override
    public void clearDate() {
        cartRepository.clearTanggalKeberangkatan();
    }

    @Override
    public boolean isPassengerSet() {
        return cartRepository.getPenumpang() != null;
    }

    @Override
    public void clearPassenger() {
        cartRepository.clearPenumpang();
    }

    @Override
    public String getSelectedOperatorTravelId() {
        return cartRepository.getDeparture().get("operatorTravelId");
    }

    @Override
    public ArrayList<Penumpang> getSelectedPassengers() {
        return selectedPassengers;
    }

    @Override
    public void setSelectedPassengers(ArrayList<Penumpang> selectedPassengers) {
        cartRepository.setPenumpang(selectedPassengers);
        this.selectedPassengers = selectedPassengers;
    }

}
