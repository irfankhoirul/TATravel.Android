package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel KursiMobil
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class KursiMobil extends BasePojo implements Parcelable {
    public static final Creator<KursiMobil> CREATOR = new Creator<KursiMobil>() {
        @Override
        public KursiMobil createFromParcel(Parcel in) {
            return new KursiMobil(in);
        }

        @Override
        public KursiMobil[] newArray(int size) {
            return new KursiMobil[size];
        }
    };
    @SerializedName("id_mobil")
    @Expose
    private int idMobil;
    @SerializedName("nomor")
    @Expose
    private String nomor;
    @SerializedName("mobil")
    @Expose
    private Mobil mobil;

    protected KursiMobil(Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        idMobil = in.readInt();
        nomor = in.readString();
    }

    public int getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(int idMobil) {
        this.idMobil = idMobil;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public Mobil getMobil() {
        return mobil;
    }

    public void setMobil(Mobil mobil) {
        this.mobil = mobil;
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
        dest.writeInt(idMobil);
        dest.writeString(nomor);
    }

    @Override
    public String toString() {
        return "KursiMobil{" +
                "idMobil=" + idMobil +
                ", nomor='" + nomor + '\'' +
                ", mobil=" + mobil.toString() +
                '}';
    }
}
