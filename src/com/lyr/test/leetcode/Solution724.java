package com.lyr.test.leetcode;

import java.util.Arrays;

/**
 * @Author lyr
 * @Date 1/28/21 7:26 PM
 * @Version 1.0
 * @Description 724. 寻找数组的中心索引
 */
public class Solution724 {
    /**
     * 前缀和
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
