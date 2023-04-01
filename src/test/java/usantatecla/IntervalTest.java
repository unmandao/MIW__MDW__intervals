package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IntervalTest {

    @Test
    void givenIntervalWhenIncludeWithIncludedValueThenTrue() {
        assertTrue(new Interval(true, -1.7, new Max(5555.0)).include(0.0));
    }

    @Test
    void givenIntervalWhenIncludeWithNotIncludedValueThenFalse() {
        assertFalse(new Interval(true, -1.7, new Max(5555.0)).include(9000.0));
    }

    @Test
    void givenIntervalWhenIncludeWithLimitValueThenFalse() {
        assertFalse(new Interval(true, -1.7, new Max(5555.0)).include(5555.0));
    }
}
