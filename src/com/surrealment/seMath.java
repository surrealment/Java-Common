package com.surrealment;

public class seMath {

    /**
     * Primitive number data types.
     */
    public enum NumberDataType {
        Byte,
        Short,
        Int,
        Long,
        Float,
        Double
    }

    //region byte

    /**
     * Limit value to over minimum and under maximum.
     *
     * @param value
     * @param min   Minimum allowed value.
     * @param max   Maximum allowed value.
     * @return
     */
    public static byte Clamp(byte value, byte min, byte max) {
        if (value > max)
            return max;
        if (value < min)
            return min;
        return value;
    }

    /**
     * Finds smallest number in given values.
     *
     * @param numbers
     * @return
     */
    public static byte Min(byte... numbers) {
        if (numbers.length == 0)
            return 0;
        byte low = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            if (low > numbers[i])
                low = numbers[i];
        return low;
    }

    /**
     * Finds greatest number in given values.
     *
     * @param numbers
     * @return
     */
    public static byte Max(byte... numbers) {
        if (numbers.length == 0)
            return 0;
        byte high = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            if (numbers[i] > high)
                high = numbers[i];
        return high;
    }

    /**
     * Finds the average of given numbers.
     *
     * @param numbers
     * @return average of given numbers.
     */
    public static byte Average(byte... numbers) {
        if (numbers.length == 0)
            return 0;
        return (byte) (Sum(numbers) / numbers.length);
    }

    /**
     * Adds given numbers.
     *
     * @param numbers
     * @return total of given values.
     */
    public static byte Sum(byte... numbers) {
        if (numbers.length == 0)
            return 0;
        byte total = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            total += numbers[i];
        return total;
    }

    /**
     * Loop through array to find match.
     *
     * @param match   number to find.
     * @param numbers
     * @return true if match is found.
     */
    public static boolean Contains(byte match, byte... numbers) {
        for (int i = 0; i < numbers.length; i++)
            if (match == numbers[i])
                return true;
        return false;
    }

    /**
     * Check if values are equal to each other.
     *
     * @param numbers
     * @return true if all numbers are the same.
     */
    public static boolean Equals(byte... numbers) {
        if (numbers.length < 2)
            return true;
        for (int i = 1; i < numbers.length; i++)
            if (numbers[0] != numbers[i])
                return false;
        return true;
    }

    //endregion

    //region short

    /**
     * Limit value to over minimum and under maximum.
     *
     * @param value
     * @param min   Minimum allowed value.
     * @param max   Maximum allowed value.
     * @return
     */
    public static short Clamp(short value, short min, short max) {
        if (value > max)
            return max;
        if (value < min)
            return min;
        return value;
    }

    /**
     * Limit value to over minimum for data type and under maximum for data type.
     *
     * @param value
     * @param dataType
     * @return
     */
    public static short DataTypeClamp(Short value, NumberDataType dataType) {
        if (dataType == NumberDataType.Byte)
            return seMath.Clamp(value, (short) ((Byte.MAX_VALUE * -1 - 1)), (short) Byte.MAX_VALUE);

        return value;
    }

    /**
     * Finds smallest number in given values.
     *
     * @param numbers
     * @return
     */
    public static short Min(short... numbers) {
        if (numbers.length == 0)
            return 0;
        short low = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            if (low > numbers[i])
                low = numbers[i];
        return low;
    }

    /**
     * Finds greatest number in given values.
     *
     * @param numbers
     * @return
     */
    public static short Max(short... numbers) {
        if (numbers.length == 0)
            return 0;
        short high = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            if (numbers[i] > high)
                high = numbers[i];
        return high;
    }

    /**
     * Finds the average of given numbers.
     *
     * @param numbers
     * @return average of given numbers.
     */
    public static short Average(short... numbers) {
        if (numbers.length == 0)
            return 0;
        return (short) (Sum(numbers) / numbers.length);
    }

    /**
     * Adds given numbers.
     *
     * @param numbers
     * @return total of given values.
     */
    public static short Sum(short... numbers) {
        if (numbers.length == 0)
            return 0;
        short total = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            total += numbers[i];
        return total;
    }

