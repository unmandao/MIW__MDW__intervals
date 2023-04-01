package usantatecla;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ClosedMinTest extends MinTest {

    @Override
    @BeforeEach
    void before() {
        this.point = new Point(4.4);
        this.min = new ClosedMin(this.point.getEqual());
    }

    @Test
    @Override
    void givenMinWhenIsWithinWithEqualsValue() {
        assertTrue(this.min.isWithin(this.point.getEqual()));
    }

}
