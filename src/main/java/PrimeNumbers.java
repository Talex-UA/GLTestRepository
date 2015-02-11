import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PrimeNumbers {

    private static final String WRONG_INPUT_ERROR = "Only numbers from 2 to two billion are available.";
    private static final int FIRST_PRIME_NUMBER = 2;
    private static final String ENTER_THE_NUMBER = "Enter the number: ";

    public static void main(String[] args) {
        Scanner input;
        int printedNumber;

        input = new Scanner(System.in);

        System.out.println(ENTER_THE_NUMBER);
        try {
            printedNumber = input.nextInt();
            if (printedNumber < FIRST_PRIME_NUMBER) {
                System.out.println(WRONG_INPUT_ERROR);
            } else {
                System.out.println(getPrimeNumbersLess(printedNumber));
            }
        } catch (InputMismatchException e) {
            System.out.println(WRONG_INPUT_ERROR);
        }
    }

    private static List<Integer> getPrimeNumbersLess(int printedNumber) {

        List<Integer> result = new ArrayList<Integer>();
        result.add(2);
        for (int i = 3; i <= printedNumber; i += 2) {
            boolean resultBool = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    resultBool = false;
                    break;
                }
            }
            if (resultBool) {
                result.add(i);
            }
        }
        return result;
    }

}
