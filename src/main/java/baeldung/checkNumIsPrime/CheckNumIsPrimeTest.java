package baeldung.checkNumIsPrime;
import org.apache.commons.math3.primes.Primes;
import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Created by shengchao wu on 7/19/2018.
 */
public class CheckNumIsPrimeTest {
    @Test
    public void test() {
        int i = 3;
        System.out.println(isPrime(i));

        System.out.println(Primes.isPrime(i));
    }

    private boolean isPrime(int number) {
        return number > 2
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));

    }

    private boolean isPrime2(int number) {
        BigInteger bigInt = BigInteger.valueOf(number);
        return bigInt.isProbablePrime(number);
    }

}
