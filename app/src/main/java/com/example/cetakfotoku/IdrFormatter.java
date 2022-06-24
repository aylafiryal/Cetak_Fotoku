package com.example.cetakfotoku;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class IdrFormatter {
    public static String format(double num){
        DecimalFormat decFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols idrformat = new DecimalFormatSymbols();

        idrformat.setCurrencySymbol("Rp.");
        idrformat.setMonetaryDecimalSeparator(',');
        idrformat.setGroupingSeparator('.');

        decFormat.setDecimalFormatSymbols(idrformat);
        return decFormat.format(num);
    }
}
