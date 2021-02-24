package com.lyr.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lyr
 * @Date 2/24/21 1:29 PM
 * @Version 1.0
 * @Description 4. 寻找两个正序数组的中位数
 */
public class Solution4 {
    /**
     * 初始方法，创建新数组保存拼接数据
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] array = new int[m + n];
        int rk1 = 0, rk2 = 0, index = 0;
        double res;
        while (rk1 < m && rk2 < n) {
            if (nums1[rk1] <= nums2[rk2]) {
                array[index] = nums1[rk1];
                ++rk1;
            } else {
                array[index] = nums2[rk2];
                ++rk2;
            }
            ++index;
        }
        if (rk1 < m) {
            while (rk1 < m) {
                array[index] = nums1[rk1];
                ++rk1;
                ++index;
            }
        }
        if (rk2 < n) {
            while (rk2 < n) {
                array[index] = nums2[rk2];
                ++rk2;
                ++index;
            }
        }
        if ((m + n) % 2 == 0) {
            res = (array[(m + n) / 2] + array[(m + n) / 2 - 1]) * 1.0 / 2;
        } else {
            res = array[(m + n) / 2] * 1.0;
        }
        return res;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        if (nums1 == null && nums2 == null) { return 0; }
        else if (nums1 == null) { return findMedian(nums2); }
        else if (nums2 == null) { return findMedian(nums1); }

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) { list.add(nums1[i++]); }
            else { list.add(nums2[j++]); }
        }
        if (i < nums1.length) {
            while (i < nums1.length) { list.add(nums1[i++]); }
        }
        if (j < nums2.length) {
            while (j < nums2.length) { list.add(nums2[j++]); }
        }
        int[] numsArray = new int[list.size()];
        for (int o = 0; o < list.size(); ++o) {
            numsArray[o] = list.get(o);
        }
        return findMedian(numsArray);
    }
    private double findMedian(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            i++;
            j--;
        }
        if (i == j) { return nums[i]; }
        else if (Math.abs(i - j) == 1) { return (nums[i] + nums[j]) / 2.0; }
        return 0;
    }

    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }
    private double getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) { return nums2[index2 + k - 1]; }
            if (index2 == length2) { return nums1[index1 + k - 1]; }
            if (k == 1) { return Math.min(nums1[index1], nums2[index2]); }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) { return findMedianSortedArrays4(nums2, nums1); }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m, ansi = -1;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                ansi = i;
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }

    public double findMedianSortedArrays5(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0) { return (left + right) / 2.0; }
        else { return right; }
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().findMedianSortedArrays(new int[] {1,2}, new int[] {3,4}));
    }
}
