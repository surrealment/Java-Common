package com.surrealment;

public class seVectorSelection {

    private enum VectorType {
        Undefined,
        Vector2,
        Vector3,
        Vector4
    }

    private float min_x;
    private float min_y;
    private float min_z;
    private float min_w;

    private float max_x;
    private float max_y;
    private float max_z;
    private float max_w;

    private VectorType vectorType = VectorType.Undefined;

    /**
     * Initialize with 2 vectors.
     *
     * @param min
     * @param max
     */
    public seVectorSelection(seVector3 min, seVector3 max) {
        // Null check a vector.
        if (min == null)
            min = seVector3.min;

        // Null check b vector.
        if (max == null)
            max = seVector3.max;

        // Get smallest xyz to make a vector.
        seVector3 a = seVector3.Min(min, max);

        // Get largest xyz to make b vector.
        seVector3 b = seVector3.Max(min, max);

        // Set min values.
        min_x = a.x;
        min_y = a.y;
        min_z = a.z;

        // Set max values;
        max_x = b.x;
        max_y = b.y;
        max_z = b.z;

        // Set vector type.
        vectorType = VectorType.Vector3;
    }

    /**
     * Initialize with 2 vectors.
     *
     * @param min
     * @param max
     */
    public seVectorSelection(seVector2 min, seVector2 max) {
        // Null check a vector.
        if (min == null)
            min = seVector2.min;

        // Null check b vector.
        if (max == null)
            max = seVector2.max;

        // Get smallest xy to make a vector.
        seVector2 a = seVector2.Min(min, max);

        // Get largest xy to make b vector.
        seVector2 b = seVector2.Max(min, max);

        // Set min values.
        min_x = a.x;
        min_y = a.y;

        // Set max values;
        max_x = b.x;
        max_y = b.y;

        // Set vector type.
        vectorType = VectorType.Vector2;
    }

    /**
     * Verifies value is within x selection.
     *
     * @param value
     * @return
     */
    public final boolean inRangeX(float value) {
        return value >= this.min_x && value <= this.max_x;
    }

    /**
     * Verifies value is within x selection.
     *
     * @param value
     * @return
     */
    public final boolean inRangeX(int value) {
        return value >= this.min_x && value <= this.max_x;
    }

    /**
     * Verifies all values are within x selection.
     *
     * @param values
     * @return
     */
    public final boolean inRangeAllX(float... values) {
        for (int i = 0; i < values.length; i++)
            if (values[i] < this.min_x && values[i] > this.max_x)
                return false;
        return true;
    }

    /**
     * Verifies all values are within x selection.
     *
     * @param values
     * @return
     */
    public final boolean inRangeAllX(int... values) {
        for (int i = 0; i < values.length; i++)
            if (values[i] < this.min_x && values[i] > this.max_x)
                return false;
        return true;
    }

    /**
     * Verifies value is within y selection.
     *
     * @param value
     * @return
     */
    public final boolean inRangeY(float value) {
        return value >= this.min_y && value <= this.max_y;
    }

    /**
     * Verifies value is within y selection.
     *
     * @param value
     * @return
     */
    public final boolean inRangeY(int value) {
        return value >= this.min_y && value <= this.max_y;
    }

    /**
     * Verifies all values are within y selection.
     *
     * @param values
     * @return
     */
    public final boolean inRangeAllY(float... values) {
        for (int i = 0; i < values.length; i++)
            if (values[i] < this.min_y && values[i] > this.max_y)
                return false;
        return true;
    }

    /**
     * Verifies all values are within y selection.
     *
     * @param values
     * @return
     */
    public final boolean inRangeAllY(int... values) {
        for (int i = 0; i < values.length; i++)
            if (values[i] < this.min_y && values[i] > this.max_y)
                return false;
        return true;
    }

    /**
     * Verifies value is within z selection.
     *
     * @param value
     * @return
     */
    public final boolean inRangeZ(float value) {
        return value >= this.min_z && value <= this.max_z;
    }

