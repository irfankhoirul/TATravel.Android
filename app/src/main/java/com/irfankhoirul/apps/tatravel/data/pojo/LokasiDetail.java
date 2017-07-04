package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel LokasiDetail
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class LokasiDetail extends BasePojo implements Parcelable {

    public static final Creator<LokasiDetail> CREATOR = new Creator<LokasiDetail>() {
        @Override
        public LokasiDetail createFromParcel(Parcel in) {
            return new LokasiDetail(in);
        }

        @Override
        public LokasiDetail[] newArray(int size) {
            return new LokasiDetail[size];
        }
    };
    @SerializedName("id_penumpang_perjalanan")
    @Expose
    private int idPenumpangPerjalanan;
    @SerializedName("tipe")
    @Expose
    private String tipe;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("pemesanan")
    @Expose
    private Pemesanan pemesanan;
    @SerializedName("penumpangPerjalanan")
    @Expose
    private PenumpangPerjalanan penumpangPerjalanan;
    @SerializedName("alamat")
    @Expose
    private String alamat;

    protected LokasiDetail(Parcel in) {
        idPenumpangPerjalanan = in.readInt();
        tipe = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        alamat = in.readString();
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idPenumpangPerjalanan);
        dest.writeString(tipe);
        dest.writeString(latitude);
        dest.writeString(longitude);
        dest.writeString(alamat);
    }
}
