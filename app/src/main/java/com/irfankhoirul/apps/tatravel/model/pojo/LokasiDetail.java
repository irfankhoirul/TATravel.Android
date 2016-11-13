package com.irfankhoirul.apps.tatravel.model.pojo;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * Merupakan model dari tabel LokasiDetail
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class LokasiDetail extends CoreModel {
    private int idPemesan;
    private int idPenumpangPerjalanan;
    private String tipe;
    private String latitude;
    private String longitude;
    private Pemesanan pemesanan;
    private PenumpangPerjalanan penumpangPerjalanan;

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

    public Pemesanan getPemesanan() {
        return pemesanan;
    }

    public void setPemesanan(Pemesanan pemesanan) {
        this.pemesanan = pemesanan;
    }

    public PenumpangPerjalanan getPenumpangPerjalanan() {
        return penumpangPerjalanan;
    }

    public void setPenumpangPerjalanan(PenumpangPerjalanan penumpangPerjalanan) {
        this.penumpangPerjalanan = penumpangPerjalanan;
    }
}
