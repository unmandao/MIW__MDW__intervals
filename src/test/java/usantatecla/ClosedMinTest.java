package usantatecla;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static usantatecla.Point.VALUE;
import static usantatecla.Point.getEqual;

class ClosedMinTest extends MinTest {

    @Override
    @BeforeEach
    void before() {
        this.min = new ClosedMin(VALUE);
    }

    @Test
    @Override
    void givenMinWhenIsWithinWithEqualsValue() {
        assertTrue(this.min.isWithin(getEqual(VALUE)));
    }

}
