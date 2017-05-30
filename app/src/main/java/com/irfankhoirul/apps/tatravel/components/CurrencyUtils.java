package com.irfankhoirul.apps.tatravel.components;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Created by Irfan Khoirul on 5/12/2017.
 */

public class CurrencyUtils {

    public static String formatRupiah(int amount) {
        DecimalFormat currencyIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        currencyIndonesia.setDecimalFormatSymbols(formatRp);

        return currencyIndonesia.format(amount);

    }

}
