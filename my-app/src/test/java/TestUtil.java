import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  private Util util;

  @Before
  public void setUp() {
    util = new Util();
  }

  @Test
  public void testSingleElement() {
    assertFalse("Expected false when array has only one element", util.compute(5));
  }

  @Test
  public void testEvenNumberOfElements() {
    assertFalse("Expected false when array has an even number of elements", util.compute(1, 2));
  }

  @Test(expected = RuntimeException.class)
  public void testContainsZero() {
    util.compute(1, 2, 3, 4, 0);
  }

  /*@Test
  public void testSumNotDivisibleByAnyElement() {
    assertFalse("Expected false when sum is not divisible by any element", util.compute(1, 2, 4));
  }*/

  @Test
  public void testSumNotDivisibleByAnyElement() {
    assertFalse("Expected false when sum is not divisible by any element in the array", util.compute(2, 2, 3));
  }


  @Test
  public void testSumDivisibleByAtLeastOneElement() {
    assertTrue("Expected true when sum is divisible by at least one element", util.compute(1, 2, 3));
  }

  /*@Test
  public void testLargerInputWhereSumIsDivisible() {
    assertTrue("Expected true for a larger input where sum is divisible by at least one element", util.compute(3, 4, 2, 1));
  }*/
}
