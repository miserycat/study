package anntation;

/**
 * Created by shengchao wu on 7/9/2018.
 */
public class Test1 {
    public static void main(String[] args) {

        int [] array = {1,2,3,4};

        checkArray(array, 10);

        String str = "aabbcccdddeea";

        String result = reverseString(str);

        System.out.println(result);

    }

    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(str.charAt(0)));
        int index= 0;
        while (index < str.length() -1) {
            if(str.charAt(index) != str.charAt(++index)) {
                sb.append(String.valueOf(str.charAt(index)));
            }
        }
        return sb.reverse().toString();
    }

    private static boolean checkArray(int[] array, int i) {
        return false;
    }
}
