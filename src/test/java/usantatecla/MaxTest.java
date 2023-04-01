package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaxTest {

    protected Max max;
    protected Point point;

    @BeforeEach
    void before() {
        this.point = new Point(4.4);
        this.max = this.createMax();
    }

    protected Max createMax() {
        return new Max(this.point.getEqual());
    }

    @Test
    void givenMaxWhenIsWithinWithLessValueThenTrue() {
        assertTrue(this.max.isWithin(this.point.getLess()));
    }

    @Test
    void givenMaxWhenIsWithinWithEqualsValue() {
        assertFalse(this.max.isWithin(this.point.getEqual()));
    }

    @Test
    void givenMaxWhenIsWithinWithGreaterValueThenFalse() {
        assertFalse(this.max.isWithin(this.point.getGreater()));
    }

}
