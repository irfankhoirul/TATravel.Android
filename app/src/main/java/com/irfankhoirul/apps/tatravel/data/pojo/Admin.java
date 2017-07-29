package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel Admin
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0
 */

public class Admin extends BasePojo implements Parcelable {
    public static final Creator<Admin> CREATOR = new Creator<Admin>() {
        @Override
        public Admin createFromParcel(Parcel in) {
            return new Admin(in);
        }

        @Override
        public Admin[] newArray(int size) {
            return new Admin[size];
        }
    };
    @SerializedName("id_super_admin")
    @Expose
    private int idSuperAdmin;
    @SerializedName("id_operator_travel")
    @Expose
    private int idOperatorTravel;
    @SerializedName("id_user")
    @Expose
    private int idUser;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("super_admin")
    @Expose
    private SuperAdmin superAdmin;
    @SerializedName("user")
    @Expose
    private User user;

    public Admin() {
    }

    protected Admin(Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        idSuperAdmin = in.readInt();
        idOperatorTravel = in.readInt();
        idUser = in.readInt();
        status = in.readString();
    }

    public int getIdSuperAdmin() {
        return idSuperAdmin;
    }

    public void setIdSuperAdmin(int idSuperAdmin) {
        this.idSuperAdmin = idSuperAdmin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public SuperAdmin getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(SuperAdmin superAdmin) {
        this.superAdmin = superAdmin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getIdOperatorTravel() {
        return idOperatorTravel;
    }

    public void setIdOperatorTravel(int idOperatorTravel) {
        this.idOperatorTravel = idOperatorTravel;
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
        dest.writeInt(idSuperAdmin);
        dest.writeInt(idOperatorTravel);
        dest.writeInt(idUser);
        dest.writeString(status);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "idSuperAdmin=" + idSuperAdmin +
                ", idOperatorTravel=" + idOperatorTravel +
                ", idUser=" + idUser +
                ", status='" + status + '\'' +
                ", superAdmin=" + superAdmin.toString() +
                ", user=" + user.toString() +
                '}';
    }
}
