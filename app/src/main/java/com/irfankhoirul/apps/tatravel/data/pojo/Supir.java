package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel Supir
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class Supir extends BasePojo implements Parcelable {
    public static final Creator<Supir> CREATOR = new Creator<Supir>() {
        @Override
        public Supir createFromParcel(Parcel in) {
            return new Supir(in);
        }

        @Override
        public Supir[] newArray(int size) {
            return new Supir[size];
        }
    };
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

    protected Supir(Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
        idAdmin = in.readInt();
        idOperatorTravel = in.readInt();
        kodeRegistrasi = in.readString();
        idUser = in.readInt();
        admin = in.readParcelable(Admin.class.getClassLoader());
        operatorTravel = in.readParcelable(OperatorTravel.class.getClassLoader());
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeInt(idAdmin);
        dest.writeInt(idOperatorTravel);
        dest.writeString(kodeRegistrasi);
        dest.writeInt(idUser);
        dest.writeParcelable(admin, flags);
        dest.writeParcelable(operatorTravel, flags);
    }
}
