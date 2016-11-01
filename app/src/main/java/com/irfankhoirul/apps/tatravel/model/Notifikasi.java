package com.irfankhoirul.apps.tatravel.model;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * @author Irfan Khoirul Muhlishin
 * @since 11/1/2016
 */

public class Notifikasi extends CoreModel {
    private int idUserDevice;
    private String pesan;
    private String status;
    private String tipe;

    public int getIdUserDevice() {
        return idUserDevice;
    }

    public void setIdUserDevice(int idUserDevice) {
        this.idUserDevice = idUserDevice;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
}
