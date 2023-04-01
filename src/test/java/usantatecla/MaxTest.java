package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MaxTest {

    protected Max createMax(double value) {
        return new Max(value);
    }

    @Test
    void givenMaxWhenIsWithinWithLessValueThenTrue() {
        assertTrue(createMax(NumberLine.VALUE).isWithin(NumberLine.less(NumberLine.VALUE)));
    }

    @Test
    void givenMaxWhenIsWithinWithEqualsValue() {
        assertFalse(createMax(NumberLine.VALUE).isWithin(NumberLine.equals(NumberLine.VALUE)));
    }

    @Test
    void givenMaxWhenIsWithinWithGreaterValueThenFalse() {
        assertFalse(createMax(NumberLine.VALUE).isWithin(NumberLine.greater(NumberLine.VALUE)));
    }

}
