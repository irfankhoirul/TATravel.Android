package com.irfankhoirul.apps.tatravel.data.pojo;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfankhoirul.mvp_core.base.BasePojo;

/**
 * Merupakan model dari tabel JadwalPerjalanan
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0
 */

public class JadwalPerjalanan extends BasePojo implements Parcelable {
    public static final Creator<JadwalPerjalanan> CREATOR = new Creator<JadwalPerjalanan>() {
        @Override
        public JadwalPerjalanan createFromParcel(android.os.Parcel in) {
            return new JadwalPerjalanan(in);
        }

        @Override
        public JadwalPerjalanan[] newArray(int size) {
            return new JadwalPerjalanan[size];
        }
    };
    @SerializedName("id_admin")
    @Expose
    private int idAdmin;
    @SerializedName("id_operator_travel")
    @Expose
    private int idOperatorTravel;
    @SerializedName("id_lokasi_pemberangkatan")
    @Expose
    private int idLokasiPemberangkatan;
    @SerializedName("id_lokasi_tujuan")
    @Expose
    private int idLokasiTujuan;
    @SerializedName("id_mobil")
    @Expose
    private int idMobil;
    @SerializedName("is_supir")
    @Expose
    private int idSupir;
    @SerializedName("waktu_keberangkatan")
    @Expose
    private String waktuKeberangkatan;
    @SerializedName("waktu_kedatangan")
    @Expose
    private String waktuKedatangan;
    @SerializedName("tanggal_keberangkatan")
    @Expose
    private String tanggalKeberangkatan;
    @SerializedName("tanggal_kedatangan")
    @Expose
    private String tanggalKedatangan;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("harga")
    @Expose
    private int harga;
    @SerializedName("jumlah_kursi_tersedia")
    @Expose
    private int jumlahKursiTersedia;
    @SerializedName("biaya_lokasi_khusus")
    @Expose
    private int biayaLokasiKhusus;
    @SerializedName("admin")
    @Expose
    private Admin admin;
    @SerializedName("operator_travel")
    @Expose
    private OperatorTravel operatorTravel;
    @SerializedName("lokasi_pemberangkatan")
    @Expose
    private Lokasi lokasiPemberangkatan;
    @SerializedName("lokasi_tujuan")
    @Expose
    private Lokasi lokasiTujuan;
    @SerializedName("mobil")
    @Expose
    private Mobil mobil;
    @SerializedName("supir")
    @Expose
    private Supir supir;
    @SerializedName("jarakPenjemputan")
    @Expose
    private double jarakPenjemputan;
    @SerializedName("jarakPengantaran")
    @Expose
    private double jarakPengantaran;
    @SerializedName("quota")
    @Expose
    private int quota;

