package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 2020-12-19 21:43
 * @Version 1.0
 * @Description 48. 旋转图像
 */
public class Solution48 {
    /**
     * 自外向内顺时针循环
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) { return; }
        int nums = matrix.length;
        int times = 0;
        while (times <= (nums >> 1)) {
            int len = nums - (times << 1);
            for (int i = 0; i < len - 1; ++i) {
                int temp = matrix[times][times + i];
                matrix[times][times + i] = matrix[times + len - i - 1][times];
                matrix[times + len - i - 1][times] = matrix[times + len - 1][times + len - i - 1];
                matrix[times + len - 1][times + len - i - 1] = matrix[times + i][times + len - 1];
                matrix[times + i][times + len - 1] = temp;
            }
            ++times;
        }
    }

    /**
     * 两次翻转
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) { return; }
        int nums = matrix.length;
        for (int i = 0; i < nums; ++i) {
            for (int j = 0; j < nums - i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[nums - 1 - j][nums - 1 - i];
                matrix[nums - 1 - j][nums - 1 - i] = temp;
            }
        }
        for (int i = 0; i < (nums >> 1); ++i) {
            for (int j = 0; j < nums; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[nums - 1 - i][j];
                matrix[nums - 1 - i][j] = temp;
            }
        }
    }
}
