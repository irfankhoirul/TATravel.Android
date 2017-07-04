package com.irfankhoirul.apps.tatravel.data.source.locale.cart;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.irfankhoirul.apps.tatravel.app.TAApplication;
import com.irfankhoirul.apps.tatravel.data.pojo.JadwalPerjalanan;
import com.irfankhoirul.apps.tatravel.data.pojo.KursiPerjalanan;
import com.irfankhoirul.apps.tatravel.data.pojo.Pemesanan;
import com.irfankhoirul.apps.tatravel.data.pojo.Penumpang;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Irfan Khoirul on 5/7/2017.
 */

public class CartRepositoryImpl implements CartRepository {

    private CartEntityDao cartEntityDao;

    public CartRepositoryImpl(Context context) {
        DaoSession daoSession = ((TAApplication) context.getApplicationContext()).getDaoSession();
        cartEntityDao = daoSession.getCartEntityDao();
    }

    @Override
    public void clearCart() {
        cartEntityDao.deleteAll();
    }

    private void insertDeparture(Map<String, String> departureData) {
        Log.d("DepartureData", new Gson().toJson(departureData));
        CartEntity entity = new CartEntity();
        entity.setKey("departure");
        entity.setValue(new Gson().toJson(departureData));
        long id = cartEntityDao.insertOrReplace(entity);
        Log.d("New Id", String.valueOf(id));
        List<CartEntity> departure = selectDeparture();
        Log.d("Size", String.valueOf(departure.size()));
        Log.d("DepartureInserted", departure.get(0).getKey() + "|" + departure.get(0).getValue());
    }

    private List<CartEntity> selectDeparture() {
        QueryBuilder<CartEntity> qb = cartEntityDao.queryBuilder();
        qb.where(CartEntityDao.Properties.Key.eq("departure"));
        return qb.list();
    }

    @Override
    public Map<String, String> getDeparture() {
        List<CartEntity> departures = selectDeparture();
        if (departures.size() > 0) {
            return new Gson().fromJson(departures.get(0).getValue(),
                    new TypeToken<Map<String, String>>() {
                    }.getType());
        }
        return null;
    }

    @Override
    public void setDeparture(Map<String, String> departureData) {
        List<CartEntity> departures = selectDeparture();
        if (departures.size() == 0) {
            insertDeparture(departureData);
        } else {
            cartEntityDao.delete(departures.get(0));
            insertDeparture(departureData);
        }
    }

    @Override
    public void clearDeparture() {
        List<CartEntity> departures = selectDeparture();
        if (departures.size() > 0) {
            cartEntityDao.delete(departures.get(0));
        }
    }

    private void insertDestination(Map<String, String> destinationData) {
        CartEntity entity = new CartEntity();
        entity.setKey("destination");
        entity.setValue(new Gson().toJson(destinationData));
        cartEntityDao.insertOrReplace(entity);
    }

    private List<CartEntity> selectDestination() {
        QueryBuilder<CartEntity> qb = cartEntityDao.queryBuilder();
        qb.where(CartEntityDao.Properties.Key.eq("destination"));
        return qb.list();
    }

    @Override
    public Map<String, String> getDestination() {
        List<CartEntity> destinations = selectDestination();
        if (destinations.size() > 0) {
            return new Gson().fromJson(destinations.get(0).getValue(),
                    new TypeToken<Map<String, String>>() {
                    }.getType());
        }
        return null;
    }

    @Override
    public void setDestination(Map<String, String> destinationData) {
        List<CartEntity> destinations = selectDestination();
        if (destinations.size() == 0) {
            insertDestination(destinationData);
        } else {
            cartEntityDao.delete(destinations.get(0));
            insertDestination(destinationData);
        }
    }

    @Override
    public void clearDestination() {
        List<CartEntity> destinations = selectDestination();
        if (destinations.size() > 0) {
            cartEntityDao.delete(destinations.get(0));
        }
    }

    private void insertDepartureDate(long date) {
        CartEntity entity = new CartEntity();
        entity.setKey("tanggalKeberangkatan");
        entity.setValue(String.valueOf(date));
        cartEntityDao.insertOrReplace(entity);
    }

    private List<CartEntity> selectDepartureDate() {
        QueryBuilder<CartEntity> qb = cartEntityDao.queryBuilder();
        qb.where(CartEntityDao.Properties.Key.eq("tanggalKeberangkatan"));
        return qb.list();
    }

    @Override
    public long getTanggalKeberangkatan() {
        List<CartEntity> departureDates = selectDepartureDate();
        if (departureDates.size() > 0) {
            return Long.parseLong(departureDates.get(0).getValue());
        }
        return 0;
    }

