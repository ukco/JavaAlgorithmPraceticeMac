package com.lyr.test.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author lyr
 * @Date 1/22/21 6:39 PM
 * @Version 1.0
 * @Description 989. 数组形式的整数加法
 */
public class Solution989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        List<Integer> Alist = new ArrayList<>();
        List<Integer> Klist = new ArrayList<>();
        while (K != 0) {
            Klist.add(K % 10);
            K = K / 10;
        }
        for (int i = A.length - 1; i >= 0; --i) {
            Alist.add(A[i]);
        }
        int tmp = 0;
        int i = 0;
        for (; i < Alist.size() && i < Klist.size(); ++i) {
            int addtmp = Alist.get(i) + Klist.get(i) + tmp;
            if (addtmp >= 10) {
                res.add(addtmp % 10);
                tmp = addtmp / 10;
            } else {
                res.add(addtmp);
                tmp = 0;
            }
        }
        if (tmp > 0 && i >= Alist.size() && i >= Klist.size()) {
            res.add(tmp);
            tmp = 0;
        }
        if (i < Alist.size()) {
            for (int j = i; j < Alist.size(); ++j) {
                int addA = Alist.get(j) + tmp;
                if (addA >= 10) {
                    res.add(addA % 10);
                    tmp = addA / 10;
                } else {
                    res.add(addA);
                    tmp = 0;
                }
            }
        }
        if (i < Klist.size()) {
            for (int j = i; j < Klist.size(); ++j) {
                int add = Klist.get(j) + tmp;
                if (add >= 10) {
                    res.add(add % 10);
                    tmp = add / 10;
                } else {
                    res.add(add);
                    tmp = 0;
                }
            }
        }
        if (tmp != 0) {
            res.add(tmp);
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> addToArrayForm2(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int n = A.length;
        for (int i = n - 1; i >= 0; --i) {
            int sum = A[i] + K % 10;
            K /= 10;
            if (sum >= 10) {
                K++;
                sum -= 10;
            }
            res.add(sum);
        }
        for (; K > 0; K /= 10) {
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> addToArrayForm3(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int n = A.length;
        for (int i = n - 1; i >= 0 || K > 0; --i, K /= 10) {
            if (i >= 0) {
                K += A[i];
            }
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }
}
