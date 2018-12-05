/* This program prints out a calendar for any given month.
 * If no arguments are given, the current month is printed.
 * If one argument is given, the user-given month of the current year is
 * printed.
 * If two arguments are given, both the month and the year to be printed are
 * given by the user.
 */
import java.util.Calendar;

public class Kalendar {
  public static String getMonthName(int month) {
    String[] name = new String[]{
      "leden", "unor", "brezen", "duben", "kveten", "cerven",
      "cervenec", "srpen", "zari", "rijen", "listopad", "prosinec"
    };
    return name[month];
  }
  public static void repeatStuff(int repeat, char stuff) {
    while (repeat > 0) {
      System.out.print(stuff);
      repeat--;
    }
  }
  public static void printSeparator(int length, char edge, char fill) {
    System.out.print(edge);
    repeatStuff(length, fill);
    System.out.println(edge);
  }
  public static void printDate(int date) {
    if (date < 10) {
      System.out.print(" ");  //so that each date has the same width
    }
    System.out.print(date + " ");
  }
  public static void printWeekLines(Calendar cal, char edge) {
    int date = 1;
    /* week starts w/ Monday instead of the default Sunday, plus the API defines
     * the first day of the week as 1, but the code needs 0
     */
    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 2;
    if (dayOfWeek == -1) {  //Sunday has a value of -1 after the last operation
      dayOfWeek = 6;
    }
    while (date <= cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
      System.out.print(edge + " ");
      repeatStuff(dayOfWeek * 3, ' ');  //making sure the dates align properly
      while (
        dayOfWeek < 7 && date <= cal.getActualMaximum(Calendar.DAY_OF_MONTH)
      ) {
        printDate(date);
        date++;
        dayOfWeek++;
      }
      if (cal.getActualMaximum(Calendar.DAY_OF_MONTH) < date) {
        //printing spaces after the last day of the month
        repeatStuff((7 - dayOfWeek) * 3, ' ');
      }
      System.out.println(edge);
      dayOfWeek = 0;
    }
  }
  public static void printMonthLine(Calendar cal, char edge) {
    //prints the line with the month name and the year
    String name = (
      getMonthName(cal.get(Calendar.MONTH)) + " " +
      Integer.toString(cal.get(Calendar.YEAR))
    );
    System.out.print(edge);
    //aligning the words to the center of the line
    repeatStuff( 11 - (name.length() / 2) - (name.length() % 2), ' ');
    System.out.print(name);
    repeatStuff( 11 - (name.length() / 2), ' ');
    System.out.println(edge);
  }
  public static void printCalendar(Calendar cal) {
    char edge = '|';
    char sep = '-';
    int line = 22;
    printSeparator(line, '.', sep);
    printMonthLine(cal, edge);
    printSeparator(line, edge, sep);
    System.out.println(edge + " Po Ut St Ct Pa So Ne " + edge);
    printWeekLines(cal, edge);
    printSeparator(line, '\\', sep);
  }

  public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();
    //has to be the 1st day of the month for the code to work properly
    cal.set(Calendar.DATE, 1);
    if (args.length >= 1) {
      //-1 because January's value is 0
      cal.set(Calendar.MONTH, Integer.parseInt(args[0]) - 1);
    }
    if (args.length == 2) {
      cal.set(Calendar.YEAR, Integer.parseInt(args[1]));
    }
    printCalendar(cal);
  }
}
