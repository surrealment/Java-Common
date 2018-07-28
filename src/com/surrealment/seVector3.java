package com.surrealment;

public class seVector3 {

    /**
     * Vector3(0, 0, -1)
     */
    final public static seVector3 back = new seVector3(0, 0, -1);
    /**
     * Vector3(0, -1, 1)
     */
    final public static seVector3 down = new seVector3(0, -1, 1);
    /**
     * Vector3(0, 0, 1)
     */
    final public static seVector3 forward = new seVector3(0, 0, 1);
    /**
     * Vector3(-1, 0, 0)
     */
    final public static seVector3 left = new seVector3(-1, 0, 0);
    /**
     * Vector3(1, 1, 1)
     */
    final public static seVector3 one = new seVector3(1, 1, 1);
    /**
     * Vector3(1, 0, 0)
     */
    final public static seVector3 right = new seVector3(1, 0, 0);
    /**
     * Vector3(0, 1, 0)
     */
    final public static seVector3 up = new seVector3(0, 1, 0);
    /**
     * Vector3(0, 0, 0)
     */
    final public static seVector3 zero = new seVector3(0, 0, 0);
    /**
     * Creates new vector using negative infinity.
     */
    final public static seVector3 negativeInfinity = new seVector3(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    /**
     * Creates new vector using positive infinity.
     */
    final public static seVector3 positiveInfinity = new seVector3(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    /**
     * Provides the smallest possible vector.
     */
    final public static seVector3 min = new seVector3(Float.MAX_VALUE * -1f - 1f, Float.MAX_VALUE * -1f - 1f, Float.MAX_VALUE * -1f - 1f);
    /**
     * Provides the largest possible vector.
     */
    final public static seVector3 max = new seVector3(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
    public float x = 0.0f;
    public float y = 0.0f;
    public float z = 0.0f;

    /**
     * Initialize Vector3 with zero values.
     */
    public seVector3() {
        this(0, 0, 0);
    }

    /**
     * Initialize Vector3 with int values.
     *
     * @param x
     * @param y
     * @param z
     */
    public seVector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Initialize Vector3 with float values.
     *
     * @param x
     * @param y
     * @param z
     */
    public seVector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Provides new random vector.
     * Note: Integer used to determine min and max values.
     */
    final public static seVector3 Random() {
        final float min = (float) Integer.MAX_VALUE * -1 - 1;
        final float max = (float) Integer.MAX_VALUE;
        return new seVector3(seRandom.Range(min, max), seRandom.Range(min, max), seRandom.Range(min, max));
    }

    /**
     * Provides new positive random vector.
     * Note: Integer used to determine min and max values.
     */
    final public static seVector3 RandomPositive() {
        final float min = 1f;
        final float max = Integer.MAX_VALUE;
        return new seVector3(seRandom.Range(min, max), seRandom.Range(min, max), seRandom.Range(min, max));
    }

    /**
     * Provides new negative random vector.
     * Note: Integer used to determine min and max values.
     */
    final public static seVector3 RandomNegative() {
        final float min = (float) Integer.MAX_VALUE * -1 - 1;
        final float max = -1f;
        return new seVector3(seRandom.Range(min, max), seRandom.Range(min, max), seRandom.Range(min, max));
    }

    /**
     * Provides new vector within random range.
     *
     * @param min
     * @param max
     * @return
     */
    final public static seVector3 RandomRange(float min, float max) {
        if (min > max) {
            float temp = min;
            min = max;
            max = temp;
        }
        return new seVector3(seRandom.Range(min, max), seRandom.Range(min, max), seRandom.Range(min, max));
    }

    /**
     * Force vector to be within scope.
     *
     * @param vector
     * @param min
     * @param max
     * @return
     */
    final public static seVector3 Clamp(seVector3 vector, seVector3 min, seVector3 max) {
        return Min(Max(vector, Min(min, max)), Max(min, max));
    }

    /**
     * Force vector to be within ranges.
     * Note: If ranges length is less than 2 it could create undesired results.
     *
     * @param vector
     * @param ranges
     * @return
     */
    final public static seVector3 ClampAll(seVector3 vector, seVector3... ranges) {
        if (ranges.length == 0)
            return vector;
        if (ranges.length == 1)
            return ranges[0];
        return Min(Max(vector, seVector3.MinAll(ranges)), seVector3.MaxAll(ranges));
    }

    /**
     * Returns true if any values in vector a is greater then vector b values.
     *
     * @param a
     * @param b
     * @return
     */
    final public static boolean AnyGreaterThan(seVector3 a, seVector3 b) {
        return a.x > b.x || a.y > b.y || a.z > b.z;
    }

    /**
     * Returns true if any values in vector a is less then vector b values.
     *
     * @param a
     * @param b
     * @return
     */
    final public static boolean AnyLessThan(seVector3 a, seVector3 b) {
        return a.x < b.x || a.y < b.y || a.z < b.z;
    }

    /**
     * Provides distance between vectors.
     *
     * @param a
     * @param b
     * @return
     */
    final public static Float Distance(seVector3 a, seVector3 b) {
        return (float) Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2) + Math.pow(a.z - b.z, 2));
    }

    /**
     * Adds two vectors.
     *
     * @param a
     * @param b
     * @return
     */
    final public static seVector3 Add(seVector3 a, seVector3 b) {
        return new seVector3(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    /**
     * Subtracts two vectors.
     *
     * @param a
     * @param b
     * @return
     */
    final public static seVector3 Subtract(seVector3 a, seVector3 b) {
        return new seVector3(a.x - b.x, a.y - b.y, a.z - b.z);
    }

    /**
     * Magnitude of a vector.
     * Note: Finds square root which can be expensive.
     *
     * @param vector
     * @return
     */
    public static float Magnitude(seVector3 vector) {
        return (float) Math.sqrt((float) ((double) vector.x * (double) vector.x + (double) vector.y * (double) vector.y + (double) vector.z * (double) vector.z));
    }

    /**
     * Magnitude of a vector.
     *
     * @param vector
     * @return
     */
    public static float SqrMagnitude(seVector3 vector) {
        return (float) ((double) vector.x * (double) vector.x + (double) vector.y * (double) vector.y + (double) vector.z * (double) vector.z);
    }

    /**
     * Calculates the dot product of two vectors.
     *
     * @param a
     * @param b
     * @return
     */
    public static float Dot(seVector3 a, seVector3 b) {
        return (float) ((double) a.x * (double) b.x + (double) a.y * (double) b.y + (double) a.z * (double) b.z);
    }

    /**
     * Multiply a vector by a decimal number.
     * Note: Replaced by {@link #Scale(seVector3, float)}.
     *
     * @param vector
     * @param multiplier
     * @return
     */
    @Deprecated
    final public static seVector3 Multiply(seVector3 vector, float multiplier) {
        return Scale(vector, multiplier);
    }

    /**
     * Multiply a vector by a decimal nuber.
     *
     * @param vector
     * @param multiplier
     * @return
     */
    final public static seVector3 Scale(seVector3 vector, float multiplier) {
        return new seVector3(vector.x * multiplier, vector.y * multiplier, vector.z * multiplier);
    }

    /**
     * Divide a vector by a number.
     *
     * @param vector
     * @param divider
     * @return
     */
    final public static seVector3 Divide(seVector3 vector, float divider) {
        if (divider == 0)
            return seVector3.zero;
        return new seVector3(vector.x / divider, vector.y / divider, vector.z / divider);
    }

    /**
     * Returns true if two or more vectors are equal.
     *
     * @param vectors
     * @return
     */
    final public static boolean EqualAll(seVector3... vectors) {
        if (vectors.length < 2)
            return true;
        seVector3 first = vectors[0];
        for (int i = 0; i < vectors.length; i++)
            if (!first.equals(vectors))
                return false;
        return true;
    }

    /**
     * Convert string to vector.
     *
     * @param s
     * @return
     */
    final public static seVector3 TryParse(String s) {
        s = seString.NullCheck(s).replace("\"", "").trim().toLowerCase();

        switch (s) {
            case "min":
                return seVector3.min;
            case "max":
                return seVector3.max;
            case "back":
                return seVector3.back;
            case "down":
                return seVector3.down;
            case "forward":
                return seVector3.forward;
            case "left":
                return seVector3.left;
            case "one":
                return seVector3.one;
            case "right":
                return seVector3.right;
            case "up":
                return seVector3.up;
            case "ran":
                return Random();
            case "pos":
                return RandomPositive();
            case "neg":
                return RandomNegative();
            case "":
            case "null":
            case "zero":
                return seVector3.zero;
        }

        // Find character vector has been split with.
        char[] del = new char[]{',', '|', '_', ' ', ':'};
        int pass = -1;
        for (int i = 0; i < del.length; i++) {
            int count = 0;
            for (int d = 0; d < s.length(); d++) {
                if (s.charAt(d) == del[i])
                    count++;
            }
            if (count == 2) {
                pass = i;
                break;
            }
        }

        // If no delimiters are found stop parse.
        if (pass == -1)
            return seVector3.zero;


        // Get rid of other possible delimiters
        for (int i = 0; i < del.length; i++) {
            if (i == pass)
                continue;
            s = s.replace(String.valueOf(del[i]), "");
        }

        String[] sa = s.split(String.valueOf(del[pass]));
        return new seVector3(seString.TryParseFloat(sa[0]), seString.TryParseFloat(sa[1]), seString.TryParseFloat(sa[2]));
    }

    /**
     * Linearly interpolates between two vectors.
     *
     * @param a
     * @param b
     * @param t
     * @return
     */
    final public static seVector3 Lerp(seVector3 a, seVector3 b, float t) {
        t = seMath.Clamp01(t);
        return new seVector3(a.x + (b.x - a.x) * t, a.y + (b.y - a.y) * t, a.z + (b.z - a.z) * t);
    }

    /**
     * Returns a new vector with smallest values between two vectors.
     *
     * @param a
     * @param b
     * @return
     */
    public static seVector3 Min(seVector3 a, seVector3 b) {
        return new seVector3(seMath.Min(a.x, b.x), seMath.Min(a.y, b.y), seMath.Min(a.z, b.z));
    }

    /**
     * Returns a new vector with smallest values between multiple vectors.
     * Note: This method is slower than {@link #Min(seVector3, seVector3)} if using 2 vectors.
     *
     * @param vectors
     * @return
     */
    public static seVector3 MinAll(seVector3... vectors) {
        float[] x = new float[vectors.length];
        float[] y = new float[vectors.length];
        float[] z = new float[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            x[i] = vectors[i].x;
            y[i] = vectors[i].y;
            z[i] = vectors[i].z;
        }
        return new seVector3(seMath.Min(x), seMath.Min(y), seMath.Min(z));
    }

    /**
     * Returns a new vector with largest values between two vectors.
     *
     * @param a
     * @param b
     * @return
     */
    public static seVector3 Max(seVector3 a, seVector3 b) {
        return new seVector3(seMath.Max(a.x, b.x), seMath.Max(a.y, b.y), seMath.Max(a.z, b.z));
    }

    /**
     * Returns a new vector with greatest values between multiple vectors.
     * Note: This method is slower than {@link #Max(seVector3, seVector3)} if using 2 vectors.
     *
     * @param vectors
     * @return
     */
    public static seVector3 MaxAll(seVector3... vectors) {
        float[] x = new float[vectors.length];
        float[] y = new float[vectors.length];
        float[] z = new float[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            x[i] = vectors[i].x;
            y[i] = vectors[i].y;
            z[i] = vectors[i].z;
        }
        return new seVector3(seMath.Max(x), seMath.Max(y), seMath.Max(z));
    }

    @Override
    public String toString() {
        java.text.DecimalFormat d = new java.text.DecimalFormat();
        d.setDecimalSeparatorAlwaysShown(true);
        d.setMaximumIntegerDigits(99);
        d.setMinimumIntegerDigits(1);
        d.setMaximumFractionDigits(5);
        d.setMinimumFractionDigits(1);
        d.setGroupingUsed(false);

        return "(" + d.format(this.x) + ", " + d.format(this.y) + ", " + d.format(this.z) + ")";
        // return "(" + sString.Simplify(this.x, 2) + ", " + sString.Simplify(this.y, 2) + ", " + sString.Simplify(this.z, 2) + ")";
    }

    @Override
    final public boolean equals(Object o) {
        // Return true if itself.
        if (o == this)
            return true;

        // Make sure this is a Vector3 object.
        if (!(o instanceof seVector3))
            return false;

        // Convert to Vector3.
        seVector3 c = (seVector3) o;

        // Compare x, y and z
        return Float.compare(this.x, c.x) == 0 && Float.compare(this.y, c.y) == 0 && Float.compare(this.z, c.z) == 0;
    }

    /**
     * Sets this vector without creating a new one.
     *
     * @param x
     * @param y
     * @param z
     */
    final public void set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Returns true if x, y or z are greater than other vector.
     *
     * @param vector
     * @return
     */
    final public boolean anyGreaterThan(seVector3 vector) {
        return AnyGreaterThan(this, vector);
    }

    /**
     * Returns true if x, y or z are less than other vector.
     *
     * @param vector
     * @return
     */
    final public boolean anyLessThan(seVector3 vector) {
        return AnyLessThan(this, vector);
    }

    /**
     * Provides distance to another vector.
     *
     * @param other
     * @return
     */
    final public Float distanceTo(seVector3 other) {
        return Distance(this, other);
    }

    /**
     * Adds another vector.
     *
     * @param vector
     * @return
     */
    final public seVector3 add(seVector3 vector) {
        return Add(this, vector);
    }

    /**
     * Subtracts another vector.
     *
     * @param vector
     * @return
     */
    final public seVector3 subtract(seVector3 vector) {
        return Subtract(this, vector);
    }

    /**
     * Magnitude of this vector.
     * Note: Finds square root which can be expensive.
     *
     * @return
     */
    final public float magnitude() {
        return Magnitude(this);
    }

    /**
     * Magnitude of this vector.
     *
     * @return
     */
    final public float sqrMagnitude() {
        return SqrMagnitude(this);
    }

    /**
     * Calculates the dot product of another vector.
     *
     * @param v
     * @return
     */
    final public float dot(seVector3 v) {
        return Dot(this, v);
    }

    /**
     * Multiplies vector by a decimal number.
     *
     * @param multiplier
     * @return
     */
    final public seVector3 multiply(float multiplier) {
        return Scale(this, multiplier);
    }

    /**
     * Divides vector by a number.
     *
     * @param divider
     * @return
     */
    final public seVector3 divide(float divider) {
        return Divide(this, divider);
    }

    /**
     * Create a selection between 2 vectors.
     */
    public static class Selection {
        /**
         * Selection minimum.
         */
        public seVector3 pos1;
        /**
         * Selection maximum.
         */
        public seVector3 pos2;

        /**
         * Initialize with 2 vectors.
         *
         * @param pos1
         * @param pos2
         */
        public Selection(seVector3 pos1, seVector3 pos2) {
            if (pos1 == null)
                pos1 = seVector3.min;
            if (pos2 == null)
                pos2 = seVector3.max;
            // Get smallest xyz to make pos1 vector.
            this.pos1 = seVector3.Min(pos1, pos2);
            // Get largest xyz to make pos2 vector.
            this.pos2 = seVector3.Max(pos1, pos2);
        }

        /**
         * Initialize with the largest possible selection.
         */
        public Selection() {
            this.pos1 = seVector3.min;
            this.pos2 = seVector3.max;
        }

        /**
         * Verifies value is within x selection.
         *
         * @param value
         * @return
         */
        public boolean inRangeX(float value) {
            return value >= pos1.x && value <= pos2.x;
        }

        /**
         * Verifies value is within x selection.
         *
         * @param value
         * @return
         */
        public boolean inRangeX(int value) {
            return value >= pos1.x && value <= pos2.x;
        }

        /**
         * Verifies all values are within x selection.
         *
         * @param values
         * @return
         */
        public boolean inRangeAllX(float... values) {
            for (int i = 0; i < values.length; i++)
                if (values[i] < pos1.x && values[i] > pos2.x)
                    return false;
            return true;
        }

        /**
         * Verifies all values are within x selection.
         *
         * @param values
         * @return
         */
        public boolean inRangeAllX(int... values) {
            for (int i = 0; i < values.length; i++)
                if (values[i] < pos1.x && values[i] > pos2.x)
                    return false;
            return true;
        }

        /**
         * Verifies value is within y selection.
         *
         * @param value
         * @return
         */
        public boolean inRangeY(float value) {
            return value >= pos1.y && value <= pos2.y;
        }

        /**
         * Verifies value is within y selection.
         *
         * @param value
         * @return
         */
        public boolean inRangeY(int value) {
            return value >= pos1.y && value <= pos2.y;
        }

        /**
         * Verifies all values are within y selection.
         *
         * @param values
         * @return
         */
        public boolean inRangeAllY(float... values) {
            for (int i = 0; i < values.length; i++)
                if (values[i] < pos1.y && values[i] > pos2.y)
                    return false;
            return true;
        }

        /**
         * Verifies all values are within y selection.
         *
         * @param values
         * @return
         */
        public boolean inRangeAllY(int... values) {
            for (int i = 0; i < values.length; i++)
                if (values[i] < pos1.y && values[i] > pos2.y)
                    return false;
            return true;
        }

        /**
         * Verifies value is within z selection.
         *
         * @param value
         * @return
         */
        public boolean inRangeZ(float value) {
            return value >= pos1.z && value <= pos2.z;
        }

        /**
         * Verifies value is within z selection.
         *
         * @param value
         * @return
         */
        public boolean inRangeZ(int value) {
            return value >= pos1.z && value <= pos2.z;
        }

        /**
         * Verifies all values are within z selection.
         *
         * @param values
         * @return
         */
        public boolean inRangeAllZ(float... values) {
            for (int i = 0; i < values.length; i++)
                if (values[i] < pos1.z && values[i] > pos2.z)
                    return false;
            return true;
        }

        /**
         * Verifies all values are within z selection.
         *
         * @param values
         * @return
         */
        public boolean inRangeAllZ(int... values) {
            for (int i = 0; i < values.length; i++)
                if (values[i] < pos1.z && values[i] > pos2.z)
                    return false;
            return true;
        }

        /**
         * Verifies vector floats are within selection.
         *
         * @param x
         * @param y
         * @param z
         * @return
         */
        public boolean inRange(float x, float y, float z) {
            return x >= pos1.x && y >= pos1.y && z >= pos1.z && x <= pos2.x && y <= pos2.y && z <= pos2.z;
        }

        /**
         * Verifies vector ints are within selection.
         *
         * @param x
         * @param y
         * @param z
         * @return
         */
        public boolean inRange(int x, int y, int z) {
            return x >= pos1.x && y >= pos1.y && z >= pos1.z && x <= pos2.x && y <= pos2.y && z <= pos2.z;
        }

        /**
         * Verifies vector is within selection.
         *
         * @param vector
         * @return
         */
        public boolean inRange(seVector3 vector) {
            return vector.x >= pos1.x && vector.y >= pos1.y && vector.z >= pos1.z && vector.x <= pos2.x && vector.y <= pos2.y && vector.z <= pos2.z;
        }

        /**
         * Verifies vectors are within selection.
         *
         * @param vectors
         * @return
         */
        public boolean inRangeAll(seVector3... vectors) {
            for (int i = 0; i < vectors.length; i++) {
                seVector3 vector = vectors[i];
                if (vector.x < pos1.x && vector.y < pos1.y && vector.z < pos1.z && vector.x > pos2.x && vector.y > pos2.y && vector.z > pos2.z)
                    return false;
            }
            return true;
        }

        /**
         * Keep selection within range of min to max.
         *
         * @param min
         * @param max
         */
        public void clamp(seVector3 min, seVector3 max) {
            pos1 = seVector3.ClampAll(pos1, min, max);
            pos2 = seVector3.ClampAll(pos2, min, max);
        }
    }
}
