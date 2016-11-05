package com.irfankhoirul.apps.tatravel.model;

import com.irfankhoirul.apps.tatravel.core.CoreModel;

/**
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class Pemesanan extends CoreModel {
    private int idUser;
    private int idJadwalPerjalanan;
    private String kodePemesanan;
    private User user;
    private JadwalPerjalanan jadwalPerjalanan;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdJadwalPerjalanan() {
        return idJadwalPerjalanan;
    }

    public void setIdJadwalPerjalanan(int idJadwalPerjalanan) {
        this.idJadwalPerjalanan = idJadwalPerjalanan;
    }

    public String getKodePemesanan() {
        return kodePemesanan;
    }

    public void setKodePemesanan(String kodePemesanan) {
        this.kodePemesanan = kodePemesanan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JadwalPerjalanan getJadwalPerjalanan() {
        return jadwalPerjalanan;
    }

    public void setJadwalPerjalanan(JadwalPerjalanan jadwalPerjalanan) {
        this.jadwalPerjalanan = jadwalPerjalanan;
    }
}
