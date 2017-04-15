package com.irfankhoirul.apps.tatravel.data.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel Admin
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0
 */

@Parcel
public class Admin extends BaseModel {
    @SerializedName("id_super_admin")
    @Expose
    protected int idSuperAdmin;

    @SerializedName("id_operator_travel")
    @Expose
    protected int idOperatorTravel;

    @SerializedName("id_user")
    @Expose
    protected int idUser;

    @SerializedName("status")
    @Expose
    protected String status;

    @SerializedName("super_admin")
    @Expose
    protected SuperAdmin superAdmin;

    @SerializedName("user")
    @Expose
    protected User user;

    public Admin() {
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
    public String toString() {
        return "Admin{" +
                "id=" + getId() +
                ", createdAt='" + getCreatedAt() + '\'' +
                ", updatedAt=" + getUpdatedAt() +

                ", idSuperAdmin=" + idSuperAdmin +
                ", idUser=" + idUser +
                ", idOperatorTravel=" + idOperatorTravel +
                ", status='" + status + '\'' +
                ", superAdmin=" + superAdmin +
                ", user=" + user +
                '}';
    }
}
