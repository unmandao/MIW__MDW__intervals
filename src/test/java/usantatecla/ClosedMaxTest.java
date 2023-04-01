package usantatecla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static usantatecla.NumberLine.VALUE;
import static usantatecla.NumberLine.equal;

public class ClosedMaxTest extends MaxTest {

    @Override
    @BeforeEach
    void before() {
        this.max = new ClosedMax(VALUE);
    }

    @Test
    @Override
    void givenMaxWhenIsWithinWithEqualsValue() {
        assertTrue(this.max.isWithin(equal(VALUE)));
    }

}
