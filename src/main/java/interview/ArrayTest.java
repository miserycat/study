package interview;

import org.junit.Test;

/**
 * Created by shengchao wu on 7/20/2018.
 */
public class ArrayTest {

    @Test
    public void test() {
        String[] array = {"A","B","C"}; // A B C A B A C B C A B C NULL
        for (String s : convertToSubArray(array)) {
            System.out.println(s);
        }
    }

    private String[] convertToSubArray(String[] array) {


        // 1->1 2->1+1 3->3+2+2+1+1+1 4->4+3+3+2+2+2+1+1+1+1

        //n*1 + (n-1)*2 + ... + 1*(n+1)

        int length = 0;

        for (int i = array.length; i > 0; i--) {
            length += i * (array.length - i + 1);
        }

        System.out.println(length);




        String[] result = new String[length];

//        for (int i = 0;  i < array.length; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//
//            }
//        }


        return result;
    }


}
