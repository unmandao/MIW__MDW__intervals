package usantatecla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClosedMaxTest extends MaxTest {

    @Override
    @BeforeEach
    void before() {
        this.max = new ClosedMax(NumberLine.VALUE);
    }

    @Test
    @Override
    void givenMaxWhenIsWithinWithEqualsValue() {
        assertTrue(this.max.isWithin(NumberLine.equals(NumberLine.VALUE)));
    }

}
