/* This program approximates the value of pi using the Monte Carlo method.
 */
public class Pi {
  public static boolean inCircle(double x, double y) {
    if (1 >= (x * x + y * y)) {
      return true;
    }
    else return false;
  }
  public static void main(String[] args) {
    int tries = Integer.parseInt(args[0]);
    java.util.Random random = new java.util.Random();
    int inCircle = 0;
    int all = 0;
    while (all < tries) {
      double nextX = ((random.nextDouble() * 2) - 1); //values between -1 and 1
      double nextY = ((random.nextDouble() * 2) - 1);
      if (inCircle(nextX, nextY)) {
        inCircle++;
      }
      all++;
    }
    double pi = ((double)inCircle/all)*4; //4 is the area of the square
    System.out.print(pi);
  }
}
