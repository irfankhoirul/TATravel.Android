package com.irfankhoirul.apps.tatravel.data.source.locale.cart;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.data.pojo.KursiPerjalanan;
import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;

import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 5/7/2017.
 */

public class Cart implements CartRepository {

    private static String SHARED_PREFERENCE_NAME = "Cart";
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    private Cart cart;

    public Cart(Context mContext) {
        sharedPref = mContext.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        editor.clear();
        editor.apply();
    }

    @Override
    public void clearCart() {
        editor.clear().apply();
    }

    @Override
    public Map<String, String> getDeparture() {
        if (sharedPref.getString("departure", null) != null) {
            return new Gson().fromJson(sharedPref.getString("departure", null), new TypeToken<Map<String, String>>() {
            }.getType());
        }
        return null;
    }

    /**
     * Data :
     * - Address
     * - Latitude
     * - Longitude
     * - OperatorTravelId
     * - locationIds (JsonArray)
     */
    @Override
    public void setDeparture(Map<String, String> departureData) {
        editor.putString("departure", new Gson().toJson(departureData));
        editor.apply();
    }

    @Override
    public void clearDeparture() {
        editor.remove("departure");
        editor.apply();
    }

    @Override
    public Map<String, String> getDestination() {
        if (sharedPref.getString("destination", null) != null) {
            return new Gson().fromJson(sharedPref.getString("destination", null), new TypeToken<Map<String, String>>() {
            }.getType());
        }
        return null;
    }

    /**
     * Data :
     * - Address
     * - Latitude
     * - Longitude
     * - OperatorTravelId
     */
    @Override
    public void setDestination(Map<String, String> destinationData) {
        editor.putString("destination", new Gson().toJson(destinationData));
        editor.apply();
    }

    @Override
    public void clearDestination() {
        editor.remove("destination");
        editor.apply();
    }

    @Override
    public long getTanggalKeberangkatan() {
        return sharedPref.getLong("tanggalKeberangkatan", 0);
    }

    @Override
    public void setTanggalKeberangkatan(long date) {
        editor.putLong("tanggalKeberangkatan", date);
        editor.apply();
    }

    @Override
    public void clearTanggalKeberangkatan() {
        editor.remove("tanggalKeberangkatan");
        editor.apply();
    }

    @Override
    public boolean isPulangPergi() {
        return sharedPref.getBoolean("pulangPergi", false);
    }

    @Override
    public void setPulangPergi(boolean isPulangPergi) {
        editor.putBoolean("pulangPergi", isPulangPergi);
        editor.apply();
    }

    @Override
    public long getTanggalKepulangan() {
        return sharedPref.getLong("tanggalKepulangan", 0);
    }

    @Override
    public void setTanggalKepulangan(long date) {
        editor.putLong("tanggalKepulangan", date);
        editor.apply();
    }

    @Override
    public void clearTanggalKepulangan() {
        editor.remove("tanggalKepulangan");
        editor.apply();
    }

    @Override
    public List<Penumpang> getPenumpang() {
        if (sharedPref.getString("penumpang", null) != null) {
            return new Gson().fromJson(sharedPref.getString("penumpang", null), new TypeToken<List<Penumpang>>() {
            }.getType());
        }
        return null;
    }

    /**
     * Data : List<Penumpang></>
     */
    @Override
    public void setPenumpang(List<Penumpang> penumpangList) {
        editor.putString("penumpang", new Gson().toJson(penumpangList));
        editor.apply();
    }

    @Override
    public void clearPenumpang() {
        editor.remove("penumpang");
        editor.apply();
    }

    @Override
    public JadwalPerjalanan getSchedule() {
        if (sharedPref.getString("jadwalPerjalanan", null) != null) {
            return new Gson().fromJson(sharedPref.getString("jadwalPerjalanan", null), JadwalPerjalanan.class);
        }
        return null;
    }

    @Override
    public void setSchedule(JadwalPerjalanan schedule) {
        editor.putString("jadwalPerjalanan", new Gson().toJson(schedule));
        editor.apply();
    }

    @Override
    public void clearSchedule() {
        editor.remove("jadwalPerjalanan");
        editor.apply();
    }

    @Override
    public List<KursiPerjalanan> getSeat() {
        if (sharedPref.getString("kursiPerjalanan", null) != null) {
            return new Gson().fromJson(sharedPref.getString("kursiPerjalanan", null), new TypeToken<List<KursiPerjalanan>>() {
            }.getType());
        }
        return null;
    }

    @Override
    public void setSeat(List<KursiPerjalanan> seats) {
        editor.putString("kursiPerjalanan", new Gson().toJson(seats));
        editor.apply();
    }

    @Override
    public void clearSeat() {
        editor.remove("kursiPerjalanan");
        editor.apply();
    }

    @Override
    public long getSeatSetTime() {
        return sharedPref.getLong("seatSetTime", 0);
    }

    @Override
    public void setSeatSetTime(long seatSetTime) {
        editor.putLong("seatSetTime", seatSetTime);
        editor.apply();
    }

    @Override
    public void clearSeatSetTime() {
        editor.remove("seatSetTime");
        editor.apply();
    }

    @Override
    public Pemesanan getLastReservation() {
        if (sharedPref.getString("reservation", null) != null) {
            return new Gson().fromJson(sharedPref.getString("reservation", null), Pemesanan.class);
        }
        return null;
    }

    @Override
    public void setLastReservation(Pemesanan reservation) {
        editor.putString("reservation", new Gson().toJson(reservation));
        editor.apply();
    }

}
