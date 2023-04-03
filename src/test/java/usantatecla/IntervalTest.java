package usantatecla;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IntervalTest {

    private static final Point left = new Point(-2.2);
    private static final Point right = new Point(4.4);

    @Test
    void givenIntervalOpenOpenTest() {
        Interval interval = new IntervalBuilder().open(left.getEqual()).open(right.getEqual()).build();

        assertFalse(interval.include(left.getLess()));
        assertFalse(interval.include(left.getEqual()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertFalse(interval.include(right.getEqual()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    void givenIntervalClosedOpenTest() {
        Interval interval = new IntervalBuilder().closed(left.getEqual()).open(right.getEqual()).build();

        assertFalse(interval.include(left.getLess()));
        assertTrue(interval.include(left.getEqual()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertFalse(interval.include(right.getEqual()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    void givenIntervalOpenClosedTest() {
        Interval interval = new IntervalBuilder().open(left.getEqual()).closed(right.getEqual()).build();
        
        assertFalse(interval.include(left.getLess()));
        assertFalse(interval.include(left.getEqual()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertTrue(interval.include(right.getEqual()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    void givenIntervalClosedClosedTest() {
        Interval interval = new IntervalBuilder().closed(left.getEqual()).closed(right.getEqual()).build();
        
        assertFalse(interval.include(left.getLess()));
        assertTrue(interval.include(left.getEqual()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertTrue(interval.include(right.getEqual()));
        assertFalse(interval.include(right.getGreater()));
    }

    @ParameterizedTest
    @MethodSource("provideIntervalsForOpenOpen")
    void givenIntervalOpenOpenTestHasIntersection(Interval interval2, boolean expected) {
        Interval interval = new IntervalBuilder().open(left.getEqual()).open(right.getEqual()).build();

        assertEquals(expected, interval.hasIntersection(interval2));
    }

    private static Stream<Arguments> provideIntervalsForOpenOpen() {
        return Stream.concat(
                Stream.of(
                        Arguments.of(new IntervalBuilder().open(right.getEqual()).open(right.getGreater()).build(), false),
                        Arguments.of(new IntervalBuilder().open(left.getLess()).open(left.getEqual()).build(), false),

                        Arguments.of(new IntervalBuilder().closed(right.getEqual()).open(right.getGreater()).build(), false),
                        Arguments.of(new IntervalBuilder().closed(left.getLess()).open(left.getEqual()).build(), false),

                        Arguments.of(new IntervalBuilder().open(right.getEqual()).closed(right.getGreater()).build(), false),
                        Arguments.of(new IntervalBuilder().open(left.getLess()).closed(left.getEqual()).build(), false),

                        Arguments.of(new IntervalBuilder().closed(right.getEqual()).closed(right.getGreater()).build(), false),
                        Arguments.of(new IntervalBuilder().closed(left.getLess()).closed(left.getEqual()).build(), false)
                ),
                provideCommonIntervals());
    }

    @ParameterizedTest
    @MethodSource("provideIntervalsForClosedOpen")
    void givenIntervalClosedOpenTestHasIntersection(Interval interval2, boolean expected) {
        Interval interval = new IntervalBuilder().closed(left.getEqual()).open(right.getEqual()).build();

        assertEquals(expected, interval.hasIntersection(interval2));
    }

    private static Stream<Arguments> provideIntervalsForClosedOpen() {
        return Stream.concat(
                Stream.of(
                        Arguments.of(new IntervalBuilder().open(right.getEqual()).open(right.getGreater()).build(), false),
                        Arguments.of(new IntervalBuilder().open(left.getLess()).open(left.getEqual()).build(), false),

                        Arguments.of(new IntervalBuilder().closed(right.getEqual()).open(right.getGreater()).build(), false),
                        Arguments.of(new IntervalBuilder().closed(left.getLess()).open(left.getEqual()).build(), false),

                        Arguments.of(new IntervalBuilder().open(right.getEqual()).closed(right.getGreater()).build(), false),
                        Arguments.of(new IntervalBuilder().open(left.getLess()).closed(left.getEqual()).build(), true),

                        Arguments.of(new IntervalBuilder().closed(right.getEqual()).closed(right.getGreater()).build(), false),
                        Arguments.of(new IntervalBuilder().closed(left.getLess()).closed(left.getEqual()).build(), true)
                ),
                provideCommonIntervals());
    }

    @ParameterizedTest
    @MethodSource("provideIntervalsForOpenClosed")
    void givenIntervalOpenClosedTestHasIntersection(Interval interval2, boolean expected) {
        Interval interval = new IntervalBuilder().open(left.getEqual()).closed(right.getEqual()).build();

        assertEquals(expected, interval.hasIntersection(interval2));
    }

    private static Stream<Arguments> provideIntervalsForOpenClosed() {
        return Stream.concat(
                Stream.of(
                        Arguments.of(new IntervalBuilder().open(right.getEqual()).open(right.getGreater()).build(), false),
                        Arguments.of(new IntervalBuilder().open(left.getLess()).open(left.getEqual()).build(), false),

                        Arguments.of(new IntervalBuilder().closed(right.getEqual()).open(right.getGreater()).build(), true),
                        Arguments.of(new IntervalBuilder().closed(left.getLess()).open(left.getEqual()).build(), false),

                        Arguments.of(new IntervalBuilder().open(right.getEqual()).closed(right.getGreater()).build(), false),
                        Arguments.of(new IntervalBuilder().open(left.getLess()).closed(left.getEqual()).build(), false),

                        Arguments.of(new IntervalBuilder().closed(right.getEqual()).closed(right.getGreater()).build(), true),
                        Arguments.of(new IntervalBuilder().closed(left.getLess()).closed(left.getEqual()).build(), false)
                ),
                provideCommonIntervals());
    }

    @ParameterizedTest
    @MethodSource("provideIntervalsForClosedClosed")
    void givenIntervalClosedClosedTestHasIntersection(Interval interval2, boolean expected) {
        Interval interval = new IntervalBuilder().closed(left.getEqual()).closed(right.getEqual()).build();

        assertEquals(expected, interval.hasIntersection(interval2));
    }

    private static Stream<Arguments> provideIntervalsForClosedClosed() {
        return Stream.concat(
                Stream.of(
                        Arguments.of(new IntervalBuilder().open(right.getEqual()).open(right.getGreater()).build(), false),
                        Arguments.of(new IntervalBuilder().open(left.getLess()).open(left.getEqual()).build(), false),

                        Arguments.of(new IntervalBuilder().closed(right.getEqual()).open(right.getGreater()).build(), true),
                        Arguments.of(new IntervalBuilder().closed(left.getLess()).open(left.getEqual()).build(), false),

                        Arguments.of(new IntervalBuilder().open(right.getEqual()).closed(right.getGreater()).build(), false),
                        Arguments.of(new IntervalBuilder().open(left.getLess()).closed(left.getEqual()).build(), true),

                        Arguments.of(new IntervalBuilder().closed(right.getEqual()).closed(right.getGreater()).build(), true),
                        Arguments.of(new IntervalBuilder().closed(left.getLess()).closed(left.getEqual()).build(), true)
                ),
                provideCommonIntervals());
    }

    private static Stream<Arguments> provideCommonIntervals() {
        return Stream.of(
                Arguments.of(new IntervalBuilder().open(right.getGreater()).open(right.getGreater() + Point.DEVIATION).build(), false),
                Arguments.of(new IntervalBuilder().open(right.getLess()).open(right.getGreater()).build(), true),
                Arguments.of(new IntervalBuilder().open(left.getGreater()).open(right.getLess()).build(), true),
                Arguments.of(new IntervalBuilder().open(left.getLess()).open(left.getGreater()).build(), true),
                Arguments.of(new IntervalBuilder().open(left.getLess() - Point.DEVIATION).open(left.getLess()).build(), false),
                Arguments.of(new IntervalBuilder().open(left.getLess()).open(right.getGreater()).build(), true),
                Arguments.of(new IntervalBuilder().open(left.getGreater()).open(right.getEqual()).build(), true),
                Arguments.of(new IntervalBuilder().open(left.getLess()).open(right.getEqual()).build(), true),
                Arguments.of(new IntervalBuilder().open(left.getEqual()).open(right.getLess()).build(), true),
                Arguments.of(new IntervalBuilder().open(left.getEqual()).open(right.getGreater()).build(), true),
                Arguments.of(new IntervalBuilder().open(left.getEqual()).open(right.getEqual()).build(), true),

                Arguments.of(new IntervalBuilder().closed(right.getGreater()).open(right.getGreater() + Point.DEVIATION).build(), false),
                Arguments.of(new IntervalBuilder().closed(right.getLess()).open(right.getGreater()).build(), true),
                Arguments.of(new IntervalBuilder().closed(left.getGreater()).open(right.getLess()).build(), true),
                Arguments.of(new IntervalBuilder().closed(left.getLess()).open(left.getGreater()).build(), true),
                Arguments.of(new IntervalBuilder().closed(left.getLess() - Point.DEVIATION).open(left.getLess()).build(), false),
                Arguments.of(new IntervalBuilder().closed(left.getLess()).open(right.getGreater()).build(), true),
                Arguments.of(new IntervalBuilder().closed(left.getGreater()).open(right.getEqual()).build(), true),
                Arguments.of(new IntervalBuilder().closed(left.getLess()).open(right.getEqual()).build(), true),
                Arguments.of(new IntervalBuilder().closed(left.getEqual()).open(right.getLess()).build(), true),
                Arguments.of(new IntervalBuilder().closed(left.getEqual()).open(right.getGreater()).build(), true),
                Arguments.of(new IntervalBuilder().closed(left.getEqual()).open(right.getEqual()).build(), true),

                Arguments.of(new IntervalBuilder().open(right.getGreater()).closed(right.getGreater() + Point.DEVIATION).build(), false),
                Arguments.of(new IntervalBuilder().open(right.getLess()).closed(right.getGreater()).build(), true),
                Arguments.of(new IntervalBuilder().open(left.getGreater()).closed(right.getLess()).build(), true),
                Arguments.of(new IntervalBuilder().open(left.getLess()).closed(left.getGreater()).build(), true),
                Arguments.of(new IntervalBuilder().open(left.getLess() - Point.DEVIATION).closed(left.getLess()).build(), false),
                Arguments.of(new IntervalBuilder().open(left.getLess()).closed(right.getGreater()).build(), true),
                Arguments.of(new IntervalBuilder().open(left.getGreater()).closed(right.getEqual()).build(), true),
                Arguments.of(new IntervalBuilder().open(left.getLess()).closed(right.getEqual()).build(), true),
                Arguments.of(new IntervalBuilder().open(left.getEqual()).closed(right.getLess()).build(), true),
                Arguments.of(new IntervalBuilder().open(left.getEqual()).closed(right.getGreater()).build(), true),
                Arguments.of(new IntervalBuilder().open(left.getEqual()).closed(right.getEqual()).build(), true),

                Arguments.of(new IntervalBuilder().closed(right.getGreater()).closed(right.getGreater() + Point.DEVIATION).build(), false),
                Arguments.of(new IntervalBuilder().closed(right.getLess()).closed(right.getGreater()).build(), true),
                Arguments.of(new IntervalBuilder().closed(left.getGreater()).closed(right.getLess()).build(), true),
                Arguments.of(new IntervalBuilder().closed(left.getLess()).closed(left.getGreater()).build(), true),
                Arguments.of(new IntervalBuilder().closed(left.getLess() - Point.DEVIATION).closed(left.getLess()).build(), false),
                Arguments.of(new IntervalBuilder().closed(left.getLess()).closed(right.getGreater()).build(), true),
                Arguments.of(new IntervalBuilder().closed(left.getGreater()).closed(right.getEqual()).build(), true),
                Arguments.of(new IntervalBuilder().closed(left.getLess()).closed(right.getEqual()).build(), true),
                Arguments.of(new IntervalBuilder().closed(left.getEqual()).closed(right.getLess()).build(), true),
                Arguments.of(new IntervalBuilder().closed(left.getEqual()).closed(right.getGreater()).build(), true),
                Arguments.of(new IntervalBuilder().closed(left.getEqual()).closed(right.getEqual()).build(), true)
        );
    }
}
