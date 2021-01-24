package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 1/24/21 9:25 PM
 * @Version 1.0
 * @Description 674. 最长连续递增子序列
 */
public class Solution674 {
    /**
     * 贪心
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i  > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
