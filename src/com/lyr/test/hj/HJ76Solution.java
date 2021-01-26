package com.lyr.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 1/26/21 6:32 PM
 * @Version 1.0
 * @Description HJ76. 尼科彻斯定理
 * 首项是 a1 = m * m - (m - 1)，公差是 d = 2，共 m 项的和
 */
public class HJ76Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = read.readLine()) != null) {
            int m = Integer.parseInt(str);
            StringBuilder sb = new StringBuilder();
            int a1 = m * m - (m - 1);
            int d = 2;
            for (int i = 0; i < m; ++i) {
                sb.append(a1).append("+");
                a1 += d;
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }
}
