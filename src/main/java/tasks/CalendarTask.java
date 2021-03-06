package tasks;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarTask {

    public static final String INVALID_DATE = "Unparseable date.";

    public static void main(String[] args) {

        String userInputString = userInput();
        String dayOfWeek = detectDayOfWeek(userInputString);
        programOutput(dayOfWeek);
    }

    public static void programOutput(String dayOfWeek) {
        System.out.println(dayOfWeek);
    }

    public static String userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date (example \"10 October 2010\"): ");
        return sc.nextLine();
    }

    public static String detectDayOfWeek(String str) {

        int dayOfWeek = 0;

        try {
            Date date = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(str);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            if (str.split(" ")[0].equals("29") && str.split(" ")[1].equals("February") && !isLeapYear(c.get(Calendar.YEAR))) {
                throw new InputMismatchException();
            }
            dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        } catch (ParseException e) {
            System.out.println(INVALID_DATE);
        }
        String[] weekDays = DateFormatSymbols.getInstance().getWeekdays();
        return weekDays[dayOfWeek];
    }

    public static boolean isLeapYear(int year) {

        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }
}
