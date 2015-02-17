package tasks;

import java.util.*;
import java.util.Arrays;

public class Anagram {

    public static final String INVALID_LETTERS_ERROR = "Please use only uppercase and lowercase english alphabet letters.";
    public static final String FIRST_STRING = "Enter first string: ";
    public static final String SECOND_STRING = "Enter second string: ";
    public static final String NEGATIVE_RESULT = "Strings are not anagrams.";
    public static final String POSITIVE_RESULT = "Strings are anagrams.";

    public static void main(String[] args) {

        String[] twoStringsFromUser = userInput();
        programOutput(checkAreStringsAnagrams(twoStringsFromUser[0], twoStringsFromUser[1]));
    }

    public static void programOutput(boolean areAnagrams) {
        if (areAnagrams) {
            System.out.println(POSITIVE_RESULT);
        } else {
            System.out.println(NEGATIVE_RESULT);
        }
    }

    public static String[] userInput() {
        Scanner input = new Scanner(System.in);
        String[] twoStrings = new String[2];

        for (int i = 0; i < 2; i++) {
            if (i == 0) System.out.println(FIRST_STRING);
            else System.out.println(SECOND_STRING);
            String printedString = input.nextLine();
            twoStrings[i] = printedString;
        }

        return twoStrings;
    }

    public static boolean checkAreStringsAnagrams(String first, String second) {

        if (first != null && second != null) {

            char[] firstArray = first.toLowerCase().replaceAll(" ", "").toCharArray();
            char[] secondArray = second.toLowerCase().replaceAll(" ", "").toCharArray();

            Arrays.sort(firstArray);
            Arrays.sort(secondArray);

            return Arrays.equals(firstArray, secondArray);
        } else {
            throw new InputMismatchException(INVALID_LETTERS_ERROR);
        }
    }
}

