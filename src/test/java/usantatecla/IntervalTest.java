package usantatecla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IntervalTest {
  
  @Test
  void givenIntervalWhenIncludeWithIncludedValueThenTrue(){
    assertTrue(new Interval(-1.7,5555.0).include(0.0));
  }
  
}