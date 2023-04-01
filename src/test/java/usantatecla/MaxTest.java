package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static usantatecla.Point.*;

class MaxTest {

    protected Max max;

    @BeforeEach
    void before() {
        this.max = new Max(VALUE);
    }

    @Test
    void givenMaxWhenIsWithinWithLessValueThenTrue() {
        assertTrue(this.max.isWithin(getLess(VALUE)));
    }

    @Test
    void givenMaxWhenIsWithinWithEqualsValue() {
        assertFalse(this.max.isWithin(getEqual(VALUE)));
    }

    @Test
    void givenMaxWhenIsWithinWithGreaterValueThenFalse() {
        assertFalse(this.max.isWithin(getGreater(VALUE)));
    }

}
