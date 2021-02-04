package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 2/4/21 3:13 PM
 * @Version 1.0
 * @Description 643. 子数组最大平均数
 */
public class Solution643 {
    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }
}
