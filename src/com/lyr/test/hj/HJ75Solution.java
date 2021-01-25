package com.lyr.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 1/25/21 5:16 PM
 * @Version 1.0
 * @Description HJ75. 公共子串计算
 */
public class HJ75Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str1;
        String str2;
        while ((str1 = read.readLine()) != null && (str2 = read.readLine()) != null) {
            char[] ch1 = str1.toCharArray();
            char[] ch2 = str2.toCharArray();
            System.out.println(func(ch1, ch2));
        }
    }
    private static int func(char[] ch1, char[] ch2) {
        int max = 0;
        for (int i = 0; i < ch1.length; ++i) {
            for (int j = 0; j < ch2.length; ++j) {
                int t1 = i;
                int count = 0;
                int t2 = j;
                while (ch1[t1] == ch2[t2]) {
                    ++count;
                    ++t1;
                    ++t2;
                    if (count > max) { max = count; }
                    if (t1 == ch1.length || t2 == ch2.length) {
                        break;
                    }
                }
            }
        }
        return max;
    }
}
