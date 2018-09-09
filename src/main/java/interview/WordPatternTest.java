package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shengchao wu on 7/23/2018.
 */
public class WordPatternTest {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(WordPatternTest.wordPattern(pattern, str));
    }


    public static boolean wordPattern(String pattern, String str) {
        String[] strings = str.split(" ");
        if (strings.length != pattern.length()) {
            return false;
        }
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            String currentKey = pattern.charAt(i) + "";
            String currentValue = strings[i];
            if (map.isEmpty()) {
                map.put(currentKey, currentValue);
            } else {
                String patternStr = map.get(currentKey);
                if (patternStr == null) {
                    if (map.containsValue(currentValue)) {
                        return false;
                    }
                    map.put(currentKey, currentValue);
                } else if (patternStr != null && !patternStr.equals(currentValue)){
                    return false;
                }
            }
        }
        return true;
    }
}
