import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Arrays {

    private static final String ENTER_THE_NUMBER = "Enter the numbers by whitespace (type \"get index\" to get result): ";
    private static final String TWO_NUMBERS_AT_LEAST = "Please enter two numbers at least.";
    private static final String SMALLEST_PAIR_INDEX = "Index of smallest pair is: ";
    private static final int MIN_NUMBERS_REQUIRED = 2;
    private static final String INVALID_NUMBER_ERROR = "Invalid number.";
    private static List<Integer> listOfEnteredNumbers;
    private static StringBuilder sb;

    public static void main(String[] args) {
        String printedString;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        listOfEnteredNumbers = new ArrayList<Integer>();
        sb = new StringBuilder();

        System.out.println(ENTER_THE_NUMBER);
        try {
            printedString = input.readLine();
            for (int i = 0; i < printedString.length(); i++) {
                if (printedString.charAt(i) != ' ') {
                    sb.append(printedString.charAt(i));
                } else {
                    convertToIntegerAndAddToList(sb, listOfEnteredNumbers);
                }
            }
            if (sb.length() != 0) {
                convertToIntegerAndAddToList(sb, listOfEnteredNumbers);
            }
        } catch (IOException e) {
            System.out.println(INVALID_NUMBER_ERROR);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_NUMBER_ERROR);
        }

        if (listOfEnteredNumbers.size() < MIN_NUMBERS_REQUIRED) {
            System.out.println(TWO_NUMBERS_AT_LEAST);
        } else {
            System.out.println(SMALLEST_PAIR_INDEX
                    + getIndexOfSmallestPairValueDifference
                    (listOfEnteredNumbers.toArray(new Integer[listOfEnteredNumbers.size()])));
        }

    }

    private static void convertToIntegerAndAddToList(
            StringBuilder sb, List<Integer> listOfEnteredNumbers) throws NumberFormatException {
        listOfEnteredNumbers.add(Integer.parseInt(sb.toString()));
        sb.setLength(0);
    }

    private static int getIndexOfSmallestPairValueDifference(Integer[] array) {
        int minDifference = Integer.MAX_VALUE;
        int result = 0;
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
}
