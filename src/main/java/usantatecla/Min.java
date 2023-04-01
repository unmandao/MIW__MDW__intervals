package usantatecla;

import java.util.Objects;

public class Min {

    protected double value;

    public Min(double value) {
        this.value = value;
    }

    public boolean isWithin(double value) {
        return this.value < value;
    }

    @Override
    public String toString() {
        return "(" + this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Min min = (Min) o;
        return Double.compare(min.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
