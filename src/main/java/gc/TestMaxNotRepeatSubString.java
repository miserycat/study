package gc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shengchao wu on 7/24/2018.
 */
public class TestMaxNotRepeatSubString {
    public static void main(String[] args) {
        String s = "abccbac";

        // a b c d
        // 0-len
        // 0-len-1 1-len
        // :
        // 0-2 1-3 ... len-2 len
        System.out.println(test3(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxCount = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int x = 0; x <= i; x++) {
                StringBuilder sb = new StringBuilder();
                int count = 0;
                for (int j = x; j < s.length() + x - i; j++) {
                    if (!sb.toString().contains(s.charAt(j) + "")) {
                        sb.append(s.charAt(j) + "");
                        count++;
                    } else {
                        break;
                    }
                }
                maxCount = count > maxCount ? count : maxCount;
            }
        }
        return maxCount;
    }

    public static int test2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int test3(String s) {
        int[] m = new int[256];
        Arrays.fill(m, -1);
        int res = 0, left = -1;
        for (int i = 0; i < s.length(); ++i) {
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            res = Math.max(res, i - left);
        }
        return res;
    }
}