    @Override
    public void setTanggalKeberangkatan(long date) {
        List<CartEntity> departureDates = selectDepartureDate();
        if (departureDates.size() == 0) {
            insertDepartureDate(date);
        } else {
            cartEntityDao.delete(departureDates.get(0));
            insertDepartureDate(date);
        }
    }

    @Override
    public void clearTanggalKeberangkatan() {
        List<CartEntity> departureDates = selectDepartureDate();
        if (departureDates.size() > 0) {
            cartEntityDao.delete(departureDates.get(0));
        }
    }

    private void insertPassenger(List<Penumpang> penumpangList) {
        CartEntity entity = new CartEntity();
        entity.setKey("penumpang");
        entity.setValue(new Gson().toJson(penumpangList));
        cartEntityDao.insertOrReplace(entity);
    }

    private List<CartEntity> selectPassenger() {
        QueryBuilder<CartEntity> qb = cartEntityDao.queryBuilder();
        qb.where(CartEntityDao.Properties.Key.eq("penumpang"));
        return qb.list();
    }

    @Override
    public ArrayList<Penumpang> getPenumpang() {
        List<CartEntity> passengers = selectPassenger();
        if (passengers.size() > 0) {
            return new Gson().fromJson(passengers.get(0).getValue(),
                    new TypeToken<List<Penumpang>>() {
                    }.getType());
        }
        return null;
    }

    @Override
    public void setPenumpang(ArrayList<Penumpang> penumpangList) {
        List<CartEntity> passengers = selectPassenger();
        if (passengers.size() == 0) {
            insertPassenger(penumpangList);
        } else {
            cartEntityDao.delete(passengers.get(0));
            insertPassenger(penumpangList);
        }
    }

    @Override
    public void clearPenumpang() {
        List<CartEntity> passengers = selectPassenger();
        if (passengers.size() > 0) {
            cartEntityDao.delete(passengers.get(0));
        }
    }

    private void insertSchedule(JadwalPerjalanan schedule) {
        CartEntity entity = new CartEntity();
        entity.setKey("jadwalPerjalanan");
        entity.setValue(new Gson().toJson(schedule));
        cartEntityDao.insertOrReplace(entity);
    }

    private List<CartEntity> selectSchedule() {
        QueryBuilder<CartEntity> qb = cartEntityDao.queryBuilder();
        qb.where(CartEntityDao.Properties.Key.eq("jadwalPerjalanan"));
        return qb.list();
    }

    @Override
    public JadwalPerjalanan getSchedule() {
        List<CartEntity> schedules = selectSchedule();
        if (schedules.size() > 0) {
            return new Gson().fromJson(schedules.get(0).getValue(), JadwalPerjalanan.class);
        }
        return null;
    }

    @Override
    public void setSchedule(JadwalPerjalanan schedule) {
        List<CartEntity> schedules = selectSchedule();
        if (schedules.size() == 0) {
            insertSchedule(schedule);
        } else {
            cartEntityDao.delete(schedules.get(0));
            insertSchedule(schedule);
        }
    }

    @Override
    public void clearSchedule() {
        List<CartEntity> schedules = selectSchedule();
        if (schedules.size() > 0) {
            cartEntityDao.delete(schedules.get(0));
        }
    }

    private void insertSeat(List<KursiPerjalanan> seat) {
        CartEntity entity = new CartEntity();
        entity.setKey("kursiPerjalanan");
        entity.setValue(new Gson().toJson(seat));
        cartEntityDao.insertOrReplace(entity);
    }

    private List<CartEntity> selectSeat() {
        QueryBuilder<CartEntity> qb = cartEntityDao.queryBuilder();
        qb.where(CartEntityDao.Properties.Key.eq("kursiPerjalanan"));
        return qb.list();
    }

    @Override
    public List<KursiPerjalanan> getSeat() {
        List<CartEntity> seats = selectSeat();
        if (seats.size() > 0) {
            return new Gson().fromJson(seats.get(0).getValue(),
                    new TypeToken<List<KursiPerjalanan>>() {
                    }.getType());
        }
        return null;
    }

    @Override
    public void setSeat(List<KursiPerjalanan> seat) {
        List<CartEntity> seats = selectSeat();
        if (seats.size() == 0) {
            insertSeat(seat);
        } else {
            cartEntityDao.delete(seats.get(0));
            insertSeat(seat);
        }
    }

