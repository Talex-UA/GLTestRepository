package mainTests;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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

    @Test(expected = Exception.class)
    public void wrongInput(){
            getIndexOfSmallestPairValueDifference("10 20 30adgfsdgf 60");
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

    @Ignore
    @Test
    public void oneNumber(){
        int i = getIndexOfSmallestPairValueDifference("10");
        assertEquals(1,i);
    }

    @Test(expected = Exception.class)
    public void nullString(){
        int i = getIndexOfSmallestPairValueDifference((int[]) null);
    }

}
