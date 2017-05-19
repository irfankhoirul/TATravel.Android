package com.irfankhoirul.apps.tatravel.data.source.locale.cart;

import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.data.pojo.KursiPerjalanan;
import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;

import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 5/9/2017.
 */

public interface CartRepository {

    Map<String, String> getDeparture();

    void setDeparture(Map<String, String> departureData);

    void clearDeparture();

    Map<String, String> getDestination();

    void setDestination(Map<String, String> destinationData);

    void clearDestination();

    long getTanggalKeberangkatan();

    void setTanggalKeberangkatan(long date);

    void clearTanggalKeberangkatan();

    boolean isPulangPergi();

    void setPulangPergi(boolean isPulangPergi);

    long getTanggalKepulangan();

    void setTanggalKepulangan(long date);

    void clearTanggalKepulangan();

    List<Penumpang> getPenumpang();

    void setPenumpang(List<Penumpang> penumpangList);

    void clearPenumpang();

    JadwalPerjalanan getSchedule();

    void setSchedule(JadwalPerjalanan schedule);

    void clearSchedule();

    List<KursiPerjalanan> getSeat();

    void setSeat(List<KursiPerjalanan> seat);

    void clearSeat();

    long getSeatSetTime();

    void setSeatSetTime(long seatSetTime);

    void clearSeatSetTime();

    Pemesanan getLastReservation();

    void setLastReservation(Pemesanan reservation);
}
