package usantatecla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ClosedMaxTest extends MaxTest {

    @Override
    protected Max createMax() {
        return new ClosedMax(this.point.getEqual());
    }

    @Test
    @Override
    void givenMaxWhenIsWithinWithEqualsValue() {
        assertTrue(this.max.isWithin(this.point.getEqual()));
    }

}
