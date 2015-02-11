import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Arrays {

    private static final String ENTER_THE_NUMBER = "Please enter the number (\"quit\" to stop the program, "
            + "\"get index\" to get index of smallest pair value difference, "
            + "you have already entered ";
    public static final String QUIT_TEXT = "quit";
    public static final String STOPPED = "The program is stopped.";
    public static final String GET_INDEX_TEXT = "get index";
    public static final String TWO_NUMBERS_AT_LEAST = "Please enter two numbers at least.";
    public static final String SMALLEST_PAIR_INDEX = "Index of smallest pair is: ";
    public static final int MIN_NUMBERS_REQUIRED = 2;
    public static final String INCORRECT_INPUT_PLEASE_REPEAT_ERROR = "Incorrect input, please repeat.";
    public static final String INVALID_NUMBER_ERROR = "Invalid number.";
    private static String printedString;
    private static int printedNumber;
    private static BufferedReader input;
    private static List<Integer> listOfEnteredNumbers;

    public static void main(String[] args) {
        input = new BufferedReader(new InputStreamReader(System.in));
        listOfEnteredNumbers = new ArrayList<Integer>();

        while (true) {
            System.out.println(ENTER_THE_NUMBER + listOfEnteredNumbers.size() + " numbers):");
            try {
                printedString = input.readLine();
                if (printedString.equals(QUIT_TEXT)) {
                    System.out.println(STOPPED);
                    break;
                } else if (printedString.equals(GET_INDEX_TEXT) && listOfEnteredNumbers.size() < MIN_NUMBERS_REQUIRED) {
                    System.out.println(TWO_NUMBERS_AT_LEAST);
                } else if (printedString.equals(GET_INDEX_TEXT)) {
                    System.out.println(SMALLEST_PAIR_INDEX
                            + getIndexOfSmallestPairValueDifference(listOfEnteredNumbers));
                    break;
                } else {
                    printedNumber = Integer.parseInt(printedString);
                    listOfEnteredNumbers.add(printedNumber);
                }
            } catch (IOException e) {
                System.out.println(INCORRECT_INPUT_PLEASE_REPEAT_ERROR);
            } catch (NumberFormatException e) {
                System.out.println(INVALID_NUMBER_ERROR);
            }
        }
    }

    private static int getIndexOfSmallestPairValueDifference(List<Integer> list) {
        int minDifference = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int first = list.get(i);
            int second = list.get(i + 1);
            int currentDifference;

            currentDifference = Math.abs(first - second);
            if (currentDifference < minDifference) {
                minDifference = currentDifference;
                result = i;
            }
        }
        return result;
    }
}
