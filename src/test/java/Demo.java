import org.junit.Test;
import org.apache.commons.lang.StringUtils;

public class Demo {
    @Test
    public void test1() {
        String input = "I love Java";

        String result1 = StringUtils.leftPad(input, 20, "*");
        String result2 = StringUtils.rightPad(input, 20, "*");
        String result3 = StringUtils.center(input, 20, "*");

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
