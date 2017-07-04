package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel User
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

public class User extends BasePojo implements Parcelable {
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("nomor_handphone")
    @Expose
    private String nomorHandphone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("salt")
    @Expose
    private String salt;
    @SerializedName("reset_token")
    @Expose
    private String resetToken;
    @SerializedName("registration_step")
    @Expose
    private String registrationStep;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("id_kota")
    @Expose
    private int idKota;
    @SerializedName("id_provinsi")
    @Expose
    private int idProvinsi;
    @SerializedName("tipe")
    @Expose
    private String tipe;
    @SerializedName("kota")
    @Expose
    private Kota kota;
    @SerializedName("provinsi")
    @Expose
    private Provinsi provinsi;
    @SerializedName("token")
    @Expose
    private UserToken userToken;
    @SerializedName("use_social_login")
    @Expose
    private boolean useSocialLogin;

    protected User(Parcel in) {
        nama = in.readString();
        nomorHandphone = in.readString();
        email = in.readString();
        password = in.readString();
        salt = in.readString();
        resetToken = in.readString();
        registrationStep = in.readString();
        alamat = in.readString();
        idKota = in.readInt();
        idProvinsi = in.readInt();
        tipe = in.readString();
        kota = in.readParcelable(Kota.class.getClassLoader());
        provinsi = in.readParcelable(Provinsi.class.getClassLoader());
        useSocialLogin = in.readByte() != 0;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorHandphone() {
        return nomorHandphone;
    }

    public void setNomorHandphone(String nomorHandphone) {
        this.nomorHandphone = nomorHandphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public String getRegistrationStep() {
        return registrationStep;
    }

    public void setRegistrationStep(String registrationStep) {
        this.registrationStep = registrationStep;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getIdKota() {
        return idKota;
    }

    public void setIdKota(int idKota) {
        this.idKota = idKota;
    }

    public int getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(int idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public Kota getKota() {
        return kota;
    }

    public void setKota(Kota kota) {
        this.kota = kota;
    }

    public Provinsi getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(Provinsi provinsi) {
        this.provinsi = provinsi;
    }

    public UserToken getUserToken() {
        return userToken;
    }

    public void setUserToken(UserToken userToken) {
        this.userToken = userToken;
    }

    public boolean isUseSocialLogin() {
        return useSocialLogin;
    }

    public void setUseSocialLogin(boolean useSocialLogin) {
        this.useSocialLogin = useSocialLogin;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(nomorHandphone);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(salt);
        dest.writeString(resetToken);
        dest.writeString(registrationStep);
        dest.writeString(alamat);
        dest.writeInt(idKota);
        dest.writeInt(idProvinsi);
        dest.writeString(tipe);
        dest.writeParcelable(kota, flags);
        dest.writeParcelable(provinsi, flags);
        dest.writeByte((byte) (useSocialLogin ? 1 : 0));
    }
}
