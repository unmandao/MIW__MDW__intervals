package usantatecla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static usantatecla.Point.*;

class MinTest {

    protected Min min;

    @BeforeEach
    void before() {
        this.min = new Min(VALUE);
    }

    @Test
    void givenMinWhenIsWithinWithLessValueThenFalse() {
        assertFalse(this.min.isWithin(getLess(VALUE)));
    }

    @Test
    void givenMinWhenIsWithinWithEqualsValue() {
        assertFalse(this.min.isWithin(getEqual(VALUE)));
    }

    @Test
    void givenMinWhenIsWithinWithGreaterValueThenTrue() {
        assertTrue(this.min.isWithin(getGreater(VALUE)));
    }

}

