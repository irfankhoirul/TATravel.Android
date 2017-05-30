package com.irfankhoirul.apps.tatravel.data.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BaseModel;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel PenumpangPerjalanan
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

@Parcel
public class PenumpangPerjalanan extends BaseModel {
    @SerializedName("id_penumpang")
    @Expose
    protected int idPenumpang;

    @SerializedName("id_pemesan")
    @Expose
    protected int idPemesan;

    @SerializedName("penumpang")
    @Expose
    protected Penumpang penumpang;

    @SerializedName("pemesanan")
    @Expose
    protected Pemesanan pemesanan;

    @SerializedName("kursi_perjalanan")
    @Expose
    protected KursiPerjalanan kursiPerjalanan;

    public int getIdPenumpang() {
        return idPenumpang;
    }

    public void setIdPenumpang(int idPenumpang) {
        this.idPenumpang = idPenumpang;
    }

    public int getIdPemesan() {
        return idPemesan;
    }

    public void setIdPemesan(int idPemesan) {
        this.idPemesan = idPemesan;
    }

    public Penumpang getPenumpang() {
        return penumpang;
    }

    public void setPenumpang(Penumpang penumpang) {
        this.penumpang = penumpang;
    }

    public Pemesanan getPemesanan() {
        return pemesanan;
    }

    public void setPemesanan(Pemesanan pemesanan) {
        this.pemesanan = pemesanan;
    }

    public KursiPerjalanan getKursiPerjalanan() {
        return kursiPerjalanan;
    }

    public void setKursiPerjalanan(KursiPerjalanan kursiPerjalanan) {
        this.kursiPerjalanan = kursiPerjalanan;
    }
}
