import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class TestCompute {
  private MessageQueue mq;
  private Compute compute;

  @Before
  public void setUp() {
    mq = mock(MessageQueue.class);
    compute = new Compute(mq);
  }

  @Test
  public void testEmptyMessageQueue() {
    when(mq.size()).thenReturn(0);
    assertEquals("Expected -1 when MessageQueue is empty", -1, compute.countNumberOfOccurrences("anyString"));
  }

  @Test
  public void testElementNotInQueue() {
    when(mq.size()).thenReturn(3);
    when(mq.contains("testElement")).thenReturn(false);
    assertEquals("Expected 0 when element is not in the queue", 0, compute.countNumberOfOccurrences("testElement"));
  }

  @Test
  public void testElementOccursMultipleTimes() {
    when(mq.size()).thenReturn(5);
    when(mq.contains("testElement")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("testElement");
    when(mq.getAt(1)).thenReturn("anotherElement");
    when(mq.getAt(2)).thenReturn("testElement");
    when(mq.getAt(3)).thenReturn("anotherElement");
    when(mq.getAt(4)).thenReturn("testElement");
    assertEquals("Expected 3 as the number of occurrences", 3, compute.countNumberOfOccurrences("testElement"));
  }

  @Test
  public void testElementOccursOnce() {
    when(mq.size()).thenReturn(3);
    when(mq.contains("testElement")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("anotherElement");
    when(mq.getAt(1)).thenReturn("testElement");
    when(mq.getAt(2)).thenReturn("anotherElement");
    assertEquals("Expected 1 as the number of occurrences", 1, compute.countNumberOfOccurrences("testElement"));
  }
}
