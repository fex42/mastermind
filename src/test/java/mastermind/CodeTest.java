package mastermind;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CodeTest {
  @Test
  public void testCombinations() {
    Set<Code> combinations = Code.combinations();
    for (Code c : combinations) {
      System.out.println(c);
    }
    assertEquals(1296, combinations.size());
  }

  @Test
  public void testExactMatches() {
    assertEquals(0, Code.valueOf("RGBO").exactMatches(Code.valueOf("YRGB")));
    assertEquals(3, Code.valueOf("RGBO").exactMatches(Code.valueOf("RGBY")));
    assertEquals(4, Code.valueOf("ORGB").exactMatches(Code.valueOf("ORGB")));
  }

  @Test
  public void testMatches() {
    assertEquals(3, Code.valueOf("RGBO").matches(Code.valueOf("YRGB")));
    assertEquals(2, Code.valueOf("RRRG").matches(Code.valueOf("GGRR")));
    assertEquals(0, Code.valueOf("RRRR").matches(Code.valueOf("GGGG")));
  }

  @Test
  public void testRandom() {
    Code code1 = Code.createRandom();
    Code code2 = Code.createRandom();
    assertNotEquals(code1, code2); // this is probably true, but can fail every 1296. test
  }
}
