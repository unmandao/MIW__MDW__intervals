package usantatecla;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static usantatecla.NumberLine.VALUE;
import static usantatecla.NumberLine.equal;

class ClosedMinTest extends MinTest {

    @Override
    @BeforeEach
    void before() {
        this.min = new ClosedMin(VALUE);
    }

    @Test
    @Override
    void givenMinWhenIsWithinWithEqualsValue() {
        assertTrue(this.min.isWithin(equal(VALUE)));
    }

}
