package com.irfankhoirul.apps.tatravel.data.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Merupakan model dari tabel User
 *
 * @author  Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since   1.0
 */

@Parcel
public class User extends BaseModel {
    @SerializedName("nama")
    @Expose
    protected String nama;

    @SerializedName("nomor_handphone")
    @Expose
    protected String nomorHandphone;

    @SerializedName("email")
    @Expose
    protected String email;

    @SerializedName("paddword")
    @Expose
    protected String password;

    @SerializedName("salt")
    @Expose
    protected String salt;

    @SerializedName("reset_token")
    @Expose
    protected String resetToken;

    @SerializedName("registration_step")
    @Expose
    protected String registrationStep;

    @SerializedName("alamat")
    @Expose
    protected String alamat;

    @SerializedName("id_kota")
    @Expose
    protected int idKota;

    @SerializedName("id_provinsi")
    @Expose
    protected int idProvinsi;

    @SerializedName("tipe")
    @Expose
    protected String tipe;

    @SerializedName("kota")
    @Expose
    protected Kota kota;

    @SerializedName("provinsi")
    @Expose
    protected Provinsi provinsi;

    @SerializedName("token")
    @Expose
    protected UserToken userToken;

    @SerializedName("use_social_login")
    @Expose
    protected boolean useSocialLogin;

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
}
