package mainTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static tasks.Anagram.checkAreStringsAnagrams;

@RunWith(JUnit4.class)
public class Anagram_Test {
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
    public void otherAnagram(){
        assertTrue(checkAreStringsAnagrams("William Shakespeare", " I am a weakish speller  "));
    }

    @Test
    public void emptyField(){
        assertFalse(checkAreStringsAnagrams("William Shakespeare", ""));
    }

    @Test
    public void twoEmptyFields(){
        assertTrue(checkAreStringsAnagrams("", ""));
    }
}
