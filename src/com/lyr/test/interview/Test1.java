package com.lyr.test.interview;

import com.lyr.test.hashmap.Test;

/**
 * @Author lyr
 * @Date 2/27/21 8:19 PM
 * @Version 1.0
 * @Description 括号最长子序列
 *
 * 描述：给定一串由(、)、[、]、{、}组成的括号序列，输出最长的合法括号序列长度。合法括号序列定义如下：
 * 1. 空括号序列是合法的
 * 2. 若括号序列A合法，则(A)、[A]、{A}也是合法的
 * 3. 若括号序列A和B均合法，则AB也是合法的
 *
 * 输入：括号序列
 * 输出：最长合法序列长度
 *
 * 样例1
 * 输入: ({({(({()}})}{())})})[){{{([)()((()]]}])[{)]}{[}{)
 * 输出: 4
 */
public class Test1 {
    public int longestParenttheses(String s) {
        if (s == null) { return -1 ;}
        if (s.length() == 0) { return 0; }

        int len = s.length();

        int maxLen = -1;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            int curLen = expandAroudCenter(charArray, i, i + 1);
            if (curLen > maxLen) {
                maxLen = curLen;
            }
        }
        return maxLen;
    }
    private int expandAroudCenter(char[] charArray, int left, int right) {
        int len = charArray.length;
        int i = left;
        int j = right;

        while (i >= 0 && j < len) {
            if ((charArray[i] == '(' && charArray[j] == ')') ||
                    (charArray[i] == '[' && charArray[j] == ']') ||
                    (charArray[i] == '{') && charArray[j] == '}') {
                --i;
                ++j;
            } else { break; }
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.longestParenttheses("{([()])}"));
    }
}
