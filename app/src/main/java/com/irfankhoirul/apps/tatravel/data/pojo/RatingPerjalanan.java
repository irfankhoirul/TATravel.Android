package com.irfankhoirul.apps.tatravel.data.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel RatingPerjalanan
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

@Parcel
public class RatingPerjalanan extends BaseModel {
    @SerializedName("id_jadwal_perjalanan")
    @Expose
    protected int idJadwalPerjalanan;

    @SerializedName("id_user")
    @Expose
    protected int idUser;

    @SerializedName("rating")
    @Expose
    protected int rating;

    @SerializedName("jadwal_perjalanan")
    @Expose
    protected JadwalPerjalanan jadwalPerjalanan;

    @SerializedName("user")
    @Expose
    protected User user;

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
}
