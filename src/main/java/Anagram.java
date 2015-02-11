import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {

    public static final String INVALID_LETTERS_ERROR = "Please use only uppercase and lowercase english alphabet letters.";
    public static final String FIRST_STRING = "Enter first string: ";
    public static final String SECOND_STRING = "Enter second string: ";
    public static final String ONLY_LATIN_LETTERS = "[A-Za-z ]+";
    public static final String INCORRECT_INPUT_ERROR = "Incorrect input, please repeat.";
    public static final String NEGATIVE_RESULT = "Strings are not anagrams.";
    public static final String POSITIVE_RESULT = "Strings are anagrams.";

    public static void main(String[] args) {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] twoStrings = new String[2];

        for (int i = 0; i < 2; i++) {
            if (i == 0) System.out.println(FIRST_STRING);
            else System.out.println(SECOND_STRING);

            try {
                String printedString = input.readLine();
                if (!printedString.matches(ONLY_LATIN_LETTERS)) {
                    System.out.println(INVALID_LETTERS_ERROR);
                    System.exit(0);
                } else {
                    twoStrings[i] = printedString.replaceAll(" ", "");
                }
            } catch (IOException e) {
                System.out.println(INCORRECT_INPUT_ERROR);
            }
        }

        if (twoStrings[0].length() == twoStrings[1].length()) {

            if (checkAreStringsAnagrams(0, twoStrings[0], twoStrings[1])) {
                System.out.println(POSITIVE_RESULT);
            } else {
                System.out.println(NEGATIVE_RESULT);
            }
        } else {
            System.out.println(NEGATIVE_RESULT);
        }
    }

    private static boolean checkAreStringsAnagrams(int circleIndex, String firstString, String secondString) {
        boolean result = true;

        FIRST_LOOP:
        for (int i = 0; i < firstString.length(); i++) {
            for (int j = 0; j < secondString.length(); j++) {
                if (Character.toLowerCase(firstString.charAt(i))
                        == Character.toLowerCase(secondString.charAt(j))) {
                    continue FIRST_LOOP;
                }
            }
            result = false;
            break;
        }

        if (result && circleIndex == 0) {
            return checkAreStringsAnagrams(++circleIndex, secondString, firstString);
        }

        return result;

    }
}

