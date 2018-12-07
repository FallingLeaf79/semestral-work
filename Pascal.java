/* This program prints the Pascal's triangle, with the number of rows
 * given by the user.
 */
public class Pascal {
  public static void main(String[] args) {
    int a = Integer.parseInt(args[0]);
    int pascal[][] = new int[a][a];

    for (int x = 0; x < a; x++) {
      pascal[x][0] = 1;
      if (x >= 1) {
        for (int y = 1; y < a; y++) {
          if (pascal[x - 1][y - 1] == 0) {
            continue;
          }
          pascal[x][y] = (pascal[x - 1][y - 1]) + (pascal [x - 1][y]);
        }
      }
      for (int z = 0; z <= x; z++) {
        for (int tab = (a - (x + 1)); tab > 0 && z < 1; tab--){
          System.out.printf("\t");
        }
        System.out.printf("%d\t\t", pascal[x][z]);
      }
      System.out.println();
    }
  }
}
