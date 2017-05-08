package com.irfankhoirul.apps.tatravel.data.locale.cart;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;

import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 5/7/2017.
 */

public class Cart {

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
     */
    public void setDeparture(Map<String, String> departureData) {
        editor.putString("departure", new Gson().toJson(departureData));
        editor.apply();
    }

    public void clearDeparture() {
        editor.remove("departure");
        editor.apply();
    }

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
    public void setDestination(Map<String, String> destinationData) {
        editor.putString("destination", new Gson().toJson(destinationData));
        editor.apply();
    }

    public void clearDestination() {
        editor.remove("destination");
        editor.apply();
    }

    public long getTanggalKeberangkatan() {
        return sharedPref.getLong("tanggalKeberangkatan", 0);
    }

    public void setTanggalKeberangkatan(long date) {
        editor.putLong("tanggalKeberangkatan", date);
        editor.apply();
    }

    public void clearTanggalKeberangkatan() {
        editor.remove("tanggalKeberangkatan");
        editor.apply();
    }

    public boolean isPulangPergi() {
        return sharedPref.getBoolean("pulangPergi", false);
    }

    public void setPulangPergi(boolean isPulangPergi) {
        editor.putBoolean("pulangPergi", isPulangPergi);
        editor.apply();
    }

    public long getTanggalKepulangan() {
        return sharedPref.getLong("tanggalKepulangan", 0);
    }

    public void setTanggalKepulangan(long date) {
        editor.putLong("tanggalKepulangan", date);
        editor.apply();
    }

    public void clearTanggalKepulangan() {
        editor.remove("tanggalKepulangan");
        editor.apply();
    }

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
    public void setPenumpang(List<Penumpang> penumpangList) {
        editor.putString("penumpang", new Gson().toJson(penumpangList));
        editor.apply();
    }

    public void clearPenumpang() {
        editor.remove("penumpang");
        editor.apply();
    }

}
