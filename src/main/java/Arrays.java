import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Arrays {

    private static final String ENTER_THE_NUMBER = "Enter the numbers by whitespace (type \"get index\" to get result): ";
    private static final String TWO_NUMBERS_AT_LEAST = "Please enter two numbers at least.";
    private static final String SMALLEST_PAIR_INDEX = "Index of smallest pair is: ";
    private static final int MIN_NUMBERS_REQUIRED = 2;
    private static final String INVALID_NUMBER_ERROR = "Invalid number.";

    public static void main(String[] args) {

        String inputString = userInput();
        int resultIndex = getIndexOfSmallestPairValueDifference(inputString);
        programOutput(resultIndex);
    }

    public static String userInput() {

        String printedString = null;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(ENTER_THE_NUMBER);
        try {
            printedString = input.readLine();
        } catch (Exception e) {
            System.out.println(INVALID_NUMBER_ERROR);
        }

        return printedString;
    }

    private static int getIndexOfSmallestPairValueDifference(String printedString) {

        List<Integer> array = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();
        int minDifference = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < printedString.length(); i++) {
            if (printedString.charAt(i) != ' ') {
                sb.append(printedString.charAt(i));
            } else {
                convertToIntegerAndAddToList(sb, array);
            }
        }

        if (sb.length() != 0) convertToIntegerAndAddToList(sb, array);

        for (int i = 0; i < array.size() - 1; i++) {
            int first = array.get(i);
            int second = array.get(i + 1);
            int currentDifference;

            currentDifference = Math.abs(first - second);
            if (currentDifference < minDifference) {
                minDifference = currentDifference;
                result = i;
            }
        }

        if (array.size() < MIN_NUMBERS_REQUIRED) {
            System.out.println(TWO_NUMBERS_AT_LEAST);
            System.exit(0);
        }

        return result;
    }

    private static void convertToIntegerAndAddToList(
            StringBuilder sb, List<Integer> listOfEnteredNumbers) throws NumberFormatException {
        listOfEnteredNumbers.add(Integer.parseInt(sb.toString()));
        sb.setLength(0);
    }

    private static void programOutput(int resultIndex) {
        System.out.println(SMALLEST_PAIR_INDEX + resultIndex);
    }
}
