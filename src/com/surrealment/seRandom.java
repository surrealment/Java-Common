package com.surrealment;

public class sRandom {

    /**
     * Generate number greater or equal to minimum and less than or equal to maximum.
     *
     * @param min
     * @param max
     * @return
     */
    public static short Range(short min, short max) {
        if (min > max) {
            short temp = min;
            min = max;
            max = temp;
        }
        java.util.Random r = new java.util.Random();
        return (short) (r.nextInt((int) max - (int) min) + (int) min);
    }

    /**
     * Generate number greater or equal to minimum and less than or equal to maximum.
     *
     * @param min
     * @param max
     * @return
     */
    public static int Range(int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        java.util.Random r = new java.util.Random();
        return r.nextInt(max - min) + min;
    }

    /**
     * Generate number greater or equal to minimum and less than or equal to maximum.
     *
     * @param min
     * @param max
     * @return
     */
    public static long Range(long min, long max) {
        double _min = min;
        double _max = max;
        if (min > max) {
            _min = max;
            _max = min;
        }
        java.util.Random r = new java.util.Random();
        return (long) (r.nextDouble() * (_max - _min) + _min);
    }

    /**
     * Generate number greater or equal to minimum and less than or equal to maximum.
     *
     * @param min
     * @param max
     * @return
     */
    public static float Range(float min, float max) {
        double _min = min;
        double _max = max;
        if (min > max) {
            _min = max;
            _max = min;
        }
        java.util.Random r = new java.util.Random();
        return (float) (r.nextDouble() * (_max - _min) + _min);
    }

}
