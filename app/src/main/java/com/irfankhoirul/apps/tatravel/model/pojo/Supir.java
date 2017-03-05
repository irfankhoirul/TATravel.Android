package com.irfankhoirul.apps.tatravel.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.apps.tatravel.base.BaseModel;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel Supir
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

@Parcel
public class Supir extends BaseModel {
    @SerializedName("id_admin")
    @Expose
    private int idAdmin;

    @SerializedName("id_operator_travel")
    @Expose
    private int idOperatorTravel;

    @SerializedName("kode_registrasi")
    @Expose
    private String kodeRegistrasi;

    @SerializedName("id_user")
    @Expose
    private int idUser;

    @SerializedName("admin")
    @Expose
    private Admin admin;

    @SerializedName("operator_travel")
    @Expose
    private OperatorTravel operatorTravel;

    @SerializedName("user")
    @Expose
    private User user;

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

    public String getKodeRegistrasi() {
        return kodeRegistrasi;
    }

    public void setKodeRegistrasi(String kodeRegistrasi) {
        this.kodeRegistrasi = kodeRegistrasi;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