    /**
     * Loop through array to find match.
     *
     * @param match   number to find.
     * @param numbers
     * @return true if match is found.
     */
    public static boolean Contains(short match, short... numbers) {
        for (int i = 0; i < numbers.length; i++)
            if (match == numbers[i])
                return true;
        return false;
    }

    /**
     * Check if values are equal to each other.
     *
     * @param numbers
     * @return true if all numbers are the same.
     */
    public static boolean Equals(short... numbers) {
        if (numbers.length < 2)
            return true;
        for (int i = 1; i < numbers.length; i++)
            if (numbers[0] != numbers[i])
                return false;
        return true;
    }

    //endregion

    //region int

    /**
     * Limit value to over minimum and under maximum.
     *
     * @param value
     * @param min   Minimum allowed value.
     * @param max   Maximum allowed value.
     * @return
     */
    public static int Clamp(int value, int min, int max) {
        if (value > max)
            return max;
        if (value < min)
            return min;
        return value;
    }

    /**
     * Limit value to over minimum for data type and under maximum for data type.
     *
     * @param value
     * @param dataType
     * @return
     */
    public static int DataTypeClamp(int value, NumberDataType dataType) {
        if (dataType == NumberDataType.Byte)
            return seMath.Clamp(value, (int) (Byte.MAX_VALUE * -1 - 1), (int) Byte.MAX_VALUE);
        if (dataType == NumberDataType.Short)
            return seMath.Clamp(value, (int) (Short.MAX_VALUE * -1 - 1), (int) Short.MAX_VALUE);
        return value;
    }

    /**
     * Finds smallest number in given values.
     *
     * @param numbers
     * @return
     */
    public static int Min(int... numbers) {
        if (numbers.length == 0)
            return 0;
        int low = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            if (low > numbers[i])
                low = numbers[i];
        return low;
    }

    /**
     * Finds smallest number in given array values.
     *
     * @param numbers
     * @return
     */
    public static int Min(int[]... numbers) {
        if (numbers.length == 0)
            return 0;
        int record = Min(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            int rewRecord = Min(numbers[i]);
            if (record > rewRecord)
                record = rewRecord;
        }
        return record;
    }

    /**
     * Finds greatest number in given values.
     *
     * @param numbers
     * @return
     */
    public static int Max(int... numbers) {
        if (numbers.length == 0)
            return 0;
        int high = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            if (numbers[i] > high)
                high = numbers[i];
        return high;
    }

    /**
     * Finds greatest number in given array values.
     *
     * @param numbers
     * @return
     */
    public static int Max(int[]... numbers) {
        if (numbers.length == 0)
            return 0;
        int record = Max(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            int rewRecord = Max(numbers[i]);
            if (record < rewRecord)
                record = rewRecord;
        }
        return record;
    }

    /**
     * Finds the average of given numbers.
     *
     * @param numbers
     * @return average of given numbers.
     */
    public static int Average(int... numbers) {
        if (numbers.length == 0)
            return 0;
        return Sum(numbers) / numbers.length;
    }

    /**
     * Adds given numbers.
     *
     * @param numbers
     * @return total of given values.
     */
    public static int Sum(int... numbers) {
        if (numbers.length == 0)
            return 0;
        int total = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            total += numbers[i];
        return total;
    }

    /**
     * Loop through array to find match.
     *
     * @param match   number to find.
     * @param numbers
     * @return true if match is found.
     */
    public static boolean Contains(int match, int... numbers) {
        for (int i = 0; i < numbers.length; i++)
            if (match == numbers[i])
                return true;
        return false;
    }

    /**
     * Check if values are equal to each other.
     *
     * @param numbers
     * @return true if all numbers are the same.
     */
    public static boolean Equals(int... numbers) {
        if (numbers.length < 2)
            return true;
        for (int i = 1; i < numbers.length; i++)
            if (numbers[0] != numbers[i])
                return false;
        return true;
    }

    //endregion

    //region long

    /**
     * Limit value to over minimum and under maximum.
     *
     * @param value
     * @param min   Minimum allowed value.
     * @param max   Maximum allowed value.
     * @return
     */
    public static long Clamp(long value, long min, long max) {
        if (value > max)
            return max;
        if (value < min)
            return min;
        return value;
    }

