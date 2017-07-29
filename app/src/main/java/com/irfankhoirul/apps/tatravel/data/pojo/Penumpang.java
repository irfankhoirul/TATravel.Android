package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel Penumpang
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class Penumpang extends BasePojo implements Parcelable {
    public static final Creator<Penumpang> CREATOR = new Creator<Penumpang>() {
        @Override
        public Penumpang createFromParcel(Parcel in) {
            return new Penumpang(in);
        }

        @Override
        public Penumpang[] newArray(int size) {
            return new Penumpang[size];
        }
    };
    @SerializedName("id_user")
    @Expose
    private int idUser;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("user")
    @Expose
    private User user;
    // Tambahan
    private boolean selected;

    protected Penumpang(Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        idUser = in.readInt();
        nama = in.readString();
        selected = in.readByte() != 0;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        dest.writeInt(idUser);
        dest.writeString(nama);
        dest.writeByte((byte) (selected ? 1 : 0));
    }

    @Override
    public String toString() {
        return "Penumpang{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", nama='" + nama + '\'' +
                ", user=" + user +
                ", selected=" + selected +
                '}';
    }
}
