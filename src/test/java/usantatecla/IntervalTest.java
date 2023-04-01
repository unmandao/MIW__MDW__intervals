package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IntervalTest {

    @Test
    void givenIntervalOpenOpenWhenIncludeWithIncludedValueThenTrue() {
        Point right = new Point(4.4);
        Point left = new Point(-1.7);
        assertTrue(new Interval(new Min(left.getEqual()), new Max(right.getEqual())).include(right.getLess()));
        assertFalse(new Interval(new Min(left.getEqual()), new Max(right.getEqual())).include(right.getEqual()));
        assertFalse(new Interval(new Min(left.getEqual()), new Max(right.getEqual())).include(right.getGreater()));
        assertTrue(new Interval(new Min(left.getEqual()), new ClosedMax(right.getEqual())).include(right.getLess()));
        assertTrue(new Interval(new Min(left.getEqual()), new ClosedMax(right.getEqual())).include(right.getEqual()));
        assertFalse(new Interval(new Min(left.getEqual()), new ClosedMax(right.getEqual())).include(right.getGreater()));
    }

}
