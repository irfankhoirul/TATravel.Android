package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel Lokasi
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class Lokasi extends BasePojo implements Parcelable {
    public static final Creator<Lokasi> CREATOR = new Creator<Lokasi>() {
        @Override
        public Lokasi createFromParcel(Parcel in) {
            return new Lokasi(in);
        }

        @Override
        public Lokasi[] newArray(int size) {
            return new Lokasi[size];
        }
    };
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("id_admin")
    @Expose
    private int idAdmin;
    @SerializedName("id_operator_travel")
    @Expose
    private int idOperatorTravel;
    @SerializedName("id_kota")
    @Expose
    private int idKota;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("admin")
    @Expose
    private Admin admin;
    @SerializedName("operator_travel")
    @Expose
    private OperatorTravel operatorTravel;
    @SerializedName("kota")
    @Expose
    private Kota kota;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("distance")
    @Expose
    private String distance;

    protected Lokasi(Parcel in) {
        nama = in.readString();
        idAdmin = in.readInt();
        idOperatorTravel = in.readInt();
        idKota = in.readInt();
        alamat = in.readString();
        admin = in.readParcelable(Admin.class.getClassLoader());
        kota = in.readParcelable(Kota.class.getClassLoader());
        latitude = in.readString();
        longitude = in.readString();
        distance = in.readString();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdOperatorTravel() {
        return idOperatorTravel;
    }

    public void setIdOperatorTravel(int idOperatorTravel) {
        this.idOperatorTravel = idOperatorTravel;
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public OperatorTravel getOperatorTravel() {
        return operatorTravel;
    }

    public void setOperatorTravel(OperatorTravel operatorTravel) {
        this.operatorTravel = operatorTravel;
    }

    public Kota getKota() {
        return kota;
    }

    public void setKota(Kota kota) {
        this.kota = kota;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Lokasi{" +
                "idAdmin=" + idAdmin +
                ", idOperatorTravel=" + idOperatorTravel +
                ", idKota=" + idKota +
                ", alamat='" + alamat + '\'' +
                ", admin=" + admin +
                ", operatorTravel=" + operatorTravel +
                ", kota=" + kota +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeInt(idAdmin);
        dest.writeInt(idOperatorTravel);
        dest.writeInt(idKota);
        dest.writeString(alamat);
        dest.writeParcelable(admin, flags);
        dest.writeParcelable(kota, flags);
        dest.writeString(latitude);
        dest.writeString(longitude);
        dest.writeString(distance);
    }
}
