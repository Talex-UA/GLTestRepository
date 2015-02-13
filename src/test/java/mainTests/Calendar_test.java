package mainTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static tasks.CalendarTask.detectDayOfWeek;

@RunWith(JUnit4.class)
public class Calendar_test {
    @Test
    public void unparseable(){
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        detectDayOfWeek("sdgdszgdrshg");
        try {
            myOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("Unparseable date.", myOut.toString().trim());
    }

    @Test
    public void currentDate(){
        assertEquals("Thursday", detectDayOfWeek("15 February 2015"));
    }

    @Test
    public void LeapYearDate(){
        assertEquals("Tuesday", detectDayOfWeek("29 February 2000"));
    }

    @Test(expected = Exception.class)
    public void notLeapYearDate(){

        detectDayOfWeek("29 February 1900");
    }
}
