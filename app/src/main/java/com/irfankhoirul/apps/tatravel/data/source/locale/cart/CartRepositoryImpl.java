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

public class CartRepositoryImpl implements CartRepository {

    private static String SHARED_PREFERENCE_NAME = "CartRepositoryImpl";
    private SharedPreferences sharedPreferences;

    public CartRepositoryImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void clearCart() {
        sharedPreferences.edit().clear().apply();
    }

    @Override
    public Map<String, String> getDeparture() {
        if (sharedPreferences.getString("departure", null) != null) {
            return new Gson().fromJson(sharedPreferences.getString("departure", null), new TypeToken<Map<String, String>>() {
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
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("departure", new Gson().toJson(departureData));
        editor.apply();
    }

    @Override
    public void clearDeparture() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("departure");
        editor.apply();
    }

    @Override
    public Map<String, String> getDestination() {
        if (sharedPreferences.getString("destination", null) != null) {
            return new Gson().fromJson(sharedPreferences.getString("destination", null), new TypeToken<Map<String, String>>() {
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
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("destination", new Gson().toJson(destinationData));
        editor.apply();
    }

    @Override
    public void clearDestination() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("destination");
        editor.apply();
    }

    @Override
    public long getTanggalKeberangkatan() {
        return sharedPreferences.getLong("tanggalKeberangkatan", 0);
    }

    @Override
    public void setTanggalKeberangkatan(long date) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong("tanggalKeberangkatan", date);
        editor.apply();
    }

    @Override
    public void clearTanggalKeberangkatan() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("tanggalKeberangkatan");
        editor.apply();
    }

    @Override
    public List<Penumpang> getPenumpang() {
        if (sharedPreferences.getString("penumpang", null) != null) {
            return new Gson().fromJson(sharedPreferences.getString("penumpang", null), new TypeToken<List<Penumpang>>() {
            }.getType());
        }
        return null;
    }

    /**
     * Data : List<Penumpang></>
     */
    @Override
    public void setPenumpang(List<Penumpang> penumpangList) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("penumpang", new Gson().toJson(penumpangList));
        editor.apply();
    }

    @Override
    public void clearPenumpang() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("penumpang");
        editor.apply();
    }

    @Override
    public JadwalPerjalanan getSchedule() {
        if (sharedPreferences.getString("jadwalPerjalanan", null) != null) {
            return new Gson().fromJson(sharedPreferences.getString("jadwalPerjalanan", null), JadwalPerjalanan.class);
        }
        return null;
    }

    @Override
    public void setSchedule(JadwalPerjalanan schedule) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("jadwalPerjalanan", new Gson().toJson(schedule));
        editor.apply();
    }

    @Override
    public void clearSchedule() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("jadwalPerjalanan");
        editor.apply();
    }

    @Override
    public List<KursiPerjalanan> getSeat() {
        if (sharedPreferences.getString("kursiPerjalanan", null) != null) {
            return new Gson().fromJson(sharedPreferences.getString("kursiPerjalanan", null), new TypeToken<List<KursiPerjalanan>>() {
            }.getType());
        }
        return null;
    }

    @Override
    public void setSeat(List<KursiPerjalanan> seats) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("kursiPerjalanan", new Gson().toJson(seats));
        editor.apply();
    }

    @Override
    public void clearSeat() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("kursiPerjalanan");
        editor.apply();
    }

    @Override
    public long getSeatSetTime() {
        return sharedPreferences.getLong("seatSetTime", 0);
    }

    @Override
    public void setSeatSetTime(long seatSetTime) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong("seatSetTime", seatSetTime);
        editor.apply();
    }

    @Override
    public void clearSeatSetTime() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("seatSetTime");
        editor.apply();
    }

    @Override
    public Pemesanan getLastReservation() {
        if (sharedPreferences.getString("reservation", null) != null) {
            return new Gson().fromJson(sharedPreferences.getString("reservation", null), Pemesanan.class);
        }
        return null;
    }

    @Override
    public void setLastReservation(Pemesanan reservation) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("reservation", new Gson().toJson(reservation));
        editor.apply();
    }

    @Override
    public void clearLastReservation() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("reservation");
        editor.apply();
    }

}