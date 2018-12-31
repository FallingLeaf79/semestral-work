/* This program prints out sequences of numbers based on user-inputted
 * arguments.
 * If there is only one argument, the program prints out a number sequence
 * from 1 to the inputted number.
 * If there are two arguments, the program prints a number sequence between
 * those numbers.
 * If there are three arguments, the program prints out a number sequence
 * between the first and the last number, with the size of the "jump" defined
 * by the middle argument.
 */
public class Seq {
  public static void main(String[] args) {
    int num = 1;
    int step = 1;
    int end = Integer.parseInt(args[args.length - 1]);

    if (args.length > 1) {
      num = Integer.parseInt(args[0]);
    }
    if (args.length == 3) {
      step = Integer.parseInt(args[1]);
    }
    if (step < 0) {
      while (num >= end) {
        System.out.print(num + " ");
        num += step;
      }
    }
    else {
      while (num <= end) {
        System.out.print(num + " ");
        num += step;
      }
    }
  }
}
