package com.irfankhoirul.apps.tatravel.model.pojo;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * Merupakan model dari tabel KursiPerjalanan
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class KursiPerjalanan extends CoreModel {
    private int idKursiMobil;
    private String status;
    private KursiMobil kursiMobil;

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

    public KursiMobil getKursiMobil() {
        return kursiMobil;
    }

    public void setKursiMobil(KursiMobil kursiMobil) {
        this.kursiMobil = kursiMobil;
    }
}
