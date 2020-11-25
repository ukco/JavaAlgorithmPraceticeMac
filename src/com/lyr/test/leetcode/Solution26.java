package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 2020-11-25 23:38
 * @Version 1.0
 * @Description 26. 删除排序数组中的重复项
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) { return 0; }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 避免不必要的复制
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                if (j - i > 1) {
                    nums[i + 1] = nums[j];
                }
                i++;
            }
        }
        return i + 1;
    }
}
