package mainTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static tasks.Arrays.getIndexOfSmallestPairValueDifference;

@RunWith(JUnit4.class)
public class Arrays_Test {
    @Test
    public void simpleArray(){
        assertEquals(3,getIndexOfSmallestPairValueDifference("10 20 30 40 42 60"));
    }

    @Test
    public void equalNumbers(){
        assertEquals(3,getIndexOfSmallestPairValueDifference("10 20 30 5 5 60"));
    }

    @Test
    public void wrongInput(){
        try {
            getIndexOfSmallestPairValueDifference("10 20 30adgfsdgf 60");
        }
        catch (Exception e) {
            fail("There was exception");
        }
    }

    @Test
    public void twoNumbers(){
        assertEquals(0,getIndexOfSmallestPairValueDifference("10 10000"));
    }

    @Test
    public void twoEqualNumbers(){
        assertEquals(0,getIndexOfSmallestPairValueDifference("10 10"));
    }

    @Test
    public void twoOppositeNumbers(){
        assertEquals(0,getIndexOfSmallestPairValueDifference("-10 10"));
    }

//    @Test
//    public void oneNumber(){
//        try (ByteArrayOutputStream myOut2 = new ByteArrayOutputStream();
//             PrintStream out = new PrintStream(myOut2);) {
//            System.setOut(out);
//            getIndexOfSmallestPairValueDifference("10");
//            out.flush();
//            myOut2.close();
//            assertEquals("Please enter two numbers at least.", myOut2.toString().trim());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
