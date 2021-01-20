package com.lyr.test.leetcode;

import java.util.Arrays;

/**
 * @Author lyr
 * @Date 1/20/21 7:29 PM
 * @Version 1.0
 * @Description 628. 三个数的最大乘积
 */
public class Solution628 {
    /**
     * 排序
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[0] * nums[1] * nums[len - 1]);
    }

    /**
     * 线性扫描
     * @param nums
     * @return
     */
    public int maximumProduct2(int[] nums) {
        // 最小的和第二小的
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 最大的、第二大的和第三大的
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }

            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }

        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
