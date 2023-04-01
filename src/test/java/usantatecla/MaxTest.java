package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MaxTest {

    @Test
    void givenMaxOpenedWhenGreaterWithLessValueThenTrue() {
        assertTrue(new Max(4).isWithin(0.0));
    }

    @Test
    void givenMaxOpenedWhenGreaterWithGreaterValueThenFalse() {
        assertFalse(new Max(4).isWithin(5.0));
    }

    @Test
    void givenMaxOpenedWhenGreaterWithEqualValueThenFalse() {
        assertFalse(new Max(4).isWithin(4));
    }

}
