/*This program prints a zig-zag line with a user-given size.*/

public class Vlnovka {
  public static void repeatStuff(int repeat, char stuff) {
    while (repeat > 0) {
      System.out.print(stuff);
      repeat--;
    }
  }

  public static void printZigZagLine(int size, int lineNum) {
    int spaceX = (size * 2) - 3 - (2 * lineNum);
    int spaceY = (size * 2) - 4 - spaceX;
    int repeats = (int)(80 / (double)((size - 1) * 2));

    if (lineNum == 0 || lineNum == size - 1) {
      repeatStuff(lineNum, ' ');
      for (int i = 0; i < repeats; i++) {
        System.out.print('#');
        repeatStuff((size * 2) - 3, ' ');
      }
    }
    else {
      repeatStuff(lineNum, ' ');
      for (int i = 0; i < repeats; i++) {
        System.out.print('#');
        repeatStuff(spaceX, ' ');

        System.out.print('#');
        repeatStuff(spaceY, ' ');
      }
    }
  }

  public static void main(String[] args) {
    int size = Integer.parseInt(args[0]);
    if (size < 2) {
      System.out.println("Prilis nizke cislo!");
    }
    else for (int x = 0; x < size; x++) {
      printZigZagLine(size, x);
      System.out.println();
    }
  }
}
