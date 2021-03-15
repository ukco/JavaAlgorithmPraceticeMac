package com.lyr.test.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author lyr
 * @Date 3/15/21 9:51 PM
 * @Version 1.0
 * @Description 比特位翻转
 * 给定a、b、c三个数，问最少翻转a和b的多少个比特位，使得 a | b = c
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int[] aBinary = getBinary(a);
            int[] bBinary = getBinary(b);
            int[] cBinary = getBinary(c);
            int aLength = aBinary.length, bLength = bBinary.length, cLength = cBinary.length;
            int ai = aLength - 1, bi = bLength - 1, ci = cLength - 1;
            int ans = 0;
            while (ci >= 0 && bi >= 0 && ai >= 0) {
                if (cBinary[ci] == 1) {
                    if (aBinary[ai] == 0 && bBinary[bi] == 0) {
                        ans++;
                    }
                } else {
                    if (aBinary[ai] == 1 && bBinary[bi] == 1) {
                        ans += 2;
                    } else if ((aBinary[ai] == 1 && bBinary[bi] == 0) ||
                            (aBinary[ai] == 0 && bBinary[bi] == 1)) {
                        ans++;
                    }
                }
                --ci;
                --bi;
                --ai;
            }
            if (ci >= 0 && bi >= 0) {
                while (ci >= 0 && bi >= 0) {
                    if ((cBinary[ci] == 1 && bBinary[bi] == 0) || (cBinary[ci] == 0 && bBinary[bi] == 1)) {
                        ++ans;
                    }
                    --ci;
                    --bi;
                }
            }
            if (ci >= 0 && ai >= 0) {
                while (ci >= 0 && ai >= 0) {
                    if ((cBinary[ci] == 1 && aBinary[ai] == 0) || (cBinary[ci] == 0 && aBinary[ai] == 1)) {
                        ++ans;
                    }
                    --ci;
                    --ai;
                }
            }
            res[i] = ans;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }

    /**
     * 获取二进制数
     * @param x
     * @return
     */
    private static int[] getBinary(int x) {
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x & 1);
            x >>= 1;
        }
        int[] binary = new int[list.size()];
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            binary[i] = list.get(i);
        }
        return binary;
    }
}
