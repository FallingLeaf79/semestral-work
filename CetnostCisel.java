/* This program takes user-inputted values and prints the frequency
 * of their appearance.
 */
public class CetnostCisel {
  public static void copyFreqArray(int[][] oldArray, int[][] newArray) {
    for (int y = 0; y < 2; y++) {
      System.arraycopy(oldArray[y], 0, newArray[y], 0, oldArray[y].length);
    }
  }

  public static int getIndexOfLargest(int[] array) {
    int largest = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] > array[largest]) {
        largest = i;
      }
    }
    return largest;
  }

  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int[][] frequency = new int[2][1];
    int[][] extendFrequency;
    int numberOfValues = 0;

    while (sc.hasNextInt()) {
      int input = sc.nextInt();
      boolean alreadyPresent = false;
      numberOfValues++;

      if (numberOfValues == 1) {      //special case
        frequency[0][0] = input;
        frequency[1][0] = 1;
        alreadyPresent = true;
      }

      else for (int x = 0; x < (frequency[0].length); x++) {
        if (input == frequency[0][x]) {
          frequency[1][x]++;
          alreadyPresent = true;
        }
      }

      if (!alreadyPresent) {
        extendFrequency = new int[2][frequency[1].length + 1];
        copyFreqArray(frequency, extendFrequency);

        frequency = new int[2][extendFrequency[1].length];
        copyFreqArray(extendFrequency, frequency);

        frequency[0][frequency[0].length - 1] = input;
        frequency[1][frequency[1].length - 1] = 1;
      }
    }

    /* Prints the numbers and their frequency, in order of their frequency.
     * (Most frequent values appear at the top)
     */
    for (int z = 0; z < frequency[0].length; z++) {
      System.out.println(
        frequency[0][getIndexOfLargest(frequency[1])] +
        "\t" + frequency[1][getIndexOfLargest(frequency[1])] + "x"
      );
      // discarding an already printed value
      frequency[1][getIndexOfLargest(frequency[1])] = 0;
    }
  }
}
