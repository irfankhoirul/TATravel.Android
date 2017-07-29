package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel KursiPerjalanan
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class KursiPerjalanan extends BasePojo implements Parcelable {
    public static final Creator<KursiPerjalanan> CREATOR = new Creator<KursiPerjalanan>() {
        @Override
        public KursiPerjalanan createFromParcel(Parcel in) {
            return new KursiPerjalanan(in);
        }

        @Override
        public KursiPerjalanan[] newArray(int size) {
            return new KursiPerjalanan[size];
        }
    };
    @SerializedName("id_kursi_mobil")
    @Expose
    private int idKursiMobil;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("kursi_mobil")
    @Expose
    private KursiMobil kursiMobil;
    // Tambahan
    private boolean selected;

    protected KursiPerjalanan(Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        idKursiMobil = in.readInt();
        status = in.readString();
        kursiMobil = in.readParcelable(KursiMobil.class.getClassLoader());
        selected = in.readByte() != 0;
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeInt(idKursiMobil);
        dest.writeString(status);
        dest.writeParcelable(kursiMobil, flags);
        dest.writeByte((byte) (selected ? 1 : 0));
    }

    @Override
    public String toString() {
        return "KursiPerjalanan{" +
                "idKursiMobil=" + idKursiMobil +
                ", status='" + status + '\'' +
                ", kursiMobil=" + kursiMobil.toString() +
                ", selected=" + selected +
                '}';
    }
}
