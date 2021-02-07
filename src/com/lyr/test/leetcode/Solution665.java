package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 2/7/21 6:40 PM
 * @Version 1.0
 * @Description 665. 非递减数列
 */
public class Solution665 {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                nums[i] = y;
                if (isSorted(nums)) {
                    return true;
                }
                // 复原
                nums[i] = x;
                nums[i + 1] = x;
                return isSorted(nums);
            }
        }
        return true;
    }
    private boolean isSorted(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }
}