    /**
     * Limit value to over minimum for data type and under maximum for data type.
     *
     * @param value
     * @param dataType
     * @return
     */
    public static long DataTypeClamp(long value, NumberDataType dataType) {
        if (dataType == NumberDataType.Byte)
            return seMath.Clamp(value, (long) (Byte.MAX_VALUE * -1 - 1), (long) Byte.MAX_VALUE);
        if (dataType == NumberDataType.Short)
            return seMath.Clamp(value, (long) (Short.MAX_VALUE * -1 - 1), (long) Short.MAX_VALUE);
        if (dataType == NumberDataType.Int)
            return seMath.Clamp(value, (long) (Integer.MAX_VALUE * -1 - 1), (long) Integer.MAX_VALUE);

        return value;
    }

    /**
     * Finds smallest number in given values.
     *
     * @param numbers
     * @return
     */
    public static long Min(long... numbers) {
        if (numbers.length == 0)
            return 0L;
        long low = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            if (low > numbers[i])
                low = numbers[i];
        return low;
    }

    /**
     * Finds greatest number in given values.
     *
     * @param numbers
     * @return
     */
    public static long Max(long... numbers) {
        if (numbers.length == 0)
            return 0L;
        long high = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            if (numbers[i] > high)
                high = numbers[i];
        return high;
    }

    /**
     * Finds the average of given numbers.
     *
     * @param numbers
     * @return average of given numbers.
     */
    public static long Average(long... numbers) {
        if (numbers.length == 0)
            return 0;
        return Sum(numbers) / numbers.length;
    }

    /**
     * Adds given numbers.
     *
     * @param numbers
     * @return total of given values.
     */
    public static long Sum(long... numbers) {
        if (numbers.length == 0)
            return 0;
        long total = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            total += numbers[i];
        return total;
    }

    /**
     * Loop through array to find match.
     *
     * @param match   number to find.
     * @param numbers
     * @return true if match is found.
     */
    public static boolean Contains(long match, long... numbers) {
        for (int i = 0; i < numbers.length; i++)
            if (match == numbers[i])
                return true;
        return false;
    }

    /**
     * Check if values are equal to each other.
     *
     * @param numbers
     * @return true if all numbers are the same.
     */
    public static boolean Equals(long... numbers) {
        if (numbers.length < 2)
            return true;
        for (int i = 1; i < numbers.length; i++)
            if (numbers[0] != numbers[i])
                return false;
        return true;
    }

    //endregion

    //region float

    /**
     * Limit value to over minimum and under maximum.
     *
     * @param value
     * @param min   Minimum allowed value.
     * @param max   Maximum allowed value.
     * @return
     */
    public static float Clamp(float value, float min, float max) {
        if (value > max)
            return max;
        if (value < min)
            return min;
        return value;
    }

    /**
     * Clamp decimal type between 0 and 1.
     *
     * @param value
     * @return
     */
    public static float Clamp01(float value) {
        return Clamp(value, 0f, 1f);
    }

    /**
     * Limit value to over minimum for data type and under maximum for data type.
     *
     * @param value
     * @param dataType
     * @return
     */
    public static float DataTypeClamp(float value, NumberDataType dataType) {
        if (dataType == NumberDataType.Byte)
            return seMath.Clamp(value, (float) (Byte.MAX_VALUE * -1 - 1), (float) Byte.MAX_VALUE);
        if (dataType == NumberDataType.Short)
            return seMath.Clamp(value, (float) (Short.MAX_VALUE * -1 - 1), (float) Short.MAX_VALUE);
        if (dataType == NumberDataType.Int)
            return seMath.Clamp(value, (float) (Integer.MAX_VALUE * -1 - 1), (float) Integer.MAX_VALUE);
        if (dataType == NumberDataType.Long)
            return seMath.Clamp(value, (float) (Long.MAX_VALUE * -1 - 1), (float) Long.MAX_VALUE);

        return value;
    }

