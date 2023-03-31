package usantatecla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MaxTest {
   
  @Test
  void givenIntervalWhenIncludeWithIncludedValueThenTrue(){
    assertTrue(new Max(true, 4).greater(0.0));
  }
 
}
