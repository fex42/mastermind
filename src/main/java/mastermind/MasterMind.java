package mastermind;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * MasterMind main program including solver
 */
public class MasterMind {
  private final static Random rand = new Random(System.currentTimeMillis());

  public static void main(String[] args) {
    Code secret = Code.createRandom();
    if (args.length == 1) {
      secret = Code.valueOf(args[0]);
    }

    Set<Code> possibleCodes = Code.combinations();
    solve(secret, possibleCodes, 0);
  }

  private static void solve(Code secret, Set<Code> possibleCodes, int i) {
    // pick random code
    Code guess = pickGuess(possibleCodes);

    // calculate move and print it
    Move move = new Move(guess, secret.exactMatches(guess), secret.matches(guess));
    System.out.println("Move #" + i + ": " + move);

    // calculate new congruent Set
    for (Iterator<Code> iterator = possibleCodes.iterator(); iterator.hasNext(); ) {
      Code candidate = iterator.next();
      if (!move.isCongruent(candidate)) {
        iterator.remove();
      }
    }

    if (possibleCodes.size() == 1) {
      System.out.println("Solution: " + possibleCodes.iterator().next());
    } else {
      solve(secret, possibleCodes, i + 1);
    }
  }

  private static Code pickGuess(Set<Code> possibleCodes) {
    int size = possibleCodes.size();
    int rnd = rand.nextInt(size);
    return possibleCodes.toArray(new Code[size])[rnd];
  }
}
