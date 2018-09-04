package gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengchao wu on 7/24/2018.
 */
public class TestPerfectNum {

    public static void main(String[] args) {
        int num = 28;
        System.out.println(checkPerfectNumber(num));

//        perfectNumber(1000).stream().forEach(System.out::println);
    }

    public static boolean checkPerfectNumber(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum = sum + i + num/i;
            }
            if (i * i == num){
                sum -= i;
            }
            if (sum > num) {
                return false;
            }
        }
        return num == sum;
    }


    public static List<Integer> perfectNumber(int limit) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= limit; i++) {
            int sum = 0;
            for (int j = 1; j <= i/2; j++) {
                if (i % j == 0) {
                    sum += j;
                }
                if (sum > i) {
                    break;
                }
            }
            if (sum == i) {
                result.add(i);
            }
        }

        return result;
    }
}
