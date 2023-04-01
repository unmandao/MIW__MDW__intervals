package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ClosedMaxTest {

    @Test
    public void givenMaxClosedwhenGreaterWithLessValueThenTrue() {
        assertTrue(new ClosedMax(4).isWithin(0.0));
    }

    @Test
    public void givenMaxClosedwhenGreaterWithGreaterValueThenFalse() {
        assertFalse(new ClosedMax(4).isWithin(5.0));
    }

    @Test
    public void givenMaxClosedwhenGreaterWithEqualValueThenFalse() {
        assertTrue(new ClosedMax(4).isWithin(4));
    }

}