    /**
     * Verifies value is within z selection.
     *
     * @param value
     * @return
     */
    public final boolean inRangeZ(int value) {
        return value >= this.min_z && value <= this.max_z;
    }

    /**
     * Verifies all values are within z selection.
     *
     * @param values
     * @return
     */
    public final boolean inRangeAllZ(float... values) {
        for (int i = 0; i < values.length; i++)
            if (values[i] < this.min_z && values[i] > this.max_z)
                return false;
        return true;
    }

    /**
     * Verifies all values are within z selection.
     *
     * @param values
     * @return
     */
    public final boolean inRangeAllZ(int... values) {
        for (int i = 0; i < values.length; i++)
            if (values[i] < this.min_z && values[i] > this.max_z)
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
    public final boolean inRange(float x, float y, float z) {
        return x >= this.min_x && y >= this.min_y && z >= this.min_z && x <= this.max_x && y <= this.max_y && z <= this.max_z;
    }

    /**
     * Verifies vector ints are within selection.
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public final boolean inRange(int x, int y, int z) {
        return x >= this.min_x && y >= this.min_y && z >= this.min_z && x <= this.max_x && y <= this.max_y && z <= this.max_z;
    }

    /**
     * Verifies vector is within selection.
     *
     * @param vector
     * @return
     */
    public final boolean inRange(seVector3 vector) {
        return vector.x >= this.min_x && vector.y >= this.min_y && vector.z >= this.min_z && vector.x <= this.max_x && vector.y <= this.max_y && vector.z <= this.max_z;
    }

    /**
     * Verifies vectors are within selection.
     *
     * @param vectors
     * @return
     */
    public final boolean inRangeAll(seVector3... vectors) {
        for (int i = 0; i < vectors.length; i++) {
            seVector3 vector = vectors[i];
            if (vector.x < this.min_x && vector.y < this.min_y && vector.z < this.min_z && vector.x > this.max_x && vector.y > this.max_y && vector.z > this.max_z)
                return false;
        }
        return true;
    }

    /**
     * Keep within two vectors without changing scope if already within selection.
     *
     * @param min
     * @param max
     */
    public final void clamp(seVector3 min, seVector3 max) {
        // Make sure all of min is less than max.
        if (min.anyGreaterThan(max)) {
            seVector3 temp = seVector3.Min(min, max);
            max = seVector3.Max(min, max);
            min = temp;
        }

        // Update min values if lower than min vector.
        min_x = seMath.Max(min_x, min.x);
        min_y = seMath.Max(min_y, min.y);
        min_z = seMath.Max(min_z, min.z);

        // Update max values if lower than max vector.
        max_x = seMath.Min(max_x, max.x);
        max_y = seMath.Min(max_y, max.y);
        max_z = seMath.Min(max_z, max.z);
    }

    /**
     * Decreases selection minimum and maximum points.
     *
     * @param amt
     */
    public final void shrink(float amt) {
        amt = Math.abs(amt / 2f);
        min_x += amt;
        min_y += amt;
        min_z += amt;

        max_x -= amt;
        max_y -= amt;
        max_z -= amt;

        if (min_x > max_x)
            min_x = max_x = (min_x + max_x) / 2f;
        if (min_y > max_y)
            min_y = max_y = (min_y + max_y) / 2f;
        if (min_z > max_z)
            min_z = max_z = (min_z + max_z) / 2f;
        if (min_w > max_w)
            min_w = max_w = (min_w + max_w) / 2f;
    }

    /**
     * Increases selection minimum and maximum points.
     *
     * @param amt
     */
    public final void grow(float amt) {
        amt = Math.abs(amt / 2f);
        min_x -= amt;
        min_y -= amt;
        min_z -= amt;

        max_x += amt;
        max_y += amt;
        max_z += amt;
    }

}
