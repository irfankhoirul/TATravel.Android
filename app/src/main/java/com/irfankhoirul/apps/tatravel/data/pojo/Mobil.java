package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel Mobil
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class Mobil extends BasePojo implements Parcelable {
    public static final Creator<Mobil> CREATOR = new Creator<Mobil>() {
        @Override
        public Mobil createFromParcel(Parcel in) {
            return new Mobil(in);
        }

        @Override
        public Mobil[] newArray(int size) {
            return new Mobil[size];
        }
    };
    @SerializedName("id_admin")
    @Expose
    private int idAdmin;
    @SerializedName("id_operator_travel")
    @Expose
    private int idOperatorTravel;
    @SerializedName("produsen")
    @Expose
    private String produsen;
    @SerializedName("tipe")
    @Expose
    private String tipe;
    @SerializedName("tahun")
    @Expose
    private String tahun;
    @SerializedName("plat_nomor")
    @Expose
    private String platNomor;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("admin")
    @Expose
    private Admin admin;

    protected Mobil(Parcel in) {
        idAdmin = in.readInt();
        idOperatorTravel = in.readInt();
        produsen = in.readString();
        tipe = in.readString();
        tahun = in.readString();
        platNomor = in.readString();
        status = in.readString();
        admin = in.readParcelable(Admin.class.getClassLoader());
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

    public String getProdusen() {
        return produsen;
    }

    public void setProdusen(String produsen) {
        this.produsen = produsen;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idAdmin);
        dest.writeInt(idOperatorTravel);
        dest.writeString(produsen);
        dest.writeString(tipe);
        dest.writeString(tahun);
        dest.writeString(platNomor);
        dest.writeString(status);
        dest.writeParcelable(admin, flags);
    }
}
