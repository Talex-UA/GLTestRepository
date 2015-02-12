import java.util.*;
import java.util.Arrays;

public class Anagram {

    public static final String INVALID_LETTERS_ERROR = "Please use only uppercase and lowercase english alphabet letters.";
    public static final String FIRST_STRING = "Enter first string: ";
    public static final String SECOND_STRING = "Enter second string: ";
    public static final String ONLY_LATIN_LETTERS = "[A-Za-z ]+";
    public static final String NEGATIVE_RESULT = "Strings are not anagrams.";
    public static final String POSITIVE_RESULT = "Strings are anagrams.";

    public static void main(String[] args) {

        String[] twoStringsFromUser = userInput();
        boolean areAnagrams = checkAreStringsAnagrams(twoStringsFromUser[0], twoStringsFromUser[1]);
        programOutput(areAnagrams);
    }

    private static void programOutput(boolean areAnagrams) {
        if (areAnagrams) {
            System.out.println(POSITIVE_RESULT);
        } else {
            System.out.println(NEGATIVE_RESULT);
        }
    }

    private static String[] userInput() {
        Scanner input = new Scanner(System.in);
        String[] twoStrings = new String[2];

        for (int i = 0; i < 2; i++) {
            if (i == 0) System.out.println(FIRST_STRING);
            else System.out.println(SECOND_STRING);

            String printedString = input.nextLine();
            if (!printedString.matches(ONLY_LATIN_LETTERS)) {
                System.out.println(INVALID_LETTERS_ERROR);
                System.exit(0);
            } else {
                twoStrings[i] = printedString.replaceAll(" ", "");
            }
        }

        return twoStrings;
    }

    private static boolean checkAreStringsAnagrams(String first, String second) {

        first = first.toLowerCase().replaceAll(" ", "");
        second = second.toLowerCase().replaceAll(" ", "");

        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();

        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        return first.length() == second.length() && Arrays.equals(firstArray, secondArray);

    }
}

