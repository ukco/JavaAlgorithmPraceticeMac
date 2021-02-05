package com.lyr.test.algorithm.search;

/**
 * @Author lyr
 * @Date 2/5/21 8:13 PM
 * @Version 1.0
 * @Description 二分查找
 */
public class BinarySearch {
    public static int binarySearch(int[] nums, int endIndex, int target) {
        int low = 0, high = endIndex;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) { low = mid + 1; }
            else if (nums[mid] > target) { high = mid - 1; }
            else { return mid; }
        }
        return -1;
    }
}
