package mastermind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CodeTest {
  @Test
  public void testCombinations() {
    assertEquals(1296, Code.combinations().size());
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
}
