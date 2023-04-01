package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import static usantatecla.NumberLine.*;

class IntervalTest {

    @Test
    void givenIntervalOpenOpenWhenIncludeWithIncludedValueThenTrue() {
        assertTrue(new Interval(true, -1.7, new Max(VALUE)).include(less(VALUE)));
        assertFalse(new Interval(true, -1.7, new Max(VALUE)).include(equal(VALUE)));
        assertFalse(new Interval(true, -1.7, new Max(VALUE)).include(greater(VALUE)));
        assertTrue(new Interval(true, -1.7, new ClosedMax(VALUE)).include(less(VALUE)));
        assertTrue(new Interval(true, -1.7, new ClosedMax(VALUE)).include(equal(VALUE)));
        assertFalse(new Interval(true, -1.7, new ClosedMax(VALUE)).include(greater(VALUE)));
    }

}
