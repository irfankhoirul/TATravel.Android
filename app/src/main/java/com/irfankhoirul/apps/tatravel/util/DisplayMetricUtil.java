package com.irfankhoirul.apps.tatravel.util;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Merupakan kelas helper untuk mengetahui display metric device
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0
 * @version 1.0 (7 November 2016)
 */

public class DisplayMetricUtil {
    public static int getDeviceWidth(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }

    public static int getDeviceHeight(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.heightPixels;
    }
}