package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IntervalTest {

    @Test
    void givenIntervalOpenOpenWhenIncludeWithIncludedValueThenTrue() {
        Point right = new Point(4.4);
        assertTrue(new Interval(true, -1.7, new Max(right.getEqual())).include(right.getLess()));
        assertFalse(new Interval(true, -1.7, new Max(right.getEqual())).include(right.getEqual()));
        assertFalse(new Interval(true, -1.7, new Max(right.getEqual())).include(right.getGreater()));
        assertTrue(new Interval(true, -1.7, new ClosedMax(right.getEqual())).include(right.getLess()));
        assertTrue(new Interval(true, -1.7, new ClosedMax(right.getEqual())).include(right.getEqual()));
        assertFalse(new Interval(true, -1.7, new ClosedMax(right.getEqual())).include(right.getGreater()));
    }

}
