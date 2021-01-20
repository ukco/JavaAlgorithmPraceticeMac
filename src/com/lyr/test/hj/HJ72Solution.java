package com.lyr.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author lyr
 * @Date 1/20/21 7:50 PM
 * @Version 1.0
 * @Description HJ72. 百钱买百鸡
 */
public class HJ72Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while (read.readLine() != null) {
            for (int i = 0; i <= 20; ++i) {
                for (int j = 0; j <= 33; ++j) {
                    for (int k = 0; k <= 33; ++k) {
                        if ((i * 5 + j * 3 + k == 100) && (i + j + 3 * k) == 100) {
                            System.out.println(i + " " + j + " " + k * 3);
                        }
                    }
                }
            }
        }
    }
}
