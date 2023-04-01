package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MaxTest {

    protected static final double VALUE = 4.4;
    private static final double DEVIATION = 0.1;

    protected Max createMax(double value) {
        return new Max(value);
    }

    @Test
    void givenMaxWhenIsWithinWithLessValueThenTrue() {
        assertTrue(createMax(VALUE).isWithin(less(VALUE)));
    }

    @Test
    void givenMaxWhenIsWithinWithEqualsValue() {
        assertFalse(createMax(VALUE).isWithin(equals(VALUE)));
    }

    @Test
    void givenMaxWhenIsWithinWithGreaterValueThenFalse() {
        assertFalse(createMax(VALUE).isWithin(greater(VALUE)));
    }

    protected double less(double value) {
        return value - MaxTest.DEVIATION;
    }

    protected double equals(double value) {
        return value;
    }

    protected double greater(double value) {
        return value + MaxTest.DEVIATION;
    }

}