    protected JadwalPerjalanan(android.os.Parcel in) {
        idAdmin = in.readInt();
        idOperatorTravel = in.readInt();
        idLokasiPemberangkatan = in.readInt();
        idLokasiTujuan = in.readInt();
        idMobil = in.readInt();
        idSupir = in.readInt();
        waktuKeberangkatan = in.readString();
        waktuKedatangan = in.readString();
        tanggalKeberangkatan = in.readString();
        tanggalKedatangan = in.readString();
        timezone = in.readString();
        status = in.readString();
        harga = in.readInt();
        jumlahKursiTersedia = in.readInt();
        biayaLokasiKhusus = in.readInt();
        admin = in.readParcelable(Admin.class.getClassLoader());
        jarakPenjemputan = in.readDouble();
        jarakPengantaran = in.readDouble();
        quota = in.readInt();
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

    public int getIdLokasiPemberangkatan() {
        return idLokasiPemberangkatan;
    }

    public void setIdLokasiPemberangkatan(int idLokasiPemberangkatan) {
        this.idLokasiPemberangkatan = idLokasiPemberangkatan;
    }

    public int getIdLokasiTujuan() {
        return idLokasiTujuan;
    }

    public void setIdLokasiTujuan(int idLokasiTujuan) {
        this.idLokasiTujuan = idLokasiTujuan;
    }

    public int getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(int idMobil) {
        this.idMobil = idMobil;
    }

    public int getIdSupir() {
        return idSupir;
    }

    public void setIdSupir(int idSupir) {
        this.idSupir = idSupir;
    }

    public String getWaktuKeberangkatan() {
        return waktuKeberangkatan;
    }

    public void setWaktuKeberangkatan(String waktuKeberangkatan) {
        this.waktuKeberangkatan = waktuKeberangkatan;
    }

    public String getWaktuKedatangan() {
        return waktuKedatangan;
    }

    public void setWaktuKedatangan(String waktuKedatangan) {
        this.waktuKedatangan = waktuKedatangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJumlahKursiTersedia() {
        return jumlahKursiTersedia;
    }

    public void setJumlahKursiTersedia(int jumlahKursiTersedia) {
        this.jumlahKursiTersedia = jumlahKursiTersedia;
    }

    public int getBiayaLokasiKhusus() {
        return biayaLokasiKhusus;
    }

    public void setBiayaLokasiKhusus(int biayaLokasiKhusus) {
        this.biayaLokasiKhusus = biayaLokasiKhusus;
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

    public Lokasi getLokasiPemberangkatan() {
        return lokasiPemberangkatan;
    }

    public void setLokasiPemberangkatan(Lokasi lokasiPemberangkatan) {
        this.lokasiPemberangkatan = lokasiPemberangkatan;
    }

    public Lokasi getLokasiTujuan() {
        return lokasiTujuan;
    }

    public void setLokasiTujuan(Lokasi lokasiTujuan) {
        this.lokasiTujuan = lokasiTujuan;
    }

    public Mobil getMobil() {
        return mobil;
    }

    public void setMobil(Mobil mobil) {
        this.mobil = mobil;
    }

    public Supir getSupir() {
        return supir;
    }

    public void setSupir(Supir supir) {
        this.supir = supir;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public double getJarakPenjemputan() {
        return jarakPenjemputan;
    }

    public void setJarakPenjemputan(double jarakPenjemputan) {
        this.jarakPenjemputan = jarakPenjemputan;
    }

    public double getJarakPengantaran() {
        return jarakPengantaran;
    }

    public void setJarakPengantaran(double jarakPengantaran) {
        this.jarakPengantaran = jarakPengantaran;
    }

    public String getTanggalKeberangkatan() {
        return tanggalKeberangkatan;
    }

    public void setTanggalKeberangkatan(String tanggalKeberangkatan) {
        this.tanggalKeberangkatan = tanggalKeberangkatan;
    }

    public String getTanggalKedatangan() {
        return tanggalKedatangan;
    }

    public void setTanggalKedatangan(String tanggalKedatangan) {
        this.tanggalKedatangan = tanggalKedatangan;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    @Override
    public String toString() {
        return "JadwalPerjalanan{" +
                "id=" + getId() +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                ", idAdmin=" + idAdmin +
                ", idOperatorTravel=" + idOperatorTravel +
                ", idLokasiPemberangkatan=" + idLokasiPemberangkatan +
                ", idLokasiTujuan=" + idLokasiTujuan +
                ", idMobil=" + idMobil +
                ", idSupir=" + idSupir +
                ", waktuKeberangkatan=" + waktuKeberangkatan +
                ", waktuKedatangan=" + waktuKedatangan +
                ", status='" + status + '\'' +
                ", harga=" + harga +
                ", jumlahKursiTersedia=" + jumlahKursiTersedia +
                ", biayaLokasiKhusus=" + biayaLokasiKhusus +
                ", admin=" + admin.toString() +
                ", operatorTravel=" + operatorTravel +
                ", lokasiPemberangkatan=" + lokasiPemberangkatan +
                ", lokasiTujuan=" + lokasiTujuan +
                ", mobil=" + mobil +
                ", supir=" + supir +
                '}';

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeInt(idAdmin);
        dest.writeInt(idOperatorTravel);
        dest.writeInt(idLokasiPemberangkatan);
        dest.writeInt(idLokasiTujuan);
        dest.writeInt(idMobil);
        dest.writeInt(idSupir);
        dest.writeString(waktuKeberangkatan);
        dest.writeString(waktuKedatangan);
        dest.writeString(tanggalKeberangkatan);
        dest.writeString(tanggalKedatangan);
        dest.writeString(timezone);
        dest.writeString(status);
        dest.writeInt(harga);
        dest.writeInt(jumlahKursiTersedia);
        dest.writeInt(biayaLokasiKhusus);
        dest.writeParcelable(admin, flags);
        dest.writeDouble(jarakPenjemputan);
        dest.writeDouble(jarakPengantaran);
        dest.writeInt(quota);
    }
}