    /**
     * Finds smallest number in given values.
     *
     * @param numbers
     * @return
     */
    public static float Min(float... numbers) {
        if (numbers.length == 0)
            return 0f;
        float low = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            if (low > numbers[i])
                low = numbers[i];
        return low;
    }

    /**
     * Finds greatest number in given values.
     *
     * @param numbers
     * @return
     */
    public static float Max(float... numbers) {
        if (numbers.length == 0)
            return 0f;
        float high = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            if (numbers[i] > high)
                high = numbers[i];
        return high;
    }

    /**
     * Finds the average of given numbers.
     *
     * @param numbers
     * @return average of given numbers.
     */
    public static float Average(float... numbers) {
        if (numbers.length == 0)
            return 0;
        return Sum(numbers) / numbers.length;
    }

    /**
     * Adds given numbers.
     *
     * @param numbers
     * @return total of given values.
     */
    public static float Sum(float... numbers) {
        if (numbers.length == 0)
            return 0;
        float total = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            total += numbers[i];
        return total;
    }

    /**
     * Loop through array to find match.
     *
     * @param match   number to find.
     * @param numbers
     * @return true if match is found.
     */
    public static boolean Contains(float match, float... numbers) {
        for (int i = 0; i < numbers.length; i++)
            if (match == numbers[i])
                return true;
        return false;
    }

    /**
     * Check if values are equal to each other.
     *
     * @param numbers
     * @return true if all numbers are the same.
     */
    public static boolean Equals(float... numbers) {
        if (numbers.length < 2)
            return true;
        for (int i = 1; i < numbers.length; i++)
            if (numbers[0] != numbers[i])
                return false;
        return true;
    }

    //endregion

    //region double

    /**
     * Limit value to over minimum and under maximum.
     *
     * @param value
     * @param min   Minimum allowed value.
     * @param max   Maximum allowed value.
     * @return
     */
    public static double Clamp(double value, double min, double max) {
        if (value > max)
            return max;
        if (value < min)
            return min;
        return value;
    }

    /**
     * Clamp decimal type between 0 and 1.
     *
     * @param value
     * @return
     */
    public static double Clamp01(double value) {
        return Clamp(value, 0d, 1d);
    }

    /**
     * Limit value to over minimum for data type and under maximum for data type.
     *
     * @param value
     * @param dataType
     * @return
     */
    public static double DataTypeClamp(double value, NumberDataType dataType) {
        if (dataType == NumberDataType.Byte)
            return seMath.Clamp(value, (double) (Byte.MAX_VALUE * -1 - 1), (double) Byte.MAX_VALUE);
        if (dataType == NumberDataType.Short)
            return seMath.Clamp(value, (double) (Short.MAX_VALUE * -1 - 1), (double) Short.MAX_VALUE);
        if (dataType == NumberDataType.Int)
            return seMath.Clamp(value, (double) (Integer.MAX_VALUE * -1 - 1), (double) Integer.MAX_VALUE);
        if (dataType == NumberDataType.Long)
            return seMath.Clamp(value, (double) (Long.MAX_VALUE * -1 - 1), (double) Long.MAX_VALUE);
        if (dataType == NumberDataType.Float)
            return seMath.Clamp(value, (double) (Float.MAX_VALUE * -1 - 1), (double) Float.MAX_VALUE);

        return value;
    }

    /**
     * Finds smallest number in given values.
     *
     * @param numbers
     * @return
     */
    public static double Min(double... numbers) {
        if (numbers.length == 0)
            return 0d;
        double low = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            if (low > numbers[i])
                low = numbers[i];
        return low;
    }

    /**
     * Finds greatest number in given values.
     *
     * @param numbers
     * @return
     */
    public static double Max(double... numbers) {
        if (numbers.length == 0)
            return 0d;
        double high = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            if (numbers[i] > high)
                high = numbers[i];
        return high;
    }

    /**
     * Finds the average of given numbers.
     *
     * @param numbers
     * @return average of given numbers.
     */
    public static double Average(double... numbers) {
        if (numbers.length == 0)
            return 0;
        return Sum(numbers) / numbers.length;
    }

