import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CalendarTask {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date (example \"10 October 2010\"): ");
        String str = sc.nextLine();

        try {
            Date date = new SimpleDateFormat("dd MMM yyyy").parse(str);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            System.out.println(detectDayOfWeek(dayOfWeek));
        } catch (ParseException e) {
            System.out.println("Unparseable date.");
        }
    }

    private static String detectDayOfWeek(int dayOfWeek) {

        String weekDay = "";
        switch (dayOfWeek) {
            case 2:
                weekDay = "Monday";
                break;
            case 3:
                weekDay = "Tuesday";
                break;
            case 4:
                weekDay = "Wednesday";
                break;
            case 5:
                weekDay = "Thursday";
                break;
            case 6:
                weekDay = "Friday";
                break;
            case 7:
                weekDay = "Saturday";
                break;
            case 1:
                weekDay = "Sunday";
                break;
        }
        return weekDay;
    }
}