    @Override
    public void clearSeat() {
        List<CartEntity> seats = selectSeat();
        if (seats.size() > 0) {
            cartEntityDao.delete(seats.get(0));
        }
    }

    private void insertSeatSetTime(long seatSetTime) {
        CartEntity entity = new CartEntity();
        entity.setKey("seatSetTime");
        entity.setValue(String.valueOf(seatSetTime));
        cartEntityDao.insertOrReplace(entity);
    }

    private List<CartEntity> selectSeatSetTime() {
        QueryBuilder<CartEntity> qb = cartEntityDao.queryBuilder();
        qb.where(CartEntityDao.Properties.Key.eq("seatSetTime"));
        return qb.list();
    }

    @Override
    public long getSeatSetTime() {
        List<CartEntity> seatsSetTimes = selectSeatSetTime();
        if (seatsSetTimes.size() > 0) {
            return Long.parseLong(seatsSetTimes.get(0).getValue());
        }
        return 0;
    }

    @Override
    public void setSeatSetTime(long seatSetTime) {
        List<CartEntity> seatsSetTimes = selectSeatSetTime();
        if (seatsSetTimes.size() == 0) {
            insertSeatSetTime(seatSetTime);
        } else {
            cartEntityDao.delete(seatsSetTimes.get(0));
            insertSeatSetTime(seatSetTime);
        }
    }

    @Override
    public void clearSeatSetTime() {
        List<CartEntity> seatsSetTime = selectSeatSetTime();
        if (seatsSetTime.size() > 0) {
            cartEntityDao.delete(seatsSetTime.get(0));
        }
    }

    private void insertReservation(Pemesanan reservation) {
        CartEntity entity = new CartEntity();
        entity.setKey("reservation");
        entity.setValue(String.valueOf(reservation));
        cartEntityDao.insertOrReplace(entity);
    }

    private List<CartEntity> selectReservation() {
        QueryBuilder<CartEntity> qb = cartEntityDao.queryBuilder();
        qb.where(CartEntityDao.Properties.Key.eq("reservation"));
        return qb.list();
    }

    @Override
    public Pemesanan getLastReservation() {
        List<CartEntity> reservations = selectReservation();
        if (reservations.size() > 0) {
            return new Gson().fromJson(reservations.get(0).getValue(),
                    Pemesanan.class);
        }
        return null;
    }

    @Override
    public void setLastReservation(Pemesanan reservation) {
        List<CartEntity> reservations = selectReservation();
        if (reservations.size() == 0) {
            insertReservation(reservation);
        } else {
            cartEntityDao.delete(reservations.get(0));
            insertReservation(reservation);
        }
    }

    @Override
    public void clearLastReservation() {
        List<CartEntity> reservations = selectReservation();
        if (reservations.size() > 0) {
            cartEntityDao.delete(reservations.get(0));
        }
    }

/*
    private static String SHARED_PREFERENCE_NAME = "CartRepositoryImpl";
    private SharedPreferences sharedPreferences;

    public CartRepositoryImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME,
                Context.MODE_PRIVATE);
    }

    @Override
    public void clearCart() {
        sharedPreferences.edit().clear().apply();
    }

    @Override
    public Map<String, String> getDeparture() {
        if (sharedPreferences.getString("departure", null) != null) {
            return new Gson().fromJson(sharedPreferences.getString("departure", null),
                    new TypeToken<Map<String, String>>() {
            }.getType());
        }
        return null;
    }

    */
/**
 * Data :
 * - Address
 * - Latitude
 * - Longitude
 * - OperatorTravelId
 * - locationIds (JsonArray)
 *//*

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
            return new Gson().fromJson(sharedPreferences.getString("destination", null),
                    new TypeToken<Map<String, String>>() {
            }.getType());
        }
        return null;
    }

    */
/**
 * Data :
 * - Address
 * - Latitude
 * - Longitude
 * - OperatorTravelId
 *//*

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
            return new Gson().fromJson(sharedPreferences.getString("penumpang", null),
                    new TypeToken<List<Penumpang>>() {
            }.getType());
        }
        return null;
    }

    */
/**
 * Data : List<Penumpang></>
 *//*

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
            return new Gson().fromJson(sharedPreferences.getString("jadwalPerjalanan", null),
                    JadwalPerjalanan.class);
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
            return new Gson().fromJson(sharedPreferences.getString("kursiPerjalanan", null),
                    new TypeToken<List<KursiPerjalanan>>() {
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
            return new Gson().fromJson(sharedPreferences.getString("reservation", null),
                    Pemesanan.class);
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
*/

}
