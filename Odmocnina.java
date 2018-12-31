/* This program approximates the cube root of a user-given number using
 * Newton's method (and assuming that Math.cbrt() doesn't exist).
 * This is, in fact, a slightly-modified (and commented) version of an older
 * program of mine for approximating the square root.
 */
public class Odmocnina {
  public static double guessResult(double base) {
     // probably way more complicated than need be, but works great
    int baseInt = (int)(base);
    String digitsStr = Integer.toString(baseInt);
    int digitsInt = digitsStr.length();
    double ceiling = ((double)digitsInt / 3);
    double guess = ((Math.pow(10, ceiling)) / 2);
    return guess;
  }

  public static double iteration(double guess, double base) {
    //uses Newton's method for approximating the cube root
    double newGuess = (((base / (guess * guess)) + (2 * guess)) / 3);
    return newGuess;
  }

  public static void main (String[] args) {
    double base = Double.parseDouble(args[0]);
    double precision = args.length == 2 ? Double.parseDouble(args[1]) : 0.001;

    double guess = guessResult(base);
    double newGuess = iteration(guess, base);

    while (Math.abs(newGuess - guess) > (precision)) {
      guess = newGuess;
      newGuess = iteration(guess, base);
    }

    System.out.printf(
      "Treti odmocnina %f je %f (+- %f).\n", base, newGuess, precision
      );

  }
}
