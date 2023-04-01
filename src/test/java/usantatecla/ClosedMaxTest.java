package usantatecla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ClosedMaxTest extends MaxTest {

    @Override
    protected Max createMax(double value) {
        return new ClosedMax(value);
    }

    @Test
    @Override
    void givenMaxWhenIsWithinWithEqualsValue() {
        assertTrue(createMax(NumberLine.VALUE).isWithin(NumberLine.equals(NumberLine.VALUE)));
    }

}
