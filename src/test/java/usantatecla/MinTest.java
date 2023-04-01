package usantatecla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MinTest {

    protected Min min;
    protected Point point;

    @BeforeEach
    void before() {
        this.point = new Point(4.4);
        this.min = this.createMin();
    }

    protected Min createMin() {
        return new Min(this.point.getEqual());
    }

    @Test
    void givenMinWhenIsWithinWithLessValueThenFalse() {
        assertFalse(this.min.isWithin(this.point.getLess()));
    }

    @Test
    void givenMinWhenIsWithinWithEqualsValue() {
        assertFalse(this.min.isWithin(this.point.getEqual()));
    }

    @Test
    void givenMinWhenIsWithinWithGreaterValueThenTrue() {
        assertTrue(this.min.isWithin(this.point.getGreater()));
    }

}