    /**
     * Adds given numbers.
     *
     * @param numbers
     * @return total of given values.
     */
    public static double Sum(double... numbers) {
        if (numbers.length == 0)
            return 0;
        double total = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            total += numbers[i];
        return total;
    }

    /**
     * Loop through array to find match.
     *
     * @param match   number to find.
     * @param numbers
     * @return true if match is found.
     */
    public static boolean Contains(double match, double... numbers) {
        for (int i = 0; i < numbers.length; i++)
            if (match == numbers[i])
                return true;
        return false;
    }

    /**
     * Check if values are equal to each other.
     *
     * @param numbers
     * @return true if all numbers are the same.
     */
    public static boolean Equals(double... numbers) {
        if (numbers.length < 2)
            return true;
        for (int i = 1; i < numbers.length; i++)
            if (numbers[0] != numbers[i])
                return false;
        return true;
    }

    //endregion

    //region Perlin Noise (Imported)

    /*
     * This file is part of 3DzzD http://dzzd.net/.
     *
     * Released under LGPL
     *
     * 3DzzD is free software: you can redistribute it and/or modify
     * it under the terms of the GNU Lesser General Public License as published by
     * the Free Software Foundation, either version 3 of the License, or
     * (at your option) any later version.
     *
     * 3DzzD is distributed in the hope that it will be useful,
     * but WITHOUT ANY WARRANTY; without even the implied warranty of
     * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     * GNU Lesser General Public License for more details.
     *
     * You should have received a copy of the GNU Lesser General Public License
     * along with 3DzzD.  If not, see <http://www.gnu.org/licenses/>.
     *
     * Copyright 2005 - 20010 Bruno Augier
     */


