package com.irfankhoirul.apps.tatravel.core.components.util;

import java.util.Calendar;

/**
 * Created by Irfan Khoirul on 5/8/2017.
 */

public class DateUtils {

    public static String[] DAYS_ID = {"Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
    public static String[] MONTHS_ID = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli",
            "Agustus", "September", "Oktober", "November", "Desember"};

    // Jumat, 17 Agustus 1945
    public static String getStandardDayFormat(long timeInMilis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMilis);

        return DAYS_ID[calendar.get(Calendar.DAY_OF_WEEK) - 1] + ", " + calendar.get(Calendar.DAY_OF_MONTH)
                + " " + MONTHS_ID[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.YEAR);
    }
}
