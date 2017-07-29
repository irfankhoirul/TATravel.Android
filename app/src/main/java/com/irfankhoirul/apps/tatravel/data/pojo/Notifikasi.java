package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel Notifikasi
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class Notifikasi extends BasePojo implements Parcelable {
    public static final Creator<Notifikasi> CREATOR = new Creator<Notifikasi>() {
        @Override
        public Notifikasi createFromParcel(android.os.Parcel in) {
            return new Notifikasi(in);
        }

        @Override
        public Notifikasi[] newArray(int size) {
            return new Notifikasi[size];
        }
    };
    @SerializedName("id_user_device")
    @Expose
    private int idUserDevice;
    @SerializedName("pesan")
    @Expose
    private String pesan;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tipe")
    @Expose
    private String tipe;
    @SerializedName("user_device")
    @Expose
    private UserDevice userDevice;

    protected Notifikasi(android.os.Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        idUserDevice = in.readInt();
        pesan = in.readString();
        status = in.readString();
        tipe = in.readString();
    }

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

    public UserDevice getUserDevice() {
        return userDevice;
    }

    public void setUserDevice(UserDevice userDevice) {
        this.userDevice = userDevice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeInt(idUserDevice);
        dest.writeString(pesan);
        dest.writeString(status);
        dest.writeString(tipe);
    }

    @Override
    public String toString() {
        return "Notifikasi{" +
                "idUserDevice=" + idUserDevice +
                ", pesan='" + pesan + '\'' +
                ", status='" + status + '\'' +
                ", tipe='" + tipe + '\'' +
                ", userDevice=" + userDevice.toString() +
                '}';
    }
}
