package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 1/26/21 4:48 PM
 * @Version 1.0
 * @Description 1128. 等价多米诺骨牌对的数量
 */
public class Solution1128 {
    /**
     * 二元祖表示 + 计数
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }
}
