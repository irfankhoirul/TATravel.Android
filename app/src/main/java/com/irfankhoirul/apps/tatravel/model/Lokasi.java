package com.irfankhoirul.apps.tatravel.model;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * @author Irfan Khoirul Muhlishin
 * @since 11/1/2016
 */

public class Lokasi extends CoreModel {
    private int idAdmin;
    private int idOperatorTravel;
    private int idKota;
    private String alamat;

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdOperatorTravel() {
        return idOperatorTravel;
    }

    public void setIdOperatorTravel(int idOperatorTravel) {
        this.idOperatorTravel = idOperatorTravel;
    }

    public int getIdKota() {
        return idKota;
    }

    public void setIdKota(int idKota) {
        this.idKota = idKota;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
