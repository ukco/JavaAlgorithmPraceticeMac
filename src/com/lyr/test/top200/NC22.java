package com.lyr.test.top200;

import java.util.Arrays;

/**
 * @Author lyr
 * @Date 3/20/21 11:49 PM
 * @Version 1.0
 * @Description NC22. 合并两个有序的数组
 */
public class NC22 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 双指针
     * 从前往后
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int p1 = 0;
        int p2 = 0;
        int p = 0;

        while (p1 < m && p2 < n) {
            nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
        }

        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    /**
     * 双指针
     * 从后往前
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    /**
     * 终极
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge4(int[] nums1, int m, int[] nums2, int n) {
        int right = m + n - 1;
        int curA = m - 1;
        int curB = n - 1;

        while (curA >= 0 && curB >= 0) {
            nums1[right--] = nums1[curA] < nums2[curB] ? nums2[curB--] : nums1[curA--];
        }

        while (curB >= 0) { nums1[right--] = nums2[curB--]; }
    }
}
