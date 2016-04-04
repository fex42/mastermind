package mastermind;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Represents a MasterMind code consisting of four colors.
 */
public class Code {
  public static final int CODELENGTH = 4;
  public static final int NUMBER_OF_COLORS = Color.values().length;

  private Color[] code = new Color[CODELENGTH];

  public Code(Color[] code) {
    this.code = code.clone();
  }

  public static Code valueOf(String cs) {
    Color[] newCode = new Color[CODELENGTH];
    if (cs == null || cs.length() != CODELENGTH) {
      throw new IllegalArgumentException("code must have length " + CODELENGTH);
    }
    for (int i = 0; i < CODELENGTH; i++) {
      Color color = Color.withC(cs.charAt(i));
      if (color == null) {
        throw new IllegalArgumentException("there's no color for '" + cs.charAt(i) + "'");
      }
      newCode[i] = color;
    }
    return new Code(newCode);
  }

  public static Set<Code> combinations() {
    Set<Code> codes = new HashSet<Code>();
    combinationsHelper(new Color[CODELENGTH], 0, codes);
    return codes;
  }

  private static void combinationsHelper(Color[] currentCode, int depth, Set<Code> codes) {
    if (depth < CODELENGTH) {
      for (Color c : Color.values()) {
        currentCode[depth] = c;
        combinationsHelper(currentCode, depth + 1, codes);
      }
    } else {
      codes.add(new Code(currentCode));
    }
  }

  public static Code createRandom() {
    Random rand = new Random(System.currentTimeMillis());
    Color[] values = Color.values();
    Color[] code = new Color[CODELENGTH];
    for (int i = 0; i < CODELENGTH; i++) {
      code[i] = values[rand.nextInt(values.length)];
    }
    return new Code(code);
  }

  public Color colorAt(int pos) {
    return code[pos];
  }

  public int exactMatches(Code other) {
    int result = 0;
    for (int i = 0; i < CODELENGTH; i++) {
      if (colorAt(i) == other.colorAt(i)) {
        result++;
      }
    }
    return result;
  }

  private int[] colorCount() {
    int[] result = new int[NUMBER_OF_COLORS];
    for (int j = 0; j < CODELENGTH; j++) {
      result[colorAt(j).ordinal()]++;
    }
    return result;
  }

  public int matches(Code other) {
    int[] myColors = colorCount();
    int[] otherColor = other.colorCount();
    int matches = 0;
    for (int i = 0; i < NUMBER_OF_COLORS; i++) {
      matches += Math.min(myColors[i], otherColor[i]);
    }
    return matches - exactMatches(other);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < CODELENGTH; i++) {
      sb.append(code[i].getC());
    }
    return sb.toString();
  }
}
