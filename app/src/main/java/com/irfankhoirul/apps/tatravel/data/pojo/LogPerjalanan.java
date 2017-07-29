package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel LogPerjalanan
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class LogPerjalanan extends BasePojo implements Parcelable {
    public static final Creator<LogPerjalanan> CREATOR = new Creator<LogPerjalanan>() {
        @Override
        public LogPerjalanan createFromParcel(Parcel in) {
            return new LogPerjalanan(in);
        }

        @Override
        public LogPerjalanan[] newArray(int size) {
            return new LogPerjalanan[size];
        }
    };
    @SerializedName("id_jadwal_perjalanan")
    @Expose
    private int idJadwalPerjalanan;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("jadwal_perjalanan")
    @Expose
    private JadwalPerjalanan jadwalPerjalanan;

    protected LogPerjalanan(Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        idJadwalPerjalanan = in.readInt();
        latitude = in.readString();
        longitude = in.readString();
        jadwalPerjalanan = in.readParcelable(JadwalPerjalanan.class.getClassLoader());
    }

    public int getIdJadwalPerjalanan() {
        return idJadwalPerjalanan;
    }

    public void setIdJadwalPerjalanan(int idJadwalPerjalanan) {
        this.idJadwalPerjalanan = idJadwalPerjalanan;
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

    public JadwalPerjalanan getJadwalPerjalanan() {
        return jadwalPerjalanan;
    }

    public void setJadwalPerjalanan(JadwalPerjalanan jadwalPerjalanan) {
        this.jadwalPerjalanan = jadwalPerjalanan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeInt(idJadwalPerjalanan);
        dest.writeString(latitude);
        dest.writeString(longitude);
        dest.writeParcelable(jadwalPerjalanan, flags);
    }

    @Override
    public String toString() {
        return "LogPerjalanan{" +
                "idJadwalPerjalanan=" + idJadwalPerjalanan +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", jadwalPerjalanan=" + jadwalPerjalanan.toString() +
                '}';
    }
}
