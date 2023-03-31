package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MaxTest {
   
  @Test
  public void givenMaxWhenGreaterWithLessValueThenTrue(){
    assertTrue(new Max(true, 4).greater(0.0));
  }

  @Test
  void givenMaxWhenGreaterWithLessValueThenFalse(){
    assertFalse(new Max(true, 4).greater(5.0));
  }
 
}
