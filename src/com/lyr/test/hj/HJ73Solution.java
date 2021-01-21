package com.lyr.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 1/21/21 8:36 PM
 * @Version 1.0
 * @Description HJ73. 计算日期到天数转换
 */
public class HJ73Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            String[] strs = str.split(" ");
            int year = Integer.parseInt(strs[0]);
            int month = Integer.parseInt(strs[1]);
            int day = Integer.parseInt(strs[2]);
            int res = day;
            for (int i = 1; i < month; i++) {
                res += getMonthDays(year, i);
            }
            System.out.println(res);
        }
    }
    private static int getMonthDays(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        if (month == 2) {
            return year % 4 == 0 ? 29 : 28;
        }
        return 30;
    }
}
