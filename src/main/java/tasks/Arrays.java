package tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Arrays {

    private static final String ENTER_THE_NUMBER = "Enter the numbers by whitespace: ";
    private static final String TWO_NUMBERS_AT_LEAST = "Please enter two numbers at least.";
    private static final String SMALLEST_PAIR_INDEX = "Index of smallest pair is: ";
    private static final int MIN_NUMBERS_REQUIRED = 2;
    private static final String INVALID_NUMBER_ERROR = "Invalid number.";

    public static void main(String[] args) {

        int[] inputString = userInput();
        int resultIndex = getIndexOfSmallestPairValueDifference(inputString);
        programOutput(resultIndex);
    }

    public static int[] userInput() {

        String printedString;
        String[] splittedBySpace;
        Scanner scanner = new Scanner(System.in);
        int[] result = null;

        System.out.println(ENTER_THE_NUMBER);
        try {
            printedString = scanner.nextLine();
            splittedBySpace = printedString.split(" ");
            result = new int[splittedBySpace.length];
            for (int i = 0; i < splittedBySpace.length; i++) {
                result[i] = Integer.valueOf(splittedBySpace[i]);
            }
        } catch (Exception e) {
            System.out.println(INVALID_NUMBER_ERROR);
        }

        return result;
    }

    public static int getIndexOfSmallestPairValueDifference(int... array) {

        int minDifference = Integer.MAX_VALUE;
        int result = 0;

        if (array.length < MIN_NUMBERS_REQUIRED) {
            throw new InputMismatchException(TWO_NUMBERS_AT_LEAST);
        }

        for (int i = 0; i < array.length - 1; i++) {
            int first = array[i];
            int second = array[i + 1];
            int currentDifference;

            currentDifference = Math.abs(first - second);
            if (currentDifference < minDifference) {
                minDifference = currentDifference;
                result = i;
            }
        }

        return result;
    }

    public static void programOutput(int resultIndex) {
        System.out.println(SMALLEST_PAIR_INDEX + resultIndex);
    }
}
