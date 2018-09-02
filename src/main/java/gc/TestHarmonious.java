package gc;

import java.util.Arrays;

public class TestHarmonious {

  public static void main(String[] args) {
    int[] nums = {1,3,2,2,5,2,3,7}; // 12223357

    System.out.println(findLHS(nums));
  }

  public static int findLHS(int[] nums) {
    Arrays.sort(nums);
    int maxCount = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      int count1 = 0;
      int count0 = 0;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] - nums[i] == 0) {
          count0++;
        } else if (nums[j] - nums[i] == 1) {
          count1++;
        } else {
          break;
        }
      }
      int currentCount = count1 > 0 ? count0 + count1 + 1 : 0;
      maxCount = maxCount < currentCount ? currentCount : maxCount;
    }
    return maxCount;

  }

}
