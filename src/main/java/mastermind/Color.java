package mastermind;

public enum Color {
  RED('R'),
  GREEN('G'),
  BLUE('B'),
  YELLOW('Y'),
  PURPLE('P'),
  ORANGE('O');

  private final char c;

  Color(char c) {
    this.c = c;
  }

  public char getC() {
    return c;
  }

  public static Color withC(char c) {
    for (Color color: values()) {
      if (color.getC() == c) {
        return color;
      }
    }
    return null;
  }
}
