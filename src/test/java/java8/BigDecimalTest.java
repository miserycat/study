package java8;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by shengchao wu on 2/13/2018.
 */
public class BigDecimalTest {

    @Test
    public void test1() {
        BigDecimal b = new BigDecimal("0.0000001207");

        System.out.println(b.toString());
    }

}
