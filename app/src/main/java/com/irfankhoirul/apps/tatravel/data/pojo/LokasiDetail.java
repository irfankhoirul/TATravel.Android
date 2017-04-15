package com.irfankhoirul.apps.tatravel.data.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel LokasiDetail
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

@Parcel
public class LokasiDetail extends BaseModel {
    @SerializedName("id_pemesanan")
    @Expose
    protected int idPemesan;

    @SerializedName("id_penumpang_perjalanan")
    @Expose
    protected int idPenumpangPerjalanan;

    @SerializedName("tipe")
    @Expose
    protected String tipe;

    @SerializedName("latitude")
    @Expose
    protected String latitude;

    @SerializedName("longitude")
    @Expose
    protected String longitude;

    @SerializedName("pemesanan")
    @Expose
    protected Pemesanan pemesanan;

    @SerializedName("penumpang_perjalanan")
    @Expose
    protected PenumpangPerjalanan penumpangPerjalanan;

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
