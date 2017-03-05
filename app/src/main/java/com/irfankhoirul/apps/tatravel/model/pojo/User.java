package com.irfankhoirul.apps.tatravel.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.apps.tatravel.base.BaseModel;

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
    private String nama;

    @SerializedName("nomor_handphone")
    @Expose
    private String nomorHandphone;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("paddword")
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
}
