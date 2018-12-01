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
      double nextX = random.nextDouble();
      double nextY = random.nextDouble();
      if (inCircle(nextX, nextY)) {
        inCircle++;
      }
      all++;
    }
    double pi = ((double)inCircle/all)*4; //ratio is pi/4
    System.out.print(pi);
  }
}
