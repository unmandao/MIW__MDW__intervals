package usantatecla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClosedMaxTest extends MaxTest {

    @Override
    @BeforeEach
    void before() {
        this.point = new Point(4.4);
        this.max = new ClosedMax(this.point.getEqual());
    }

    @Test
    @Override
    void givenMaxWhenIsWithinWithEqualsValue() {
        assertTrue(this.max.isWithin(this.point.getEqual()));
    }

}
