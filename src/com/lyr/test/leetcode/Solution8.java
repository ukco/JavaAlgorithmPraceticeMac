package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 2/27/21 2:11 PM
 * @Version 1.0
 * @Description 8. 字符串转换整数（atoi）
 */
public class Solution8 {
    public int myAtoi(String s) {
        if(s.length() == 0) { return 0; }
        int start = 0, end = s.length();
        while (start < end && s.charAt(start) == ' ') { ++start; }
        if (start == end) { return 0; }
        if(s.charAt(start) == '-' || s.charAt(start) == '+') {
            if (start == end -1 ) {
                return 0;
            } else {
                if (!Character.isDigit(s.charAt(start + 1))) { return 0; }
            }
        } else if (!Character.isDigit(s.charAt(start))) { return 0; }

        StringBuilder sb = new StringBuilder();
        // 可能有符号，先存入sb
        sb.append(s.charAt(start++));
        while (start  < end && Character.isDigit(s.charAt(start))) {
            sb.append(s.charAt(start++));
        }
        if(sb.charAt(0) == '+') {
            return convertToInt(sb.substring(1, sb.length()), '+');
        } else if (sb.charAt(0) == '-') {
            return convertToInt(sb.substring(1, sb.length()), '-');
        } else {
            return convertToInt(sb.toString(), ' ');
        }
    }
    private int convertToInt(String sb, char flag) {
        int len = sb.length();
        int result = 0;

        for (int i = 0; i <= len - 1; i++) {
            if (result > (Integer.MAX_VALUE - (sb.charAt(i) - '0')) / 10) {
                if (flag == '-') {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            result = result * 10 + (sb.charAt(i) - '0');
        }
        if (flag == '+' || flag == ' ') {
            return result;
        } else {
            return -result;
        }
    }
}
