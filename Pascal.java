/* This program prints the Pascal's triangle, with the number of rows
 * given by the user.
 */
public class Pascal {
  public static void main(String[] args) {
    int a = Integer.parseInt(args[0]);
    /* A two-dimensional array is created, which is then used to make
     * a table, containing the values of a Pascal's triangle.
     * Those are then printed.
     */
    int triangle[][] = new int[a][a];
    for (int x = 0; x < a; x++) {
      triangle[x][0] = 1;
      if (x >= 1) {
        for (int y = 1; y < a; y++) {
          if (triangle[x-1][y-1] == 0) {
            continue;                     //for better efficiency
          }
          triangle[x][y] = (triangle[x-1][(y-1)]) + (triangle [x-1][y]);
        }
      }
      for (int z = 0; z <= x; z++) {
        System.out.printf("%d\t", triangle[x][z]);
      }
      System.out.println();
    }
  }
}
