package com.lyr.test.leetcode;

/**
 * @Author lyr
 * @Date 4/5/21 10:53 PM
 * @Version 1.0
 * @Description 88. 合并两个有序数组
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int index = nums1.length - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] >= nums2[index2]) { nums1[index--] = nums1[index1--]; }
            else { nums1[index--] = nums2[index2--]; }
        }
        if (index2 >= 0) { while (index2 >= 0) { nums1[index--] = nums2[index2--]; } }
    }
}
