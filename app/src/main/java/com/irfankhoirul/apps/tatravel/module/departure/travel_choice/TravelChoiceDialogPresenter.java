package com.irfankhoirul.apps.tatravel.module.departure.travel_choice;

import com.irfankhoirul.apps.tatravel.data.pojo.Lokasi;
import com.irfankhoirul.apps.tatravel.data.pojo.OperatorTravel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Irfan Khoirul on 12/25/2016.
 */

public class TravelChoiceDialogPresenter implements TravelChoiceDialogContract.Presenter {

    private final TravelChoiceDialogContract.View view;

    @Inject
    public TravelChoiceDialogPresenter(TravelChoiceDialogContract.View view) {
        this.view = view;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public List<OperatorTravel> prepareData(List<Lokasi> lokasiList) {
        List<OperatorTravel> availableOperatorTravel = new ArrayList<>();

        for (int i = 0; i < lokasiList.size(); i++) {
            if (availableOperatorTravel.size() == 0) {
                availableOperatorTravel.add(lokasiList.get(i).getOperatorTravel());
            } else {
                int counter = 0;
                for (int j = 0; j < availableOperatorTravel.size(); j++) {
                    if (availableOperatorTravel.get(j).getId() == lokasiList.get(i).getOperatorTravel().getId()) {
                        counter++;
                    }
                }
                if (counter == 0) {
                    availableOperatorTravel.add(lokasiList.get(i).getOperatorTravel());
                }
            }

        }

        for (int i = 0; i < availableOperatorTravel.size(); i++) {
            double tmpDistanceMax = 0;
            double tmpDistanceMin = 0;
            for (int j = 0; j < lokasiList.size(); j++) {
                if (availableOperatorTravel.get(i).getId() == lokasiList.get(j).getOperatorTravel().getId()) {
                    if (tmpDistanceMax == 0) {
                        tmpDistanceMax = Double.parseDouble(lokasiList.get(j).getDistance());
                    } else if (tmpDistanceMax < Double.parseDouble(lokasiList.get(j).getDistance())) {
                        tmpDistanceMax = Double.parseDouble(lokasiList.get(j).getDistance());
                    }

                    if (tmpDistanceMin == 0) {
                        tmpDistanceMin = Double.parseDouble(lokasiList.get(j).getDistance());
                    } else if (tmpDistanceMin > Double.parseDouble(lokasiList.get(j).getDistance())) {
                        tmpDistanceMin = Double.parseDouble(lokasiList.get(j).getDistance());
                    }
                }
            }
            Map<String, String> distance = new HashMap<>();
            if (tmpDistanceMax == tmpDistanceMin) {
                distance.put("distance", String.format("%.2f", tmpDistanceMax));
                availableOperatorTravel.get(i).setKeterangan(distance);
            } else {
                distance.put("distance", String.format("%.2f", tmpDistanceMin) + " - " + String.format("%.2f", tmpDistanceMax));
                availableOperatorTravel.get(i).setKeterangan(distance);
            }
        }

        return availableOperatorTravel;
    }
}
