package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel RatingPerjalanan
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class RatingPerjalanan extends BasePojo implements Parcelable {
    public static final Creator<RatingPerjalanan> CREATOR = new Creator<RatingPerjalanan>() {
        @Override
        public RatingPerjalanan createFromParcel(Parcel in) {
            return new RatingPerjalanan(in);
        }

        @Override
        public RatingPerjalanan[] newArray(int size) {
            return new RatingPerjalanan[size];
        }
    };
    @SerializedName("id_jadwal_perjalanan")
    @Expose
    private int idJadwalPerjalanan;
    @SerializedName("id_user")
    @Expose
    private int idUser;
    @SerializedName("rating")
    @Expose
    private int rating;
    @SerializedName("jadwal_perjalanan")
    @Expose
    private JadwalPerjalanan jadwalPerjalanan;
    @SerializedName("user")
    @Expose
    private User user;

    protected RatingPerjalanan(Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        idJadwalPerjalanan = in.readInt();
        idUser = in.readInt();
        rating = in.readInt();
        jadwalPerjalanan = in.readParcelable(JadwalPerjalanan.class.getClassLoader());
    }

    public int getIdJadwalPerjalanan() {
        return idJadwalPerjalanan;
    }

    public void setIdJadwalPerjalanan(int idJadwalPerjalanan) {
        this.idJadwalPerjalanan = idJadwalPerjalanan;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public JadwalPerjalanan getJadwalPerjalanan() {
        return jadwalPerjalanan;
    }

    public void setJadwalPerjalanan(JadwalPerjalanan jadwalPerjalanan) {
        this.jadwalPerjalanan = jadwalPerjalanan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        dest.writeInt(idUser);
        dest.writeInt(rating);
        dest.writeParcelable(jadwalPerjalanan, flags);
    }
}
