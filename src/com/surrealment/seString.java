package com.surrealment;

import java.math.BigDecimal;

public class sString {
    public static String NullCheck(String s) {
        if (s == null)
            return "";
        else return s;
    }

    public static String ReplicateCharacter(char character, int count) {
        char[] spaces = new char[count];
        for (int i = 0; i < count; i++)
            spaces[i] = character;
        return new String(spaces);
    }

    public static String Simplify(float value, int decimals) {
        return Simplify(new BigDecimal(value).toPlainString(), decimals);
    }

    public static String Simplify(double value, int decimals) {
        return Simplify(new BigDecimal(value).toPlainString(), decimals);
    }


    /**
     * Format float into common abbreviations.
     *
     * @param s
     * @param decimals
     * @return
     */
    private static String Simplify(String s, int decimals) {
        // See if number is negative.
        boolean negative = s.startsWith("-");
        if (negative)
            s = s.replace("-", "");

        // Replace non numeric.
        s = s.replaceAll("[^\\d.]", "");

        // Initialize variables.
        String number, decimal = "";

        // If period exists split number and variable.
        if (s.indexOf('.') > 1) {
            String[] a = s.split(".");
            number = a[0];
            decimal = a[1];
        } else
            number = s;

        // If number is blank make it zero.
        if (number.length() == 0)
            number = "0";

        // If decimal is blank make it zero.
        if (decimal.length() == 0)
            decimal = "0";

        decimals = sMath.Clamp(decimals, 0, decimal.length());
        if (decimal.length() > decimals)
            decimal = decimal.substring(0, decimals);

        // 100,000,000,000,000,000,000
        //  19  16  13  10   7   4

        int len = number.length();
        if (number.length() > 18)
            number = number.substring(0, 3) + "x10x" + (len - 3);
            // quadrillion
        else if (number.length() > 15)
            number = number.substring(0, len - 15) + "q";
            // trillion
        else if (number.length() > 12)
            number = number.substring(0, len - 12) + "t";
            // billion
        else if (number.length() > 9)
            number = number.substring(0, len - 9) + "b";
            // million
        else if (number.length() > 6)
            number = number.substring(0, len - 6) + "m";
            // thousand
        else if (number.length() > 3)
            number = number.substring(0, len - 3) + "k";
            // number with decimal
        else
            number = number + "." + decimal;
        if (negative)
            return "-" + number;
        else
            return number;
    }

}
