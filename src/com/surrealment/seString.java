package com.surrealment;

import java.math.BigDecimal;

public class seString {

    /**
     * Eliminates null strings.
     *
     * @param s
     * @return
     */
    public static String NullCheck(String s) {
        if (s == null)
            return "";
        else return s;
    }

    /**
     * Produces string with a duplicated character.
     *
     * @param character
     * @param count
     * @return
     */
    public static String ReplicateCharacter(char character, int count) {
        char[] spaces = new char[count];
        for (int i = 0; i < count; i++)
            spaces[i] = character;
        return new String(spaces);
    }

    /**
     * Reformates decimal type.
     *
     * @param value
     * @param decimals
     * @return
     */
    public static String Simplify(float value, int decimals) {
        return Simplify(new BigDecimal(value).toPlainString(), decimals);
    }

    /**
     * Reformates decimal type.
     *
     * @param value
     * @param decimals
     * @return
     */
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

        decimals = seMath.Clamp(decimals, 0, decimal.length());
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

    //region TryParse Primitives

    /**
     * Parse string to byte.
     *
     * @param s
     * @return
     */
    public static byte TryParseByte(String s) {
        s = seString.NullCheck(s);
        switch (s.toLowerCase()) {
            case "min":
                return (Byte.MAX_VALUE * -1 - 1);
            case "max":
                return Byte.MAX_VALUE;
            case "ran":
                return (byte) seRandom.Range((Byte.MAX_VALUE * -1 - 1), Byte.MAX_VALUE);
            case "pos":
                return (byte) seRandom.Range(1, Byte.MAX_VALUE);
            case "neg":
                return (byte) seRandom.Range((Byte.MAX_VALUE * -1 - 1), -1);
            case "":
            case "null":
            case "zero":
                return 0;
        }
        try {
            return Byte.parseByte(s);
        } catch (NumberFormatException e) {
            System.out.println("ERROR \"" + s + "\" is not in valid byte data type format!");
            System.out.println("      Use numbers between " + (Byte.MAX_VALUE * -1 - 1) + " and " + Byte.MAX_VALUE + ".");
            System.out.println("      Or use keywords min, max or zero.");
            return 0;
        }
    }

    /**
     * Parse string to byte array.
     *
     * @param s
     * @return
     */
    public static byte[] TryParseByte(String[] s) {
        byte[] retVal = new byte[s.length];
        for (int i = 0; i < s.length; i++)
            retVal[i] = TryParseByte(s[i]);
        return retVal;
    }

    /**
     * Parse string to short.
     *
     * @param s
     * @return
     */
    public static short TryParseShort(String s) {
        s = seString.NullCheck(s);
        switch (s.toLowerCase()) {
            case "min":
                return (Short.MAX_VALUE * -1 - 1);
            case "max":
                return Short.MAX_VALUE;
            case "ran":
                return (short) seRandom.Range((Short.MAX_VALUE * -1 - 1), Short.MAX_VALUE);
            case "pos":
                return (short) seRandom.Range(1, Short.MAX_VALUE);
            case "neg":
                return (short) seRandom.Range((Short.MAX_VALUE * -1 - 1), -1);
            case "":
            case "null":
            case "zero":
                return 0;
        }
        try {
            return Short.parseShort(s);
        } catch (NumberFormatException e) {
            System.out.println("ERROR \"" + s + "\" is not in valid short data type format!");
            System.out.println("      Use numbers between " + (Short.MAX_VALUE * -1 - 1) + " and " + Short.MAX_VALUE + ".");
            System.out.println("      Or use keywords min, max or zero.");
            return 0;
        }
    }

    /**
     * Parse string to short array.
     *
     * @param s
     * @return
     */
    public static short[] TryParseShort(String[] s) {
        short[] retVal = new short[s.length];
        for (int i = 0; i < s.length; i++)
            retVal[i] = TryParseShort(s[i]);
        return retVal;
    }

