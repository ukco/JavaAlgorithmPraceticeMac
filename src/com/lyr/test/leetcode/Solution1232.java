package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 1/17/21 5:24 PM
 * @Version 1.0
 * @Description 1232. 缀点成线
 */
public class Solution1232 {
    public boolean  checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 1) { return true; }

        double k = 0;
        boolean flag = true;
        for (int i = 1; i < coordinates.length; ++i) {
            int xJudge = coordinates[i][0] - coordinates[i - 1][0];
            if (i == 1) {
                if (xJudge == 0) { flag = false; }
                else {
                    k = ((coordinates[1][1] - coordinates[0][1]) * 1.0 ) / xJudge;
                }
            } else {
                if (flag) {
                    if (xJudge == 0) { return false; }
                    else {
                        double tmp = ((coordinates[i][1] - coordinates[i - 1][1]) * 1.0 ) / (xJudge);
                        if (tmp != k) { return false; }
                    }
                } else {
                    if (xJudge != 0) { return false; }
                }
            }
        }
        return true;
    }
}
