package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 2/18/21 6:59 PM
 * @Version 1.0
 * @Description 995. K连续位的最小翻转次数
 */
public class Solution995 {
    /**
     * 差分数组
     * @param A
     * @param K
     * @return
     */
    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; i++) {
            revCnt += diff[i];
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) { return -1; }
                ++ans;
                ++revCnt;
                --diff[i + K];
            }
        }
        return ans;
    }

    /**
     * 滑动窗口
     * @param A
     * @param K
     * @return
     */
    public int minKBitFlips2(int[] A, int K) {
        int n = A.length;
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= K && A[i - K] > 1) {
                revCnt ^= 1;
                // 复原数组元素，若允许修改数组 A，则可以省略
                A[i - K] -= 2;
            }
            if (A[i] == revCnt) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                revCnt ^= 1;
                A[i] += 2;
            }
        }
        return ans;
    }
}