    /**
     * Fast perlin noise generation
     * <p>
     * Generate a perlin noise with 8 octave and a persistence of 0.5
     * <p>
     * NB:
     * - output range between 0 and 255
     * - maximum octave = 7
     * <p>
     * you can change type of noise between grad & value noise by commenting/uncommenting block
     * you can change type of interpolation between bicubic/bilinear by commenting/uncommenting block
     */
    public static long PerlinNoise(double x, double y, float zoom, int nbOctave) {
        long result = 0;
        long frequence256 = (long) (256 * zoom);
        long sx = (long) (x / 128f * frequence256);
        long sy = (long) (y / 128f * frequence256);
        long octave = nbOctave;
        while (octave != 0) {
            long bX = sx & 0xFF;
            long bY = sy & 0xFF;

            long sxp = sx >> 8;
            long syp = sy >> 8;


            //Compute noise for each corner of current cell
            long Y1376312589_00 = syp * 1376312589;
            long Y1376312589_01 = Y1376312589_00 + 1376312589;

            long XY1376312589_00 = sxp + Y1376312589_00;
            long XY1376312589_10 = XY1376312589_00 + 1;
            long XY1376312589_01 = sxp + Y1376312589_01;
            long XY1376312589_11 = XY1376312589_01 + 1;

            long XYBASE_00 = (XY1376312589_00 << 13) ^ XY1376312589_00;
            long XYBASE_10 = (XY1376312589_10 << 13) ^ XY1376312589_10;
            long XYBASE_01 = (XY1376312589_01 << 13) ^ XY1376312589_01;
            long XYBASE_11 = (XY1376312589_11 << 13) ^ XY1376312589_11;

            long alt1 = (XYBASE_00 * (XYBASE_00 * XYBASE_00 * 15731 + 789221) + 1376312589);
            long alt2 = (XYBASE_10 * (XYBASE_10 * XYBASE_10 * 15731 + 789221) + 1376312589);
            long alt3 = (XYBASE_01 * (XYBASE_01 * XYBASE_01 * 15731 + 789221) + 1376312589);
            long alt4 = (XYBASE_11 * (XYBASE_11 * XYBASE_11 * 15731 + 789221) + 1376312589);

            /*
             *NOTE : on  for true grandiant noise uncomment following block
             * for true gradiant we need to perform scalar product here, gradiant vector are created/deducted using
             * the above pseudo random values (alt1...alt4) : by cutting thoses values in twice values to get for each a fixed x,y vector
             * gradX1= alt1&0xFF
             * gradY1= (alt1&0xFF00)>>8
             *
             * the last part of the PRN (alt1&0xFF0000)>>8 is used as an offset to correct one of the gradiant problem wich is zero on cell edge
             *
             * source vector (sXN;sYN) for scalar product are computed using (bX,bY)
             *
             * each four values  must be replaced by the result of the following
             * altN=(gradXN;gradYN) scalar (sXN;sYN)
             *
             * all the rest of the code (longerpolation+accumulation) is identical for value & gradiant noise
             */


            /*START BLOCK FOR TRUE GRADIANT NOISE*/

            long grad1X = (alt1 & 0xFF) - 128;
            long grad1Y = ((alt1 >> 8) & 0xFF) - 128;
            long grad2X = (alt2 & 0xFF) - 128;
            long grad2Y = ((alt2 >> 8) & 0xFF) - 128;
            long grad3X = (alt3 & 0xFF) - 128;
            long grad3Y = ((alt3 >> 8) & 0xFF) - 128;
            long grad4X = (alt4 & 0xFF) - 128;
            long grad4Y = ((alt4 >> 8) & 0xFF) - 128;


            long sX1 = bX >> 1;
            long sY1 = bY >> 1;
            long sX2 = 128 - sX1;
            long sY2 = sY1;
            long sX3 = sX1;
            long sY3 = 128 - sY1;
            long sX4 = 128 - sX1;
            long sY4 = 128 - sY1;
            alt1 = (grad1X * sX1 + grad1Y * sY1) + 16384 + ((alt1 & 0xFF0000) >> 9); //to avoid seams to be 0 we use an offset
            alt2 = (grad2X * sX2 + grad2Y * sY2) + 16384 + ((alt2 & 0xFF0000) >> 9);
            alt3 = (grad3X * sX3 + grad3Y * sY3) + 16384 + ((alt3 & 0xFF0000) >> 9);
            alt4 = (grad4X * sX4 + grad4Y * sY4) + 16384 + ((alt4 & 0xFF0000) >> 9);

            /*END BLOCK FOR TRUE GRADIANT NOISE */


            /*START BLOCK FOR VALUE NOISE*/
         /*
          alt1&=0xFFFF;
          alt2&=0xFFFF;
          alt3&=0xFFFF;
          alt4&=0xFFFF;
          */
            /*END BLOCK FOR VALUE NOISE*/


            /*START BLOCK FOR LINEAR INTERPOLATION*/
            //BiLinear longerpolation

            long f24 = (bX * bY) >> 8;
            long f23 = bX - f24;
            long f14 = bY - f24;
            long f13 = 256 - f14 - f23 - f24;
            long val = (alt1 * f13 + alt2 * f23 + alt3 * f14 + alt4 * f24);

            /*END BLOCK FOR LINEAR INTERPOLATION*/


            //BiCubic longerpolation ( in the form alt(bX) = alt[n] - (3*bX^2 - 2*bX^3) * (alt[n] - alt[n+1]) )
            /*START BLOCK FOR BICUBIC INTERPOLATION*/
            /*
            long bX2 = (bX * bX) >> 8;
            long bX3 = (bX2 * bX) >> 8;
            long _3bX2 = 3 * bX2;
            long _2bX3 = 2 * bX3;
            long alt12 = alt1 - (((_3bX2 - _2bX3) * (alt1 - alt2)) >> 8);
            long alt34 = alt3 - (((_3bX2 - _2bX3) * (alt3 - alt4)) >> 8);


            long bY2 = (bY * bY) >> 8;
            long bY3 = (bY2 * bY) >> 8;
            long _3bY2 = 3 * bY2;
            long _2bY3 = 2 * bY3;
            long val = alt12 - (((_3bY2 - _2bY3) * (alt12 - alt34)) >> 8);

            val *= 256;
            */
            /*END BLOCK FOR BICUBIC INTERPOLATION*/


            //Accumulate in result
            result += (val << octave);

            octave--;
            sx <<= 1;
            sy <<= 1;

        }
        return result >>> (16 + nbOctave + 1);
    }

    //endregion

}
