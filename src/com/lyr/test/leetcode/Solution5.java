package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 2/26/21 12:25 PM
 * @Version 1.0
 * @Description 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
 */
public class Solution5 {
    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) { return s; }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示s[i...j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; ++i) { dp[i][i] = true; }

        char[] charArray = s.toCharArray();
        // 注意：左下角先填
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        // 即 axa 的形式 或 aa 的形式
                        dp[i][j] = true;
                    } else {
                        // i,j 位置处字符相等的情况下，像中心缩减，即看 i + 1 和 j - 1 位置处的字符
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i...j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 中心扩展算法
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) { return s; }

        int maxLen = 1;
        int begin = 0;

        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            int oddLen = expandAroundCenter(charArray, i, i);
            int evenLen = expandAroundCenter(charArray, i, i + 1);

            int curMaxLen = Math.max(oddLen, evenLen);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * @param charArray 原始字符串的字符数组
     * @param left  起始左边界（可以取到）
     * @param right 起始右边界（可以取到）
     * @return 回文串的长度
     */
    private int expandAroundCenter(char[] charArray, int left, int right) {
        // 当 left = right 的时候，回文中心是一个字符，回文串的长度是奇数
        // 当 right = left + 1 的时候，此时回文中心两个字符，回文串的长度是偶数
        int len = charArray.length;
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (charArray[i] == charArray[j]) {
                --i;
                ++j;
            } else { break; }
        }
        // 跳出 while 循环，恰好满足 s.charAt(i) != s.charAt(j)
        // 回文串的长度是 j - i + 1 - 2 = j - i - 1
        return j - i - 1;
    }
}
