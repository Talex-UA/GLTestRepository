package mainTests;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static tasks.CalendarTask.detectDayOfWeek;

@RunWith(JUnit4.class)
public class Calendar_test {

    @Test
    public void currentDate(){
        assertEquals("Thursday", detectDayOfWeek("12 February 2015"));
    }

    @Test
    public void LeapYearDate(){
        assertEquals("Tuesday", detectDayOfWeek("29 February 2000"));
    }

    @Test(expected = Exception.class)
    public void notLeapYearDate(){
        detectDayOfWeek("29 February 1900");
    }

    @Test
    public void notDate(){
        detectDayOfWeek("Hello, my name is Sasha");
    }

    @Test
    public void nullString(){
        detectDayOfWeek(null);
    }

    @Ignore
    @Test
    public void dateWithSpaces(){
        detectDayOfWeek("  29    February   1900   ");
    }
}
