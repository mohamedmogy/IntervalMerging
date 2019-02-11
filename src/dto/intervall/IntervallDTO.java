package dto.intervall;

import java.util.Objects;

public class IntervallDTO {
    private  int min;
    private  int max;

    /**
     * Empty constructor
     */
    public IntervallDTO() {
    }

    /**
     * Initializes a closed interval [min, max].
     *
     * @param  min the smaller endpoint
     * @param  max the larger endpoint
     * @throws IllegalArgumentException if the min endpoint is greater than the max endpoint
     * @throws IllegalArgumentException if either {@code min} or {@code max}
     *         is {@code Double.NaN}, {@code Double.POSITIVE_INFINITY} or
     *         {@code Double.NEGATIVE_INFINITY}

     */



    public IntervallDTO(int min, int max) {
        if (Double.isInfinite(min) || Double.isInfinite(max))
            throw new IllegalArgumentException("Endpoints must be finite");
        if (Double.isNaN(min) || Double.isNaN(max))
            throw new IllegalArgumentException("Endpoints cannot be NaN");

        if (min <= max) {
            this.min = min;
            this.max = max;
        }
        else throw new IllegalArgumentException("Illegal interval");
    }

    /**
     *
     * Set the parameter min to the given value
     *
     * @param min the new given min value
     *
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     *
     * Set the parameter max to the given value
     *
     * @param max the new given max value
     *
     */
    public void setMax(int max) {
        this.max = max;
    }
    /**
     * Returns the min endpoint of this interval.
     *
     * @return the min endpoint of this interval
     */

    public int getMin() {
        return min;
    }
    /**
     * Returns the max endpoint of this interval.
     *
     * @return the max endpoint of this interval
     */
    public int getMax() {
        return max;
    }


    /**
     * Returns true if this interval intersects the specified interval.
     *
     * @param  that the other interval
     * @return {@code true} if this interval intersects the argument interval;
     *         {@code false} otherwise
     */
    public boolean intersects(IntervallDTO that) {
        if (this.max < that.min) return false;
        if (that.max < this.min) return false;
        return true;
    }


    /**
     * Returns true if this interval contains the specified value.
     *
     * @param x the value
     * @return {@code true} if this interval contains the value {@code x};
     *         {@code false} otherwise
     */
    public boolean contains(double x) {
        return (min <= x) && (x <= max);
    }

    /**
     * Returns the length of this interval.
     *
     * @return the length of this interval (max - min)
     */
    public double length() {
        return max - min;
    }
    /**
     * Compares this transaction to the specified object.
     *
     * @param  o the other interval
     * @return {@code true} if this interval equals the other interval;
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntervallDTO that = (IntervallDTO) o;
        return Double.compare(that.min, min) == 0 &&
                Double.compare(that.max, max) == 0;
    }


    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }


    @Override
    public String toString() {
        return "IntervallDTO{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }

}
