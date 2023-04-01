package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntervalTest {

    private Point left;
    private Point right;
    private IntervalBuilder intervalBuilder;

    @BeforeEach
    public void before() {
        this.left = new Point(-2.2);
        this.right = new Point(4.4);
        this.intervalBuilder = new IntervalBuilder();
    }
    @Test
    void givenIntervalOpenOpenTest() {
        Interval interval = this.intervalBuilder.open(left.getEqual()).open(right.getEqual()).build();

        assertFalse(interval.include(left.getLess()));
        assertFalse(interval.include(left.getEqual()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertFalse(interval.include(right.getEqual()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    void givenIntervalClosedOpenTest() {
        Interval interval = this.intervalBuilder.closed(left.getEqual()).open(right.getEqual()).build();

        assertFalse(interval.include(left.getLess()));
        assertTrue(interval.include(left.getEqual()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertFalse(interval.include(right.getEqual()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    void givenIntervalOpenClosedTest() {
        Interval interval = this.intervalBuilder.open(left.getEqual()).closed(right.getEqual()).build();
        
        assertFalse(interval.include(left.getLess()));
        assertFalse(interval.include(left.getEqual()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertTrue(interval.include(right.getEqual()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    void givenIntervalClosedClosedTest() {
        Interval interval = this.intervalBuilder.closed(left.getEqual()).closed(right.getEqual()).build();
        
        assertFalse(interval.include(left.getLess()));
        assertTrue(interval.include(left.getEqual()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertTrue(interval.include(right.getEqual()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    void givenIntervalOpenOpenTestHasIntersectionWithOpenOpenThenTrue() {
        Interval interval = this.intervalBuilder.open(left.getEqual()).open(right.getEqual()).build();
        Interval interval2 = new IntervalBuilder().open(left.getGreater()).open(right.getLess()).build();

        assertTrue(interval.hasIntersection(interval2));
    }

    @Test
    void givenIntervalOpenOpenTestHasIntersectionWithOpenOpenThenFalse() {
        Interval interval = this.intervalBuilder.open(left.getEqual()).open(right.getEqual()).build();
        Interval interval2 = new IntervalBuilder().open(right.getEqual()).open(right.getGreater()).build();

        assertFalse(interval.hasIntersection(interval2));
    }

    @Test
    void givenIntervalOpenClosedTestHasIntersectionWithOpenOpenThenFalse() {
        Interval interval = this.intervalBuilder.open(left.getEqual()).closed(right.getEqual()).build();
        Interval interval2 = new IntervalBuilder().open(right.getEqual()).open(right.getGreater()).build();

        assertFalse(interval.hasIntersection(interval2));
    }

    @Test
    void givenIntervalOpenClosedTestHasIntersectionWithClosedOpenThenTrue() {
        Interval interval = this.intervalBuilder.open(left.getEqual()).closed(right.getEqual()).build();
        Interval interval2 = new IntervalBuilder().closed(right.getEqual()).open(right.getGreater()).build();

        assertTrue(interval.hasIntersection(interval2));
    }

    @Test
    void givenIntervalOpenOpenTestHasIntersectionWithOpenClosedLeftSideThenFalse() {
        Interval interval = this.intervalBuilder.open(left.getEqual()).open(right.getEqual()).build();
        Interval interval2 = new IntervalBuilder().open(left.getLess()).closed(left.getEqual()).build();

        assertFalse(interval.hasIntersection(interval2));
    }

    @Test
    void givenIntervalClosedOpenTestHasIntersectionWithOpenClosedLeftSideThenTrue() {
        Interval interval = this.intervalBuilder.closed(left.getEqual()).open(right.getEqual()).build();
        Interval interval2 = new IntervalBuilder().open(left.getLess()).closed(left.getEqual()).build();

        assertTrue(interval.hasIntersection(interval2));
    }

    @Test
    void givenIntervalOpenOpenTestHasIntersectionWithOpenOpenLeftSideThenTrue() {
        Interval interval = this.intervalBuilder.open(left.getEqual()).open(right.getEqual()).build();
        Interval interval2 = new IntervalBuilder().open(left.getLess()).open(left.getGreater()).build();

        assertTrue(interval.hasIntersection(interval2));
    }
}
