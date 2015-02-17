package mainTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.InputMismatchException;
import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static tasks.Anagram.checkAreStringsAnagrams;

@RunWith(JUnit4.class)
public class Anagram_Test {

    private String generateString(int length) {
        String alphabet = "qwertyuiopasdfghjklzxcvbnm ";
        String result = "";
        for (int i = 0; i < length; i++) {
            Random random = new Random();
            result += alphabet.charAt(random.nextInt(alphabet.length()));
        }
        return result;
    }


    @Test
    public void Anagrams(){
        assertTrue(checkAreStringsAnagrams("Desperation","A Rope Ends It"));
    }

    @Test
    public void notAnagrams(){
        assertFalse(checkAreStringsAnagrams("Desperation","It's not an anagram"));
    }

    @Test
    public void AnagramsWithSpaces(){
        assertTrue(checkAreStringsAnagrams("Desperation", " A    Rope  Ends   It     "));
    }

    @Test
    public void emptyField(){
        assertFalse(checkAreStringsAnagrams("William Shakespeare", ""));
    }

    @Test
    public void twoEmptyFields(){
        assertTrue(checkAreStringsAnagrams("", ""));
    }

    @Test(expected = InputMismatchException.class)
         public void checkIfNulls() {
        checkAreStringsAnagrams(null, null);
    }

    @Test(expected = InputMismatchException.class)
    public void checkIfOneNull() {
        checkAreStringsAnagrams(null, generateString(10));
    }

    @Test
    public void randomAnagrams() {
        String anagram=generateString(10);
        assertTrue(checkAreStringsAnagrams(anagram, anagram));
    }

    @Test
    public void randomNotAnagrams() {
        assertFalse(checkAreStringsAnagrams(generateString(10), generateString(9)));
    }
}
