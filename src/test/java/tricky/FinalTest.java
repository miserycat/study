package tricky;

import org.junit.Test;

public class FinalTest {

    @Test
    public void test1() {
        System.out.println(echo());
    }

    @Test
    public void test2() {

    }


    private int echo() {
        int x = 1;
        try {
            ++x;
            return x;
        } catch (Exception e) {


        } finally {
            ++x;
            x = x;
        }
        return x;

    }


}

