/* This program takes user-inputted values and computes the frequency
 * of their appearance.
 *
 */
public class CetnostCisel {
  public static void copyFreqArray(int[][] oldArray, int[][] newArray) {
    //copies the array
    for (int y = 0; y < 2; y++) {
      System.arraycopy(oldArray[y], 0, newArray[y], 0, oldArray[y].length);
    }
  }

  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int[][] frequency = new int[2][1];
    int[][] newFrequency;     //we only need this one for extending frequency
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
      /* If a number is already in the array, add one to the counter
       * of its frequency.
       */
      else for (int x = 0;x < (frequency[0].length); x++) {
        if (input == frequency[0][x]) {
          frequency[1][x]++;
          alreadyPresent = true;
        }
      }
      /* If the number hasn't been encountered yet, the program
       * extends the array and inserts the number into it.
       */
      if (!alreadyPresent) {
        newFrequency = new int[2][frequency[1].length+1];
        copyFreqArray(frequency, newFrequency);
        frequency = new int[2][newFrequency[1].length];
        copyFreqArray(newFrequency, frequency);
        frequency[0][frequency[0].length-1] = input;
        frequency[1][frequency[1].length-1] = 1;
      }
    }
    /*Prints the numbers, and their frequency, in the order in which
     * they were inputted.
     */
    for (int z = 0; z < frequency[0].length; z++) {
      System.out.println(
      frequency[0][z] + "\tCetnost = " + frequency [1][z] + "x"
      );
    }
  }
}
