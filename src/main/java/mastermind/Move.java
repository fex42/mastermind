package mastermind;

/**
 * Representation of a MasterMind move.
 */
public class Move {
  private Code guess;
  private int exactMatches;
  private int matches;

  public Move(Code guess, int exactMatches, int matches) {
    this.guess = guess;
    this.exactMatches = exactMatches;
    this.matches = matches;
  }

  @Override
  public String toString() {
    return "Move{\"" + guess +
        "\", " + exactMatches +
        ", " + matches +
        '}';
  }

  public boolean isCongruent(Code secret) {
    return exactMatches == guess.exactMatches(secret) && matches == guess.matches(secret);
  }
}
