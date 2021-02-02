package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 2/2/21 4:41 PM
 * @Version 1.0
 * @Description 424. 替换后的最长重复字符
 */
public class Solution424 {
    /**
     * 双指针
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        // left: 左边界，用于滑动时减去头部或者计算长度
        // right: 右边界，用于加上划窗尾巴或者计算长度
        int left = 0, right = 0;
        while (right < n) {
            int indexR = s.charAt(right) - 'A';
            num[indexR]++;
            // 求窗口中曾出现某字母的最大次数
            // 计算某字母出现在某窗口中的最大次数，窗口长度只大能增或者不变（注意后面left指针只移动了0-1次）
            // 这样做的意义：我们求的是最长，如果找不到更长的维持长度不变返回结果不受影响
            maxn = Math.max(maxn, num[indexR]);

            // 长度 len = right - left + 1,以下简称 len
            // len-字母出现最大次数 > 替换数目 => len > 字母出现最大次数+替换数目
            // 分析一下，替换数目是不变的=k,字母出现最大次数是可能变化的，因此，只有字母出现最大次数增加的情况，len 才能拿到最大值
            // 又不满足条件的情况下，left 和 right 一起移动, len 不变的
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
