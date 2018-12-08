/* This program outputs an SVG file of a bar graph with user-given values.
 */

import java.nio.file.*;
import java.io.IOException;

public class Graf {
  public static final String FILEPATH = "grafoutput.svg";
  public static final String START = (
    "<?xml version=\"1.0\"?>\n<svg xmlns=\"http://www.w3.org/2000/svg\"\n"
  );
  public static final String END = "</svg>";
  public static final String COLOR = "salmon";
  public static final int VIEWBOX_HEIGHT = 320;
  public static final int BAR_WIDTH = 50;
  public static final int GAP = 10;

  public static String viewBoxSize(int width, int height) {
    return (
      "\twidth=\"" + width + "\" height=\"" + height +
      "\"\n\tviewBox=\"0 0 " + width + " " + height + "\">\n"
    );
  }

  public static String rectangle(
    String color, int width, int height, int positionX, int positionY
  ) {
    return (
      "\t\t<rect x=\"" + positionX + "\" y=\"" + positionY + "\" width=\"" +
      width + "\" height=\"" + height + "\" fill=\"" + color + "\"/>\n"
    );
  }

  public static int[] growArray(int[] array, int growth) {
    int[] helper = new int[array.length + growth];
    System.arraycopy(array, 0, helper, 0, array.length);

    array = new int[helper.length];
    System.arraycopy(helper, 0, array, 0, array.length);

    return array;
  }

  public static void main(String[] args) throws IOException{
    int[] values = new int[0];
    int max = 0;
    java.util.Scanner sc = new java.util.Scanner(System.in);

    while (sc.hasNextInt()) {
      int input = sc.nextInt();
      values = growArray(values, 1);
      values[values.length - 1] = input;

      if (input > max) {
        max = input;
      }
    }

    String rectangles = "";
    int maxBarHeight = VIEWBOX_HEIGHT - (2 * GAP);
    for (int i = 0; i < values.length; i++) {
      rectangles += rectangle(
        COLOR,
        BAR_WIDTH,
        (int)((maxBarHeight) * ((double)values[i] / max)),
        GAP + (BAR_WIDTH + GAP) * i,
        GAP + (maxBarHeight) - (int)((maxBarHeight) * ((double)values[i] / max))
      );
    }

    String viewBox = viewBoxSize(
    GAP + ((BAR_WIDTH + GAP) * values.length), VIEWBOX_HEIGHT
    );

    Path file = Paths.get(FILEPATH);
    byte[] output = (START + viewBox + rectangles + END).getBytes();
    Files.write(file, output);
  }
}
