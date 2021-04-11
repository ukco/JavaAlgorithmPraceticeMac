package com.lyr.test.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author lyr
 * @Date 4/11/21 11:20 PM
 * @Version 1.0
 * @Description 264. 丑数II
 */
public class Solution264 {
    /**
     * 最小堆
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] factors = new int[] {2, 3, 5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) { heap.offer(next); }
            }
        }
        return ugly;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int nthUglyNumber2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; ++i) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) { p2++; }
            if (dp[i] == num3) { p3++; }
            if (dp[i] == num5) { p5++; }
        }
        return dp[n];
    }
}
