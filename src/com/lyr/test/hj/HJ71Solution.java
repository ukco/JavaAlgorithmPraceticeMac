package com.lyr.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 1/19/21 11:44 AM
 * @Version 1.0
 * @Description HJ71. 字符串通配符
 */
public class HJ71Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String regx;
        while ((regx = read.readLine()) != null) {
            String content = read.readLine();
            System.out.println(match(content.toCharArray(), 0, regx.toCharArray(), 0));
        }
    }
    private static boolean match(char[] content, int offsetContent, char[] regx, int offsetRegx) {
        while (offsetContent < content.length && offsetRegx < regx.length) {
            if ('*' == regx[offsetRegx]) {
                if (offsetRegx == regx.length - 1) { return true; }
                else if (isMatch(content[offsetContent], regx[offsetRegx + 1]) && match(content, offsetContent, regx, offsetRegx + 1)) {
                    return true;
                } else {
                    offsetContent++;
                }
            } else if ('?' == regx[offsetRegx] || content[offsetContent] == regx[offsetRegx]) {
                offsetContent++;
                offsetRegx++;
            } else {
                return false;
            }
        }
        return (offsetContent == content.length) && (offsetRegx == regx.length);
    }
    private static boolean isMatch(char contentChar, char regxChar) {
        return '*' == regxChar || '?' == regxChar || contentChar == regxChar;
    }
}
