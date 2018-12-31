/* This program prints 10 random addition problems with values between 0 and 20.
 */
public class Scitani {
  public static void main(String[] args) {
    int problems = 10;
    int max = 20;
    int a;
    int b;
    java.util.Random random = new java.util.Random();

    while (problems > 0) {
      a = random.nextInt(max);
      b = random.nextInt(max - a);
      System.out.println(a + " + " + b + " = ?");
      problems--;
    }
  }
}
