package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 2020-11-24 22:51
 * @Version 1.0
 * @Description 7. 整数反转
 */
public class Solution7 {
    /**
     * 如果 temp = rev * 10 + pop导致溢出，那么一定有 rev >= INTMAX / 10
     * 如果 rev > INTMAX / 10，那么temp = rev * 10 + pop 一定会溢出
     * 如果 rev == INTMAX / 10，那么只要 pop > 7，temp = rev * 10 + pop 就会溢出
     * rev 为负，类似的逻辑
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) { return 0; }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) { return 0; }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
