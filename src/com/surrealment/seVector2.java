package com.surrealment;

public class seVector2 {

    /**
     * Vector2(0, -1)
     */
    final public static seVector2 down = new seVector2(0, -1);
    /**
     * Vector2(-1, 0)
     */
    final public static seVector2 left = new seVector2(-1, 0);
    /**
     * Vector2(1, 1)
     */
    final public static seVector2 one = new seVector2(1, 1);
    /**
     * Vector2(1, 0)
     */
    final public static seVector2 right = new seVector2(1, 0);
    /**
     * Vector2(0, 1)
     */
    final public static seVector2 up = new seVector2(0, 1);
    /**
     * Vector2(0, 0)
     */
    final public static seVector2 zero = new seVector2(0, 0);
    /**
     * Creates new vector using negative infinity.
     */
    final public static seVector2 negativeInfinity = new seVector2(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    /**
     * Creates new vector using positive infinity.
     */
    final public static seVector2 positiveInfinity = new seVector2(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    /**
     * Provides the smallest possible vector.
     */
    final public static seVector2 min = new seVector2(Float.MAX_VALUE * -1f - 1f, Float.MAX_VALUE * -1f - 1f);
    /**
     * Provides the largest possible vector.
     */
    final public static seVector2 max = new seVector2(Float.MAX_VALUE, Float.MAX_VALUE);
    public float x = 0.0f;
    public float y = 0.0f;

    /**
     * Initialize Vector2 with zero values.
     */
    public seVector2() {
        this(0, 0);
    }

    /**
     * Initialize Vector2 with int values.
     *
     * @param x
     * @param y
     */
    public seVector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Initialize Vector2 with float values.
     *
     * @param x
     * @param y
     */
    public seVector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Provides new random vector.
     * Note: Integer used to determine min and max values.
     */
    final public static seVector2 Random() {
        final float min = (float) Integer.MAX_VALUE * -1 - 1;
        final float max = (float) Integer.MAX_VALUE;
        return new seVector2(seRandom.Range(min, max), seRandom.Range(min, max));
    }

    /**
     * Provides new positive random vector.
     * Note: Integer used to determine min and max values.
     */
    final public static seVector2 RandomPositive() {
        final float min = 1f;
        final float max = Integer.MAX_VALUE;
        return new seVector2(seRandom.Range(min, max), seRandom.Range(min, max));
    }

    /**
     * Provides new negative random vector.
     * Note: Integer used to determine min and max values.
     */
    final public static seVector2 RandomNegative() {
        final float min = (float) Integer.MAX_VALUE * -1 - 1;
        final float max = -1f;
        return new seVector2(seRandom.Range(min, max), seRandom.Range(min, max));
    }

    /**
     * Provides new vector within random range.
     *
     * @param min
     * @param max
     * @return
     */
    final public static seVector2 RandomRange(float min, float max) {
        if (min > max) {
            float temp = min;
            min = max;
            max = temp;
        }
        return new seVector2(seRandom.Range(min, max), seRandom.Range(min, max));
    }

    /**
     * Returns true if any values in vector a is greater then vector b values.
     *
     * @param a
     * @param b
     * @return
     */
    final public static boolean AnyGreaterThan(seVector2 a, seVector2 b) {
        return a.x > b.x || a.y > b.y;
    }

    /**
     * Returns true if any values in vector a is less then vector b values.
     *
     * @param a
     * @param b
     * @return
     */
    final public static boolean AnyLessThan(seVector2 a, seVector2 b) {
        return a.x < b.x || a.y < b.y;
    }

    /**
     * Provides distance between vectors.
     *
     * @param a
     * @param b
     * @return
     */
    final public static Float Distance(seVector2 a, seVector2 b) {
        return (float) Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    /**
     * Adds two vectors.
     *
     * @param a
     * @param b
     * @return
     */
    final public static seVector2 Add(seVector2 a, seVector2 b) {
        return new seVector2(a.x + b.x, a.y + b.y);
    }

    /**
     * Subtracts two vectors.
     *
     * @param a
     * @param b
     * @return
     */
    final public static seVector2 Subtract(seVector2 a, seVector2 b) {
        return new seVector2(a.x - b.x, a.y - b.y);
    }

    /**
     * Magnitude of a vector.
     * Note: Finds square root which can be expensive.
     *
     * @param vector
     * @return
     */
    public static float Magnitude(seVector2 vector) {
        return (float) Math.sqrt((double) vector.x * (double) vector.x + (double) vector.y * (double) vector.y);
    }

    /**
     * Magnitude of a vector.
     *
     * @param vector
     * @return
     */
    public static float SqrMagnitude(seVector2 vector) {
        return (float) ((double) vector.x * (double) vector.x + (double) vector.y * (double) vector.y);
    }

    /**
     * Calculates the dot product of two vectors.
     *
     * @param a
     * @param b
     * @return
     */
    public static float Dot(seVector2 a, seVector2 b) {
        return (float) ((double) a.x * (double) b.x + (double) a.y * (double) b.y);
    }

    /**
     * Multiply a vector by a number.
     * Note: This method uses {@link #Scale(seVector2, float)}.
     *
     * @param vector
     * @param multiplier
     * @return
     */
    @Deprecated
    final public static seVector2 Multiply(seVector2 vector, float multiplier) {
        return Scale(vector, multiplier);
    }

    /**
     * Multiply a vector by a number.
     *
     * @param vector
     * @param multiplier
     * @return
     */
    final public static seVector2 Scale(seVector2 vector, float multiplier) {
        return new seVector2(vector.x * multiplier, vector.y * multiplier);
    }

    /**
     * Divide a vector by a number.
     *
     * @param vector
     * @param divider
     * @return
     */
    final public static seVector2 Divide(seVector2 vector, float divider) {
        if (divider == 0)
            return seVector2.zero;
        return new seVector2(vector.x / divider, vector.y / divider);
    }

    /**
     * Returns true if two or more vectors are equal.
     *
     * @param vectors
     * @return
     */
    final public static boolean EqualAll(seVector2... vectors) {
        if (vectors.length < 2)
            return true;
        seVector2 first = vectors[0];
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
    final public static seVector2 TryParse(String s) {
        s = seString.NullCheck(s).replace("\"", "").trim().toLowerCase();

        switch (s) {
            case "min":
                return seVector2.min;
            case "max":
                return seVector2.max;
            case "down":
                return seVector2.down;
            case "left":
                return seVector2.left;
            case "one":
                return seVector2.one;
            case "right":
                return seVector2.right;
            case "up":
                return seVector2.up;
            case "ran":
                return Random();
            case "pos":
                return RandomPositive();
            case "neg":
                return RandomNegative();
            case "":
            case "null":
            case "zero":
                return seVector2.zero;
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
            if (count == 1) {
                pass = i;
                break;
            }
        }

        // If no delimiters are found stop parse.
        if (pass == -1)
            return seVector2.zero;


        // Get rid of other possible delimiters
        for (int i = 0; i < del.length; i++) {
            if (i == pass)
                continue;
            s = s.replace(String.valueOf(del[i]), "");
        }

        String[] sa = s.split(String.valueOf(del[pass]));
        return new seVector2(seMath.TryParseFloat(sa[0]), seMath.TryParseFloat(sa[1]));
    }

    /**
     * Linearly interpolates between two vectors.
     *
     * @param a
     * @param b
     * @param t
     * @return
     */
    final public static seVector2 Lerp(seVector2 a, seVector2 b, float t) {
        t = seMath.Clamp01(t);
        return new seVector2(a.x + (b.x - a.x) * t, a.y + (b.y - a.y) * t);
    }

    /**
     * Returns a new vector with smallest values between two vectors.
     *
     * @param a
     * @param b
     * @return
     */
    public static seVector2 Min(seVector2 a, seVector2 b) {
        return new seVector2(seMath.Min(a.x, b.x), seMath.Min(a.y, b.y));
    }

    /**
     * Returns a new vector with smallest values between multiple vectors.
     * Note: This method is slower than {@link #Min(seVector2, seVector2)} if using 2 vectors.
     *
     * @param vectors
     * @return
     */
    public static seVector2 MinAll(seVector2... vectors) {
        float[] x = new float[vectors.length];
        float[] y = new float[vectors.length];
        float[] z = new float[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            x[i] = vectors[i].x;
            y[i] = vectors[i].y;
        }
        return new seVector2(seMath.Min(x), seMath.Min(y));
    }

    /**
     * Returns a new vector with largest values between two vectors.
     *
     * @param a
     * @param b
     * @return
     */
    public static seVector2 Max(seVector2 a, seVector2 b) {
        return new seVector2(seMath.Max(a.x, b.x), seMath.Max(a.y, b.y));
    }

    /**
     * Returns a new vector with greatest values between multiple vectors.
     * Note: This method is slower than {@link #Max(seVector2, seVector2)} if using 2 vectors.
     *
     * @param vectors
     * @return
     */
    public static seVector2 MaxAll(seVector2... vectors) {
        float[] x = new float[vectors.length];
        float[] y = new float[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            x[i] = vectors[i].x;
            y[i] = vectors[i].y;
        }
        return new seVector2(seMath.Max(x), seMath.Max(y));
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

        return "(" + d.format(this.x) + ", " + d.format(this.y) + ")";
        // return "(" + sString.Simplify(this.x, 2) + ", " + sString.Simplify(this.y, 2) + ", " + sString.Simplify(this.z, 2) + ")";
    }

    @Override
    final public boolean equals(Object o) {
        // Return true if itself.
        if (o == this)
            return true;

        // Make sure this is a Vector2 object.
        if (!(o instanceof seVector2))
            return false;

        // Convert to Vector2.
        seVector2 c = (seVector2) o;

        // Compare x, y and z
        return Float.compare(this.x, c.x) == 0 && Float.compare(this.y, c.y) == 0;
    }

    /**
     * Sets this vector without creating a new one.
     *
     * @param x
     * @param y
     */
    final public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns true if x, y or z are greater than other vector.
     *
     * @param vector
     * @return
     */
    final public boolean anyGreaterThan(seVector2 vector) {
        return AnyGreaterThan(this, vector);
    }

    /**
     * Returns true if x, y or z are less than other vector.
     *
     * @param vector
     * @return
     */
    final public boolean anyLessThan(seVector2 vector) {
        return AnyLessThan(this, vector);
    }

    /**
     * Provides distance to another vector.
     *
     * @param other
     * @return
     */
    final public Float distanceTo(seVector2 other) {
        return Distance(this, other);
    }

    /**
     * Adds another vector.
     *
     * @param vector
     * @return
     */
    final public seVector2 add(seVector2 vector) {
        return Add(this, vector);
    }

    /**
     * Subtracts another vector.
     *
     * @param vector
     * @return
     */
    final public seVector2 subtract(seVector2 vector) {
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
    final public float dot(seVector2 v) {
        return Dot(this, v);
    }

    /**
     * Multiplies vector by a number.
     *
     * @param multiplier
     * @return
     */
    final public seVector2 multiply(float multiplier) {
        return Scale(this, multiplier);
    }

    /**
     * Divides vector by a number.
     *
     * @param divider
     * @return
     */
    final public seVector2 divide(float divider) {
        return Divide(this, divider);
    }

}
