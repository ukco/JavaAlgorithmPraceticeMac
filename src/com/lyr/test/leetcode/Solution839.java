package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 1/31/21 8:47 PM
 * @Version 1.0
 * @Description 839. 相似字符串组
 */
public class Solution839 {
    int[] f;

    /**
     * 并查集
     * @param strs
     * @return
     */
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int fi = find(i), fj = find(j);
                if (fi == fj) { continue; }
                if (check(strs[i], strs[j], m)) {
                    f[fi] = fj;
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (f[i] == i) {
                ++ret;
            }
        }
        return ret;
    }
    private int find(int x) {
        return f[x] == x ? x : (f[x] = find(f[x]));
    }
    private boolean check(String a, String b, int len) {
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                ++num;
                if (num > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
