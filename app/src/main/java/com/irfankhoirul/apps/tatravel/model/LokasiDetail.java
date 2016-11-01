package com.irfankhoirul.apps.tatravel.model;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * @author Irfan Khoirul Muhlishin
 * @since 11/1/2016
 */

public class LokasiDetail extends CoreModel {
    private int idPemesan;
    private int idPenumpangPerjalanan;
    private String tipe;
    private String latitude;
    private String longitude;

    public int getIdPemesan() {
        return idPemesan;
    }

    public void setIdPemesan(int idPemesan) {
        this.idPemesan = idPemesan;
    }

    public int getIdPenumpangPerjalanan() {
        return idPenumpangPerjalanan;
    }

    public void setIdPenumpangPerjalanan(int idPenumpangPerjalanan) {
        this.idPenumpangPerjalanan = idPenumpangPerjalanan;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
