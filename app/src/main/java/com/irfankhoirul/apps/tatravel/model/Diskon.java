package com.irfankhoirul.apps.tatravel.model;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * @author Irfan Khoirul Muhlishin
 * @since 11/1/2016
 */

public class Diskon extends CoreModel {
    private int idJadwalPerjalanan;
    private int persentase;

    public int getIdJadwalPerjalanan() {
        return idJadwalPerjalanan;
    }

    public void setIdJadwalPerjalanan(int idJadwalPerjalanan) {
        this.idJadwalPerjalanan = idJadwalPerjalanan;
    }

    public int getPersentase() {
        return persentase;
    }

    public void setPersentase(int persentase) {
        this.persentase = persentase;
    }
}
