package com.lyr.test.top200;

/**
 * @Author lyr
 * @Date 3/28/21 11:47 PM
 * @Version 1.0
 * @Description NC105. 二分查找
 */
public class NC105 {
    public int search (int[] nums, int target) {
        int index = -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                // 在 low 和 mid 之间找第一个下标
                index = mid;
                high = mid - 1;
            }
            else if (nums[mid] < target) { low = mid + 1;}
            else { high = mid - 1; }
        }
        return index;
    }
}
