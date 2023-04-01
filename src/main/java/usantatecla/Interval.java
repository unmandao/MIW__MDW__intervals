package usantatecla;

import java.util.Objects;

public class Interval {

    private Min min;
    private Max max;

    public Interval(Min min, Max max) {
        assert min.value <= max.value;
        this.min = min;
        this.max = max;
    }

    public boolean include(double value) {
        return this.min.isWithin(value) && this.max.isWithin(value);
    }

    public boolean hasIntersection(Interval interval2) {
        return this.max.isWithin(interval2.min.value)
                && interval2.min.isWithin(this.max.value)
                && this.min.isWithin(interval2.max.value)
                && interval2.max.isWithin(this.min.value);
    }

    @Override
    public String toString() {
        return this.min.toString() + ", " + max.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return Objects.equals(min, interval.min) && Objects.equals(max, interval.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }
}
