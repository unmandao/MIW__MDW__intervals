package usantatecla;

import java.util.Objects;

public class Max {

    protected double value;

    public Max(double value) {
        this.value = value;
    }

    public boolean isWithin(double value) {
        return this.value > value;
    }

    @Override
    public String toString() {
        return this.value + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Max max = (Max) o;
        return Double.compare(max.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
