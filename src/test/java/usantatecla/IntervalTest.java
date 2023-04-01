package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IntervalTest {

    @Test
    void givenIntervalOpenOpenWhenIncludeWithIncludedValueThenTrue() {
        assertTrue(new Interval(true, -1.7, new Max(5555.0)).include(0.0));
    }

    @Test
    void givenIntervalOpenOpenWhenIncludeWithNotIncludedValueThenFalse() {
        assertFalse(new Interval(true, -1.7, new Max(5555.0)).include(9000.0));
    }

    @Test
    void givenIntervalOpenOpenWhenIncludeWithLimitValueThenFalse() {
        assertFalse(new Interval(true, -1.7, new Max(5555.0)).include(5555.0));
    }

    @Test
    void givenIntervalOpenCloseWhenIncludeWithIncludedValueThenTrue() {
        assertTrue(new Interval(true, -1.7, new ClosedMax(5555.0)).include(0.0));
    }

    @Test
    void givenIntervalOpenCloseWhenIncludeWithNotIncludedValueThenFalse() {
        assertFalse(new Interval(true, -1.7, new ClosedMax(5555.0)).include(9000.0));
    }

    @Test
    void givenIntervalOpenCloseWhenIncludeWithLimitValueThenTrue() {
        assertTrue(new Interval(true, -1.7, new ClosedMax(5555.0)).include(5555.0));
    }

}
