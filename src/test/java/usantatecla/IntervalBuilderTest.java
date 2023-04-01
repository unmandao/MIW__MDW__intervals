package usantatecla;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalBuilderTest {

    private double min;
    private double max;

    @BeforeEach
    public void before() {
        this.min = -2.2;
        this.max = 4.4;
    }

    @Test
    void givenIntervalBuilderWhenOpenOpen() {
        Interval interval = new IntervalBuilder().open(this.min).open(this.max).build();
        assertEquals(interval, new Interval(new Min(this.min), new Max(this.max)));
    }

    @Test
    void givenIntervalBuilderWhenOpenClosed() {
        Interval interval = new IntervalBuilder().open(this.min).closed(this.max).build();
        assertEquals(interval, new Interval(new Min(this.min), new ClosedMax(this.max)));
    }

    @Test
    void givenIntervalBuilderWhenClosedOpen() {
        Interval interval = new IntervalBuilder().closed(this.min).open(this.max).build();
        assertEquals(interval, new Interval(new ClosedMin(this.min), new Max(this.max)));
    }

    @Test
    void givenIntervalBuilderWhenClosedClosed() {
        Interval interval = new IntervalBuilder().closed(this.min).closed(this.max).build();
        assertEquals(interval, new Interval(new ClosedMin(this.min), new ClosedMax(this.max)));
    }
}
