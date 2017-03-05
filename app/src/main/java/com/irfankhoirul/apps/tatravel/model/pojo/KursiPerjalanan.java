package com.irfankhoirul.apps.tatravel.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.apps.tatravel.base.BaseModel;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel KursiPerjalanan
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

@Parcel
public class KursiPerjalanan extends BaseModel {
    @SerializedName("id_kursi_mobil")
    @Expose
    private int idKursiMobil;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("kursi_mobil")
    @Expose
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
