package mainTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static tasks.PrimeNumbers.getPrimeNumbersLess;

@RunWith(JUnit4.class)
public class PrimeNumbers_Test {
    @Test
    public void NegativeNumber(){
        List<Integer> input = getPrimeNumbersLess(-1);
        assertEquals(0,input.size());
    }

    @Test
    public void Zero(){
        List<Integer> input = getPrimeNumbersLess(0);
        assertEquals(0,input.size());
    }

    @Test
    public void Two(){
        List<Integer> input = getPrimeNumbersLess(2);
        assertEquals(1,input.size());
    }

    @Test
    public void Twenty(){
        List<Integer> input = getPrimeNumbersLess(20);
        int actual = input.get(4);
        assertEquals(11,actual);
    }
}
