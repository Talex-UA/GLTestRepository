package mainTests;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.InputMismatchException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static tasks.Arrays.getIndexOfSmallestPairValueDifference;

@RunWith(JUnit4.class)
public class Arrays_Test {
    @Test
    public void simpleArray(){
        assertEquals(3,getIndexOfSmallestPairValueDifference(new int []{10, 20, 30, 40, 42, 60}));
    }

    @Test
    public void equalNumbers(){
        assertEquals(3,getIndexOfSmallestPairValueDifference(new int []{10, 20, 30, 5, 5, 60}));
    }

    @Test
    public void twoNumbers(){
        assertEquals(0,getIndexOfSmallestPairValueDifference(new int []{10, 10000}));
    }

    @Test
    public void twoEqualNumbers(){
        assertEquals(0,getIndexOfSmallestPairValueDifference(new int []{10, 10}));
    }

    @Test
    public void twoOppositeNumbers(){
        assertEquals(0,getIndexOfSmallestPairValueDifference(new int []{-10, 10}));
    }

    @Test
    public void twoCriticalNumbers(){
        assertEquals(0,getIndexOfSmallestPairValueDifference(new int []{Integer.MIN_VALUE, Integer.MAX_VALUE}));
    }

    @Test(expected = InputMismatchException.class)
    public void oneNumber(){
        getIndexOfSmallestPairValueDifference(new int[]{10});
    }

    @Test(expected = InputMismatchException.class)
    public void emptyArray(){
        getIndexOfSmallestPairValueDifference(new int[]{});
    }

    @Test(expected = InputMismatchException.class)
    public void nullString(){
        getIndexOfSmallestPairValueDifference((int[]) null);
    }

}
