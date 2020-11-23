package com.lyr.test.hj;

import java.io.InputStream;

/**
 * @Author lyr
 * @Date 2020-11-22 00:04
 * @Version 1.0
 * @Description 15.求int型数据在内存中存储时1的个数
 */
public class HJ15Solution {
    public static void main(String[] args) throws Exception {
        InputStream stream = System.in;
        int l;
        byte[] bytes = new byte[1024];
        while ((l = stream.read(bytes)) > 0) {
            String numStr = new String(bytes, 0, l - 1);
            int num = Integer.parseInt(numStr);
            char[] numChars = Integer.toBinaryString(num).toCharArray();
            int countNum = 0;
            for (int i = 0; i < numChars.length; ++i) {
                if (numChars[i] == '1') {
                    countNum += 1;
                }
            }
            System.out.println(countNum);
        }
    }

    /**
     * JZ11
     * @param n
     * @return
     */
    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
    public int numberOf12(int n) {
        return Integer.bitCount(n);
    }
    public int numberOf13(int n) {
        int mark = 1;
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            if ((mark & n) != 0) {
                ++ans;
            }
            mark <<= 1;
        }
        return ans;
    }
    public int numberOf14(int n) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            if ((n & 1) == 1) {
                ++ans;
            }
            n >>= 1;
        }
        return ans;
    }
}
