package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 2021-01-01 14:15
 * @Version 1.0
 * @Description 605. 种花问题
 */
public class Solution605 {
    /**
     * 初版本
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) { return false; }
        if (n == 0) { return true; }

        if (flowerbed.length == 1) {
            if ((flowerbed[0] == 1 && n == 0) || (flowerbed[0] == 0 && n == 1)) { return true; }
            else { return false; }
        }

        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                ++count;
                ++i;
            }
            if (i >= 1 && i < flowerbed.length - 1 && flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                flowerbed[i] = 1;
                ++count;
                i += 1;
            }
            if (i >= 1 && i == flowerbed.length - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                flowerbed[i] = 1;
                ++count;
            }
            if (count == n) { return true; }
        }
        return false;
    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) { count += i / 2; }
                else { count += (i - prev - 2) / 2; }
                if (count >= n) { return true; }
                prev = i;
            }
        }
        if (prev < 0) { count += (m + 1) / 2; }
        else { count += (m - prev - 1) / 2; }
        return count >= n;
    }

    public boolean canPlaceFlower3(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i += 2) {
            if (flowerbed[i] == 0) {
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) { --n; }
                else { ++i; }
            }
        }
        return n <= 0;
    }
}
