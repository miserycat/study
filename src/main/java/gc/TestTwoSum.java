package gc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shengchao wu on 7/25/2018.
 */
public class TestTwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        for (int i : twoSum(nums, 9)) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int nums[], int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int pairNum = target - nums[i];
            if (map.keySet().contains(pairNum)) {
                result[0] = map.get(pairNum);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
