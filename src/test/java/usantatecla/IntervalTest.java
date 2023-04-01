package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IntervalTest {

    private final Point left = new Point(-2.2);
    private final Point right = new Point(4.4);

    @Test
    void givenIntervalLeftOpenTestRight() {
        assertTrue(new Interval(new Min(left.getEqual()), new Max(right.getEqual())).include(right.getLess()));
        assertFalse(new Interval(new Min(left.getEqual()), new Max(right.getEqual())).include(right.getEqual()));
        assertFalse(new Interval(new Min(left.getEqual()), new Max(right.getEqual())).include(right.getGreater()));

        assertTrue(new Interval(new Min(left.getEqual()), new ClosedMax(right.getEqual())).include(right.getLess()));
        assertTrue(new Interval(new Min(left.getEqual()), new ClosedMax(right.getEqual())).include(right.getEqual()));
        assertFalse(new Interval(new Min(left.getEqual()), new ClosedMax(right.getEqual())).include(right.getGreater()));
    }

    @Test
    void givenIntervalLeftCloseTestRight() {
        assertTrue(new Interval(new ClosedMin(left.getEqual()), new Max(right.getEqual())).include(right.getLess()));
        assertFalse(new Interval(new ClosedMin(left.getEqual()), new Max(right.getEqual())).include(right.getEqual()));
        assertFalse(new Interval(new ClosedMin(left.getEqual()), new Max(right.getEqual())).include(right.getGreater()));

        assertTrue(new Interval(new ClosedMin(left.getEqual()), new ClosedMax(right.getEqual())).include(right.getLess()));
        assertTrue(new Interval(new ClosedMin(left.getEqual()), new ClosedMax(right.getEqual())).include(right.getEqual()));
        assertFalse(new Interval(new ClosedMin(left.getEqual()), new ClosedMax(right.getEqual())).include(right.getGreater()));
    }

    @Test
    void givenIntervalLeftOpenTestLeft() {
        assertFalse(new Interval(new Min(left.getEqual()), new Max(right.getEqual())).include(left.getLess()));
        assertFalse(new Interval(new Min(left.getEqual()), new Max(right.getEqual())).include(left.getEqual()));
        assertTrue(new Interval(new Min(left.getEqual()), new Max(right.getEqual())).include(left.getGreater()));

        assertFalse(new Interval(new Min(left.getEqual()), new ClosedMax(right.getEqual())).include(left.getLess()));
        assertFalse(new Interval(new Min(left.getEqual()), new ClosedMax(right.getEqual())).include(left.getEqual()));
        assertTrue(new Interval(new Min(left.getEqual()), new ClosedMax(right.getEqual())).include(left.getGreater()));
    }

    @Test
    void givenIntervalLeftCloseTestLeft() {
        assertFalse(new Interval(new ClosedMin(left.getEqual()), new Max(right.getEqual())).include(left.getLess()));
        assertTrue(new Interval(new ClosedMin(left.getEqual()), new Max(right.getEqual())).include(left.getEqual()));
        assertTrue(new Interval(new ClosedMin(left.getEqual()), new Max(right.getEqual())).include(left.getGreater()));

        assertFalse(new Interval(new ClosedMin(left.getEqual()), new ClosedMax(right.getEqual())).include(left.getLess()));
        assertTrue(new Interval(new ClosedMin(left.getEqual()), new ClosedMax(right.getEqual())).include(left.getEqual()));
        assertTrue(new Interval(new ClosedMin(left.getEqual()), new ClosedMax(right.getEqual())).include(left.getGreater()));
    }

}