    /**
     * Parse string to int.
     *
     * @param s
     * @return
     */
    public static int TryParseInt(String s) {
        s = seString.NullCheck(s);
        switch (s.toLowerCase().trim()) {
            case "min":
                return (Integer.MAX_VALUE * -1 - 1);
            case "max":
                return Integer.MAX_VALUE;
            case "ran":
                return seRandom.Range((Integer.MAX_VALUE * -1 - 1), Integer.MAX_VALUE);
            case "pos":
                return seRandom.Range(1, Integer.MAX_VALUE);
            case "neg":
                return seRandom.Range((Integer.MAX_VALUE * -1 - 1), -1);
            case "":
            case "null":
            case "zero":
                return 0;
        }
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("ERROR \"" + s + "\" is not in valid int data type format!");
            System.out.println("      Use numbers between " + (Integer.MAX_VALUE * -1 - 1) + " and " + Integer.MAX_VALUE + ".");
            System.out.println("      Or use keywords min, max or zero.");
            return 0;
        }
    }

    /**
     * Parse string to int array.
     *
     * @param s
     * @return
     */
    public static int[] TryParseInt(String[] s) {
        int[] retVal = new int[s.length];
        for (int i = 0; i < s.length; i++)
            retVal[i] = TryParseInt(s[i]);
        return retVal;
    }

    /**
     * Parse string to long.
     *
     * @param s
     * @return
     */
    public static long TryParseLong(String s) {
        s = seString.NullCheck(s);
        switch (s.toLowerCase()) {
            case "min":
                return (Long.MAX_VALUE * -1 - 1);
            case "max":
                return Long.MAX_VALUE;
            case "ran":
                return seRandom.Range((Long.MAX_VALUE * -1 - 1), Long.MAX_VALUE);
            case "pos":
                return seRandom.Range(1L, Long.MAX_VALUE);
            case "neg":
                return seRandom.Range((Long.MAX_VALUE * -1 - 1), -1L);
            case "":
            case "null":
            case "zero":
                return 0L;
        }
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            System.out.println("ERROR \"" + s + "\" is not in valid long data type format!");
            System.out.println("      Use numbers between " + (Long.MAX_VALUE * -1 - 1) + " and " + Long.MAX_VALUE + ".");
            System.out.println("      Or use keywords min, max or zero.");
            return 0L;
        }
    }

    /**
     * Parse string to long array.
     *
     * @param s
     * @return
     */
    public static long[] TryParseLong(String[] s) {
        long[] retVal = new long[s.length];
        for (int i = 0; i < s.length; i++)
            retVal[i] = TryParseLong(s[i]);
        return retVal;
    }

    /**
     * Parse string to float.
     *
     * @param s
     * @return
     */
    public static float TryParseFloat(String s) {
        s = seString.NullCheck(s);
        switch (s.toLowerCase()) {
            case "min":
                return (Float.MAX_VALUE * -1 - 1);
            case "max":
                return Float.MAX_VALUE;
            case "ran":
                return seRandom.Range((Float.MAX_VALUE * -1f - 1f), Float.MAX_VALUE);
            case "pos":
                return seRandom.Range(1f, Float.MAX_VALUE);
            case "neg":
                return seRandom.Range((Float.MAX_VALUE * -1f - 1f), -1f);
            case "":
            case "null":
            case "zero":
                return 0f;
        }
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException e) {
            System.out.println("ERROR \"" + s + "\" is not in valid float data type format!");
            System.out.println("      Use numbers between " + (Float.MAX_VALUE * -1 - 1) + " and " + Float.MAX_VALUE + ".");
            System.out.println("      Or use keywords min, max or zero.");
            return 0f;
        }
    }

    /**
     * Parse string to float array.
     *
     * @param s
     * @return
     */
    public static float[] TryParseFloat(String[] s) {
        float[] retVal = new float[s.length];
        for (int i = 0; i < s.length; i++)
            retVal[i] = TryParseFloat(s[i]);
        return retVal;
    }

    /**
     * Parse string to double.
     *
     * @param s
     * @return
     */
    public static double TryParseDouble(String s) {
        s = seString.NullCheck(s);
        switch (s.toLowerCase()) {
            case "min":
                return (Double.MAX_VALUE * -1 - 1);
            case "max":
                return Double.MAX_VALUE;
            case "":
            case "null":
            case "zero":
                return 0d;
        }
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            System.out.println("ERROR \"" + s + "\" is not in valid double data type format!");
            System.out.println("      Use numbers between " + (Double.MAX_VALUE * -1 - 1) + " and " + Double.MAX_VALUE + ".");
            System.out.println("      Or use keywords min, max or zero.");
            return 0d;
        }
    }

    /**
     * Parse string to double array.
     *
     * @param s
     * @return
     */
    public static double[] TryParseDouble(String[] s) {
        double[] retVal = new double[s.length];
        for (int i = 0; i < s.length; i++)
            retVal[i] = TryParseDouble(s[i]);
        return retVal;
    }

    //endregion

}
