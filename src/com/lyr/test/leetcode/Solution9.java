package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 3/2/21 1:33 PM
 * @Version 1.0
 * @Description 9. 回文数
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) { return false; }

        int tmp = x;
        int y = 0;
        while (tmp != 0) {
            y = y * 10 + tmp % 10;
            tmp /= 10;
        }
        return x == y;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) { return false; }

        String tmp = String.valueOf(x);
        for (int i = 0, j = tmp.length() - 1; i <=j ; i++, j--) {
            if (tmp.charAt(i) != tmp.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) { return false; }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
