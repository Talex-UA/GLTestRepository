import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PrimeNumbers {

    private static final String QUIT_TEXT = "quit";
    private static final String WRONG_INPUT_ERROR_TEXT = "Only numbers from 2 to two billion are available.";
    private static final String PROGRAM_IS_STOPPED_MESSAGE = "Program is stopped.";
    private static final String INTERRUPTED_ERROR_TEXT = "Program was interrupted.";
    private static final int FIRST_PRIME_NUMBER = 2;
    private static final String ENTER_THE_NUMBER = "Enter the number (type \"quit\" to stop the program):";
    private static BufferedReader input;
    private static String printedString;
    private static int printedNumber;

    public static void main(String[] args) {

        input = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println(ENTER_THE_NUMBER);
            try {
                printedString = input.readLine();
                if (printedString.equals(QUIT_TEXT)) {
                    System.out.println(PROGRAM_IS_STOPPED_MESSAGE);
                    break;
                } else {
                    printedNumber = Integer.parseInt(printedString);
                    if (printedNumber < FIRST_PRIME_NUMBER) {
                        System.out.println(WRONG_INPUT_ERROR_TEXT);
                    } else {
                        System.out.println(getPrimeNumbersLess(printedNumber));
                    }
                }
            } catch (IOException e) {
                System.out.println(INTERRUPTED_ERROR_TEXT);
            } catch (NumberFormatException e) {
                System.out.println(WRONG_INPUT_ERROR_TEXT);
            }
        }
    }

    private static List<Integer> getPrimeNumbersLess(int printedNumber) {

        List<Integer> result = new ArrayList<Integer>();

        for (int i = 2; i <= printedNumber; i++) {
            if (checkIsPrime(i)) {
                result.add(i);
            }
        }

        return result;
    }

    private static boolean checkIsPrime(int printedNumber) {
        boolean result = true;
        for (int i = 2; i <= printedNumber / 2; i++) {
            if (printedNumber % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
