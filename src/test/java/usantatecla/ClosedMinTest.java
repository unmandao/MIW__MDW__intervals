package usantatecla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ClosedMinTest extends MinTest {

    @Override
    protected Min createMin() {
        return new ClosedMin(this.point.getEqual());
    }

    @Test
    @Override
    void givenMinWhenIsWithinWithEqualsValue() {
        assertTrue(this.min.isWithin(this.point.getEqual()));
    }

}
