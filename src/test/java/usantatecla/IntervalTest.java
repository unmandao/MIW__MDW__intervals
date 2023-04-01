package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import static usantatecla.Point.*;

class IntervalTest {

    @Test
    void givenIntervalOpenOpenWhenIncludeWithIncludedValueThenTrue() {
        assertTrue(new Interval(true, -1.7, new Max(VALUE)).include(getLess(VALUE)));
        assertFalse(new Interval(true, -1.7, new Max(VALUE)).include(getEqual(VALUE)));
        assertFalse(new Interval(true, -1.7, new Max(VALUE)).include(getGreater(VALUE)));
        assertTrue(new Interval(true, -1.7, new ClosedMax(VALUE)).include(getLess(VALUE)));
        assertTrue(new Interval(true, -1.7, new ClosedMax(VALUE)).include(getEqual(VALUE)));
        assertFalse(new Interval(true, -1.7, new ClosedMax(VALUE)).include(getGreater(VALUE)));
    }

}
