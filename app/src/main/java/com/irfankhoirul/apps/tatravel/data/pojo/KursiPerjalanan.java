package com.irfankhoirul.apps.tatravel.data.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BaseModel;

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
    protected int idKursiMobil;

    @SerializedName("status")
    @Expose
    protected String status;

    @SerializedName("kursi_mobil")
    @Expose
    protected KursiMobil kursiMobil;

    // Tambahan
    protected boolean selected;

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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
