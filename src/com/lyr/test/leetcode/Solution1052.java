package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 2/23/21 12:36 PM
 * @Version 1.0
 * @Description 1052. 爱生气的书店老板
 */
public class Solution1052 {
    /**
     * 滑动窗口
     * 因为有X分钟可以控制情绪，所以这X分钟要用在关键的时间段，也就是需要知道哪个长度为X的时间段不满意的客人最多。
     * 最多满意客户数量 = 原本就满意的客户 + X时间段内因为控制了情绪而态度反转的最多客户数量
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        int increase = 0;
        for (int i = 0; i < X; i++) {
            increase += customers[i] * grumpy[i];
        }
        int maxIncrease = increase;
        for (int i = X; i < n; i++) {
            increase = increase - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return total + maxIncrease;
    }
}
