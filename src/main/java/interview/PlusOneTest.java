package interview;

/**
 * Created by shengchao wu on 7/23/2018.
 */
public class PlusOneTest {
    public static void main(String[] args) {
        int[] digits = {1,9,9};
        for (int digit : plusOne(digits)) {
            System.out.print(digit);
        }
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        if (digits[0] == 0) {
            return new int[]{1};
        }
        int[] result;
        boolean allNine = true;
        for (int d : digits) {
            if (d != 9) {
                allNine = false;
                break;
            }
        }
        if (allNine) {
            result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = 0;
            }
            return result;
        }
        int plus = 0;
        result = new int[digits.length];
        if (digits[digits.length - 1] == 9) {
            result[digits.length - 1] = 0;
            plus = 1;
        } else {
            result[digits.length - 1] = digits[digits.length - 1] + 1;
        }
        for (int i = digits.length - 2; i >= 0; i--) {
            int currentDigit = digits[i] + plus;
            if (currentDigit == 10) {
                result[i] = 0;
                plus = 1;
            } else {
                result[i] = currentDigit;
                plus = 0;
            }
        }
        return result;
    }
}
