/* This program prints an ellipse defined by values inputted by the user.
 * I used code from the following websites:
 * https://alej.alisma.cz/prog1/pg08/
 */
public class Elipsa {
  public static boolean insideEllipse(int x, int y, int a, int b) {
    //checks if a point [x,y] is inside the user-given ellipse using MATH
    return ((x/(double)a)*(x/(double)a))+((y/(double)b)*(y/(double)b)) < 1;
  }
  public static void main(String[] args) {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    /* code goes line by line, printing X in case a given point
     * is inside the user-given ellipse
     */
    for (int y = -b; y <= b; y++) {
      for (int x = -a; x <= a; x++) {
        if (insideEllipse(x, y, a, b)) {
          System.out.print("X");
        }
        else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
