package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaxTest {

    protected Max max;

    @BeforeEach
    void before() {
        this.max = new Max(NumberLine.VALUE);
    }

    @Test
    void givenMaxWhenIsWithinWithLessValueThenTrue() {
        assertTrue(this.max.isWithin(NumberLine.less(NumberLine.VALUE)));
    }

    @Test
    void givenMaxWhenIsWithinWithEqualsValue() {
        assertFalse(this.max.isWithin(NumberLine.equals(NumberLine.VALUE)));
    }

    @Test
    void givenMaxWhenIsWithinWithGreaterValueThenFalse() {
        assertFalse(this.max.isWithin(NumberLine.greater(NumberLine.VALUE)));
    }

}
