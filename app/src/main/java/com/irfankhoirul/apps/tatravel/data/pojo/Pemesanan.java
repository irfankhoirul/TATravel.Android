package com.irfankhoirul.apps.tatravel.data.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel Pemesanan
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

@Parcel
public class Pemesanan extends BaseModel {
    @SerializedName("id_user")
    @Expose
    protected int idUser;

    @SerializedName("id_jadwal_perjalanan")
    @Expose
    protected int idJadwalPerjalanan;

    @SerializedName("kode_pemesanan")
    @Expose
    protected String kodePemesanan;

    @SerializedName("user")
    @Expose
    protected User user;

    @SerializedName("jadwal_perjalanan")
    @Expose
    protected JadwalPerjalanan jadwalPerjalanan;

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