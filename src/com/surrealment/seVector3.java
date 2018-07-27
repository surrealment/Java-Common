package com.surrealment;

public class Vector3 {

    /**
     * Vector3(0, 0, -1)
     */
    final public static Vector3 back = new Vector3(0, 0, -1);
    /**
     * Vector3(0, -1, 1)
     */
    final public static Vector3 down = new Vector3(0, -1, 1);
    /**
     * Vector3(0, 0, 1)
     */
    final public static Vector3 forward = new Vector3(0, 0, 1);
    /**
     * Vector3(-1, 0, 0)
     */
    final public static Vector3 left = new Vector3(-1, 0, 0);
    /**
     * Vector3(1, 1, 1)
     */
    final public static Vector3 one = new Vector3(1, 1, 1);
    /**
     * Vector3(1, 0, 0)
     */
    final public static Vector3 right = new Vector3(1, 0, 0);
    /**
     * Vector3(0, 1, 0)
     */
    final public static Vector3 up = new Vector3(0, 1, 0);
    /**
     * Vector3(0, 0, 0)
     */
    final public static Vector3 zero = new Vector3(0, 0, 0);
    /**
     * Creates new vector using negative infinity.
     */
    final public static Vector3 negativeInfinity = new Vector3(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    /**
     * Creates new vector using positive infinity.
     */
    final public static Vector3 positiveInfinity = new Vector3(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    /**
     * Provides the smallest possible vector.
     */
    final public static Vector3 min = new Vector3(Float.MAX_VALUE * -1f - 1f, Float.MAX_VALUE * -1f - 1f, Float.MAX_VALUE * -1f - 1f);
    /**
     * Provides the largest possible vector.
     */
    final public static Vector3 max = new Vector3(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
    public float x = 0.0f;
    public float y = 0.0f;
    public float z = 0.0f;

    /**
     * Initialize Vector3 with zero values.
     */
    public Vector3() {
        this(0, 0, 0);
    }

    /**
     * Initialize Vector3 with int values.
     *
     * @param x
     * @param y
     * @param z
     */
    public Vector3(int x, int y, int z) {
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
    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Provides new random vector.
     * Note: Integer used to determine min and max values.
     */
    final public static Vector3 Random() {
        final float min = (float) Integer.MAX_VALUE * -1 - 1;
        final float max = (float) Integer.MAX_VALUE;
        return new Vector3(sRandom.Range(min, max), sRandom.Range(min, max), sRandom.Range(min, max));
    }

    /**
     * Provides new positive random vector.
     * Note: Integer used to determine min and max values.
     */
    final public static Vector3 RandomPositive() {
        final float min = 1f;
        final float max = Integer.MAX_VALUE;
        return new Vector3(sRandom.Range(min, max), sRandom.Range(min, max), sRandom.Range(min, max));
    }

    /**
     * Provides new negative random vector.
     * Note: Integer used to determine min and max values.
     */
    final public static Vector3 RandomNegative() {
        final float min = (float) Integer.MAX_VALUE * -1 - 1;
        final float max = -1f;
        return new Vector3(sRandom.Range(min, max), sRandom.Range(min, max), sRandom.Range(min, max));
    }

    /**
     * Provides new vector within random range.
     *
     * @param min
     * @param max
     * @return
     */
    final public static Vector3 RandomRange(float min, float max) {
        if (min > max) {
            float temp = min;
            min = max;
            max = temp;
        }
        return new Vector3(sRandom.Range(min, max), sRandom.Range(min, max), sRandom.Range(min, max));
    }

    /**
     * Force vector to be within scope.
     *
     * @param vector
     * @param min
     * @param max
     * @return
     */
    final public static Vector3 Clamp(Vector3 vector, Vector3 min, Vector3 max) {
        return Min(Max(vector, min), max);
    }

    /**
     * Force vector to be within ranges.
     * Note: If ranges length is less than 2 it could create undesired results.
     *
     * @param vector
     * @param ranges
     * @return
     */
    final public static Vector3 ClampAll(Vector3 vector, Vector3... ranges) {
        if(ranges.length == 0)
            return vector;
        if(ranges.length == 1)
            return ranges[0];
        return Min(Max(vector, Vector3.MinAll(ranges)), Vector3.MaxAll(ranges));
    }

    /**
     * Returns true if any values in vector a is greater then vector b values.
     *
     * @param a
     * @param b
     * @return
     */
    final public static boolean AnyGreaterThan(Vector3 a, Vector3 b) {
        return a.x > b.x || a.y > b.y || a.z > b.z;
    }

    /**
     * Returns true if any values in vector a is less then vector b values.
     *
     * @param a
     * @param b
     * @return
     */
    final public static boolean AnyLessThan(Vector3 a, Vector3 b) {
        return a.x < b.x || a.y < b.y || a.z < b.z;
    }

    /**
     * Provides distance between vectors.
     *
     * @param a
     * @param b
     * @return
     */
    final public static Float Distance(Vector3 a, Vector3 b) {
        return (float) Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2) + Math.pow(a.z - b.z, 2));
    }

    /**
     * Adds two vectors.
     *
     * @param a
     * @param b
     * @return
     */
    final public static Vector3 Add(Vector3 a, Vector3 b) {
        return new Vector3(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    /**
     * Subtracts two vectors.
     *
     * @param a
     * @param b
     * @return
     */
    final public static Vector3 Subtract(Vector3 a, Vector3 b) {
        return new Vector3(a.x - b.x, a.y - b.y, a.z - b.z);
    }

    /**
     * Magnitude of a vector.
     * Note: Finds square root which can be expensive.
     *
     * @param vector
     * @return
     */
    public static float Magnitude(Vector3 vector) {
        return (float) Math.sqrt((float) ((double) vector.x * (double) vector.x + (double) vector.y * (double) vector.y + (double) vector.z * (double) vector.z));
    }

    /**
     * Magnitude of a vector.
     *
     * @param vector
     * @return
     */
    public static float SqrMagnitude(Vector3 vector) {
        return (float) ((double) vector.x * (double) vector.x + (double) vector.y * (double) vector.y + (double) vector.z * (double) vector.z);
    }

    /**
     * Calculates the dot product of two vectors.
     *
     * @param a
     * @param b
     * @return
     */
    public static float Dot(Vector3 a, Vector3 b) {
        return (float) ((double) a.x * (double) b.x + (double) a.y * (double) b.y + (double) a.z * (double) b.z);
    }

    /**
     * Multiply a vector by a decimal number.
     * Note: Replaced by {@link #Scale(Vector3, float)}.
     *
     * @param vector
     * @param multiplier
     * @return
     */
    @Deprecated
    final public static Vector3 Multiply(Vector3 vector, float multiplier) {
        return Scale(vector, multiplier);
    }

    /**
     * Multiply a vector by a decimal nuber.
     *
     * @param vector
     * @param multiplier
     * @return
     */
    final public static Vector3 Scale(Vector3 vector, float multiplier) {
        return new Vector3(vector.x * multiplier, vector.y * multiplier, vector.z * multiplier);
    }

    /**
     * Divide a vector by a number.
     *
     * @param vector
     * @param divider
     * @return
     */
    final public static Vector3 Divide(Vector3 vector, float divider) {
        if (divider == 0)
            return Vector3.zero;
        return new Vector3(vector.x / divider, vector.y / divider, vector.z / divider);
    }

    /**
     * Returns true if two or more vectors are equal.
     *
     * @param vectors
     * @return
     */
    final public static boolean EqualAll(Vector3... vectors) {
        if (vectors.length < 2)
            return true;
        Vector3 first = vectors[0];
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
    final public static Vector3 TryParse(String s) {
        s = sString.NullCheck(s).replace("\"", "").trim().toLowerCase();

        switch (s) {
            case "min":
                return Vector3.min;
            case "max":
                return Vector3.max;
            case "back":
                return Vector3.back;
            case "down":
                return Vector3.down;
            case "forward":
                return Vector3.forward;
            case "left":
                return Vector3.left;
            case "one":
                return Vector3.one;
            case "right":
                return Vector3.right;
            case "up":
                return Vector3.up;
            case "ran":
                return Random();
            case "pos":
                return RandomPositive();
            case "neg":
                return RandomNegative();
            case "":
            case "null":
            case "zero":
                return Vector3.zero;
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
            return Vector3.zero;


        // Get rid of other possible delimiters
        for (int i = 0; i < del.length; i++) {
            if (i == pass)
                continue;
            s = s.replace(String.valueOf(del[i]), "");
        }

        String[] sa = s.split(String.valueOf(del[pass]));
        return new Vector3(sMath.TryParseFloat(sa[0]), sMath.TryParseFloat(sa[1]), sMath.TryParseFloat(sa[2]));
    }

    /**
     * Linearly interpolates between two vectors.
     *
     * @param a
     * @param b
     * @param t
     * @return
     */
    final public static Vector3 Lerp(Vector3 a, Vector3 b, float t) {
        t = sMath.Clamp01(t);
        return new Vector3(a.x + (b.x - a.x) * t, a.y + (b.y - a.y) * t, a.z + (b.z - a.z) * t);
    }

    /**
     * Returns a new vector with smallest values between two vectors.
     *
     * @param a
     * @param b
     * @return
     */
    public static Vector3 Min(Vector3 a, Vector3 b) {
        return new Vector3(sMath.Min(a.x, b.x), sMath.Min(a.y, b.y), sMath.Min(a.z, b.z));
    }

    /**
     * Returns a new vector with smallest values between multiple vectors.
     * Note: This method is slower than {@link #Min(Vector3, Vector3)} if using 2 vectors.
     *
     * @param vectors
     * @return
     */
    public static Vector3 MinAll(Vector3... vectors) {
        float[] x = new float[vectors.length];
        float[] y = new float[vectors.length];
        float[] z = new float[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            x[i] = vectors[i].x;
            y[i] = vectors[i].y;
            z[i] = vectors[i].z;
        }
        return new Vector3(sMath.Min(x), sMath.Min(y), sMath.Min(z));
    }

    /**
     * Returns a new vector with largest values between two vectors.
     *
     * @param a
     * @param b
     * @return
     */
    public static Vector3 Max(Vector3 a, Vector3 b) {
        return new Vector3(sMath.Max(a.x, b.x), sMath.Max(a.y, b.y), sMath.Max(a.z, b.z));
    }

    /**
     * Returns a new vector with greatest values between multiple vectors.
     * Note: This method is slower than {@link #Max(Vector3, Vector3)} if using 2 vectors.
     *
     * @param vectors
     * @return
     */
    public static Vector3 MaxAll(Vector3... vectors) {
        float[] x = new float[vectors.length];
        float[] y = new float[vectors.length];
        float[] z = new float[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            x[i] = vectors[i].x;
            y[i] = vectors[i].y;
            z[i] = vectors[i].z;
        }
        return new Vector3(sMath.Max(x), sMath.Max(y), sMath.Max(z));
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
        if (!(o instanceof Vector3))
            return false;

        // Convert to Vector3.
        Vector3 c = (Vector3) o;

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
    final public boolean anyGreaterThan(Vector3 vector) {
        return AnyGreaterThan(this, vector);
    }

    /**
     * Returns true if x, y or z are less than other vector.
     *
     * @param vector
     * @return
     */
    final public boolean anyLessThan(Vector3 vector) {
        return AnyLessThan(this, vector);
    }

    /**
     * Provides distance to another vector.
     *
     * @param other
     * @return
     */
    final public Float distanceTo(Vector3 other) {
        return Distance(this, other);
    }

    /**
     * Adds another vector.
     *
     * @param vector
     * @return
     */
    final public Vector3 add(Vector3 vector) {
        return Add(this, vector);
    }

    /**
     * Subtracts another vector.
     *
     * @param vector
     * @return
     */
    final public Vector3 subtract(Vector3 vector) {
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
    final public float dot(Vector3 v) {
        return Dot(this, v);
    }

    /**
     * Multiplies vector by a decimal number.
     *
     * @param multiplier
     * @return
     */
    final public Vector3 multiply(float multiplier) {
        return Scale(this, multiplier);
    }

    /**
     * Divides vector by a number.
     *
     * @param divider
     * @return
     */
    final public Vector3 divide(float divider) {
        return Divide(this, divider);
    }

    /**
     * Create a selection between 2 vectors.
     */
    public static class Selection {
        public Vector3 pos1;
        public Vector3 pos2;

        /**
         * Initialize with 2 vectors.
         *
         * @param pos1
         * @param pos2
         */
        public Selection(Vector3 pos1, Vector3 pos2) {
            if (pos1 == null || pos2 == null)
                this.pos1 = this.pos2 = Vector3.zero;
            else {
                this.pos1 = Vector3.Min(pos1, pos2);
                this.pos2 = Vector3.Max(pos1, pos2);
            }
        }

        /**
         * Initialize with the largest possible selection.
         */
        public Selection() {
            this.pos1 = Vector3.min;
            this.pos2 = Vector3.max;
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
            for(int i = 0; i < values.length ; i++)
                if(values[i] < pos1.x && values[i] > pos2.x)
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
            for(int i = 0; i < values.length ; i++)
                if(values[i] < pos1.x && values[i] > pos2.x)
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
            for(int i = 0; i < values.length ; i++)
                if(values[i] < pos1.y && values[i] > pos2.y)
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
            for(int i = 0; i < values.length ; i++)
                if(values[i] < pos1.y && values[i] > pos2.y)
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
            for(int i = 0; i < values.length ; i++)
                if(values[i] < pos1.z && values[i] > pos2.z)
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
            for(int i = 0; i < values.length ; i++)
                if(values[i] < pos1.z && values[i] > pos2.z)
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
        public boolean inRangeXYZ(float x, float y, float z) {
            return x >= pos1.x && y >= pos1.y && z >= pos1.z && x <= pos2.x && y <= pos2.y && z <= pos2.z;
        }

        /**
         * Verifies vector is within selection.
         *
         * @param vector
         * @return
         */
        public boolean inVectorRange(Vector3 vector) {
            return vector.x >= pos1.x && vector.y >= pos1.y && vector.z >= pos1.z && vector.x <= pos2.x && vector.y <= pos2.y && vector.z <= pos2.z;
        }

        /**
         * Keep selection within range of min to max.
         * @param min
         * @param max
         */
        public void clamp(Vector3 min, Vector3 max){
            pos1 = Vector3.ClampAll(pos1, min, max);
            pos2 = Vector3.ClampAll(pos2, min, max);
        }

    }
}
