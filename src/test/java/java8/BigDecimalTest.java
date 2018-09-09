package java8;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by shengchao wu on 2/13/2018.
 */
public class BigDecimalTest {

    @Test
    public void test1() {
        BigDecimal b = new BigDecimal("0.0000001207");

        System.out.println(b.toString());
    }

    @Test
    public void test2() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            sdf.parse(null);
        } catch (ParseException e) {
            System.out.println("error");
        }
    }

    @Test
    public void test3() {
    }

}
