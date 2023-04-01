package usantatecla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static usantatecla.Point.VALUE;
import static usantatecla.Point.getEqual;

public class ClosedMaxTest extends MaxTest {

    @Override
    @BeforeEach
    void before() {
        this.max = new ClosedMax(VALUE);
    }

    @Test
    @Override
    void givenMaxWhenIsWithinWithEqualsValue() {
        assertTrue(this.max.isWithin(getEqual(VALUE)));
    }

}
