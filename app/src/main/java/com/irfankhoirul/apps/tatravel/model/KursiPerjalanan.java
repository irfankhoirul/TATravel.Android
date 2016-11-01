package com.irfankhoirul.apps.tatravel.model;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * @author Irfan Khoirul Muhlishin
 * @since 11/1/2016
 */

public class KursiPerjalanan extends CoreModel {
    private int idKursiMobil;
    private String status;

    public int getIdKursiMobil() {
        return idKursiMobil;
    }

    public void setIdKursiMobil(int idKursiMobil) {
        this.idKursiMobil = idKursiMobil;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
