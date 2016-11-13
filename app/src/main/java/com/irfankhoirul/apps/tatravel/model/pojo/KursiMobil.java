package com.irfankhoirul.apps.tatravel.model.pojo;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * Merupakan model dari tabel KursiMobil
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class KursiMobil extends CoreModel {
    private int idMobil;
    private String nomor;
    private Mobil mobil;

    public int getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(int idMobil) {
        this.idMobil = idMobil;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public Mobil getMobil() {
        return mobil;
    }

    public void setMobil(Mobil mobil) {
        this.mobil = mobil;
    }
}
