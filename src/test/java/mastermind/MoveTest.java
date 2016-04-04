package mastermind;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by fex on 04.04.16.
 */
public class MoveTest {

  @Test
  public void testIsCongruent() {
    Code secret = Code.valueOf("RGBO");
    Code wrongSecret = Code.valueOf("RGOO");
    Code guess = Code.valueOf("ROBB");
    Move move = new Move(guess, 2, 1);
    assertTrue(move.isCongruent(secret));
    assertFalse(move.isCongruent(wrongSecret));
  }
}
