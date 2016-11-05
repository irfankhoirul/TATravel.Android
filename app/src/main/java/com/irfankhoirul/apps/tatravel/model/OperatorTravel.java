package com.irfankhoirul.apps.tatravel.model;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class OperatorTravel extends CoreModel {
    private int idSuperAdmin;
    private String nama;
    private int idKota;
    private String alamat;
    private String telepon;
    private String penanggungJawab;
    private String teleponPenanggungJawab;
    private String status;
    private SuperAdmin superAdmin;
    private Kota kota;

    public int getIdSuperAdmin() {
        return idSuperAdmin;
    }

    public void setIdSuperAdmin(int idSuperAdmin) {
        this.idSuperAdmin = idSuperAdmin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getPenanggungJawab() {
        return penanggungJawab;
    }

    public void setPenanggungJawab(String penanggungJawab) {
        this.penanggungJawab = penanggungJawab;
    }

    public String getTeleponPenanggungJawab() {
        return teleponPenanggungJawab;
    }

    public void setTeleponPenanggungJawab(String teleponPenanggungJawab) {
        this.teleponPenanggungJawab = teleponPenanggungJawab;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SuperAdmin getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(SuperAdmin superAdmin) {
        this.superAdmin = superAdmin;
    }

    public Kota getKota() {
        return kota;
    }

    public void setKota(Kota kota) {
        this.kota = kota;
    }
}
